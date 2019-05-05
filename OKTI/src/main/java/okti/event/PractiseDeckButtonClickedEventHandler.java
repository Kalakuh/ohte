package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;
import okti.gui.PracticeScene;

/**
 * This class implements the event handler going to the practice scene when the button has been clicked.
 */
public class PractiseDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    private int deckId;
    
    /**
     * Constructor for an event handler of a practise deck button.
     * @param app The app object where the button is
     * @param deckId The id of the deck
     */
    public PractiseDeckButtonClickedEventHandler(App app, int deckId) {
        this.app = app;
        this.deckId = deckId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(new PracticeScene(app, deckId));
    }
}
