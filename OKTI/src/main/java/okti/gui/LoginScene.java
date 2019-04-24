package okti.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import okti.event.GoToRegistrationButtonClickedEventHandler;
import okti.event.LoginButtonClickedEventHandler;

public class LoginScene extends AppScene {
    
    /**
     * Constructor for a login scene.
     * @param app App in which the scene is
     */
    public LoginScene(App app) {
        super(app);
    }
    
    @Override
    public Scene createScene() {
        BorderPane pane = new BorderPane();
        
        VBox loginAndErrorContainer = new VBox();
        loginAndErrorContainer.setMaxWidth(300);
        loginAndErrorContainer.setMaxHeight(200);
        loginAndErrorContainer.setSpacing(15);
        
        HBox loginContainer = new HBox();
        
        VBox labels = new VBox();
        VBox fields = new VBox();
        
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        
        Button loginButton = new Button("Kirjaudu sisään");
        
        VBox filler = new VBox();
        VBox filler2 = new VBox();
        filler2.setMinHeight(7);
        VBox filler3 = new VBox();
        filler3.setMinHeight(15);
        labels.getChildren().addAll(filler, new Label("Käyttäjänimi: "), new Label("Salasana: "));
        fields.getChildren().addAll(usernameField, passwordField, filler2, loginButton);
        
        labels.setSpacing(10);
        
        labels.setAlignment(Pos.BASELINE_LEFT);
        fields.setAlignment(Pos.BASELINE_RIGHT);
        
        loginContainer.getChildren().addAll(labels, fields);
        
        Text errorText = new Text("");
        errorText.setFill(Color.RED);
        
        Hyperlink register = new Hyperlink("Ei tunnusta? Luo sellainen tästä!");
        register.setOnMouseClicked(new GoToRegistrationButtonClickedEventHandler(super.getApp()));
        
        loginAndErrorContainer.getChildren().addAll(loginContainer, errorText, register);
        
        loginButton.setOnMouseClicked(new LoginButtonClickedEventHandler(super.getApp(), usernameField, passwordField, errorText));
        
        pane.setCenter(loginAndErrorContainer);
        
        Scene scene = new Scene(pane);
        return scene;
    }
}
