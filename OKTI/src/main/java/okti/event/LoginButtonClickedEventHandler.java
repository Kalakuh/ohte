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
 * This class implements the event handler for logging in when login button has been clicked.
 */
public class LoginButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private final App app;
    private final TextField usernameField;
    private final TextField passwordField;
    private final Text errorText;
    
    /**
     * Constructor for an event handler of the login button.
     * @param app The app object where the button is
     * @param usernameField The field that contains the username
     * @param passwordField The field that contains the password
     * @param errorText The text for error messages
     */
    public LoginButtonClickedEventHandler(App app, TextField usernameField, TextField passwordField, Text errorText) {
        this.app = app;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.errorText = errorText;
    }
    
    @Override
    public void handle(MouseEvent t) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        try {
            List<User> users = app.getUserDAO().findAll();
            for (User user : users) {
                if (user.getUsername().equals(username) && user.checkPassword(password)) {
                    app.setCurrentUser(user);
                    app.setScene(app.getMainScene());
                }
            }
            errorText.setText("Käyttäjänimi ja salasana eivät täsmää.");
        } catch (SQLException ex) {
            errorText.setText("Tuntematon virhe tapahtui.");
        }
    }
}
