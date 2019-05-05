package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;
import okti.gui.RegisterScene;

/**
 * This class implements the event handler for going to the registration scene when the link has been clicked.
 */
public class GoToRegistrationButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    /**
     * Constructor for an event handler for moving from login scene to register scene.
     * @param app The app object where the button is
     */
    public GoToRegistrationButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(new RegisterScene(app));
    }
}
