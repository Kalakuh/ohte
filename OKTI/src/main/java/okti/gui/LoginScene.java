package okti.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
        
        HBox loginContainer = new HBox();
        loginContainer.setMaxWidth(300);
        loginContainer.setMaxHeight(200);
        
        VBox labels = new VBox();
        VBox fields = new VBox();
        
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        
        VBox filler = new VBox();
        labels.getChildren().addAll(filler, new Label("Käyttäjänimi: "), new Label("Salasana: "));
        fields.getChildren().addAll(usernameField, passwordField);
        
        labels.setSpacing(10);
        
        labels.setAlignment(Pos.BASELINE_LEFT);
        fields.setAlignment(Pos.BASELINE_RIGHT);
        
        loginContainer.getChildren().addAll(labels, fields);
        pane.setCenter(loginContainer);
        
        Scene scene = new Scene(pane);
        return scene;
    }
}
