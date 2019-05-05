package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;

/**
 * This class implements the event handler for going back to the main menu when the button is clicked.
 */
public class ReturnToMainMenuButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    /**
     * Constructor for an event handler of a return to main menu button.
     * @param app The app object where the button is
     */
    public ReturnToMainMenuButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(app.getMainScene());
    }
}
