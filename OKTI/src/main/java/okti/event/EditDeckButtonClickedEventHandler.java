package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;
import okti.gui.DeckScene;

/**
 * This class implements the event handler for moving to the deck editing scene when the corresponding button is clicked.
 */
public class EditDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    private int deckId;
    
    /**
     * Constructor for an event handler of a edit deck button.
     * @param app The app object where the button is
     * @param deckId The id of the deck to be edited
     */
    public EditDeckButtonClickedEventHandler(App app, int deckId) {
        this.app = app;
        this.deckId = deckId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(new DeckScene(app, deckId));
    }
}
