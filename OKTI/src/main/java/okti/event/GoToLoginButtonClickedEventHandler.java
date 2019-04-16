package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;
import okti.gui.LoginScene;

public class GoToLoginButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    /**
     * Constructor for an event handler for moving from register scene to login scene.
     * @param app The app object where the button is
     */
    public GoToLoginButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(new LoginScene(app));
    }
}
