package okti.event;

import java.sql.SQLException;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import okti.domain.User;
import okti.gui.App;

/**
 * This class implements the event handler for registering a new account when the button has been clicked.
 */
public class RegisterButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private final App app;
    private final TextField usernameField;
    private final TextField passwordField;
    private final Text errorText;
    
    /**
     * Constructor for an event handler of the create new account button.
     * @param app The app object where the button is
     * @param usernameField The field that contains the username
     * @param passwordField The field that contains the password
     * @param errorText The text for error messages
     */
    public RegisterButtonClickedEventHandler(App app, TextField usernameField, TextField passwordField, Text errorText) {
        this.app = app;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.errorText = errorText;
    }
    
    @Override
    public void handle(MouseEvent t) {
        String username = usernameField.getText();
        if (username.isEmpty()) {
            errorText.setText("Käyttäjänimi ei saa olla tyhjä.");
        } else if (passwordField.getText().isEmpty()) {
            errorText.setText("Salasana ei saa olla tyhjä.");
        } else {
            try {
                if (!userIsInDatabase(username, app)) {
                    app.getUserDAO().saveOrUpdate(new User(username, passwordField.getText()));
                    app.setCurrentUser(app.getUserDAO().findLast());
                    app.setScene(app.getMainScene());
                } else {
                    errorText.setText("Käyttäjänimi on jo käytössä.");
                }
            } catch (SQLException ex) {
                errorText.setText("Tuntematon virhe tapahtui.");
            }
        }
    }
    
    /**
     * Checks if the username is already in use.
     * @param username Username to be checked
     * @param app App object where the button is
     * @return true if user exists, false otherwise
     * @throws SQLException Exception is thrown if SQL error happens.
     */
    private boolean userIsInDatabase(String username, App app) throws SQLException {
        List<User> users = app.getUserDAO().findAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
