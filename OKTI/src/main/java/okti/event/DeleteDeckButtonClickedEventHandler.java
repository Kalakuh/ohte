package okti.event;

import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;
import okti.gui.MainScene;

/**
 * This class implements the event handler for deleting a deck when the corresponding button is clicked.
 */
public class DeleteDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    private int deckId;
    
    /**
     * Constructor for an event handler of a new deck button.
     * @param app The app object where the button is
     * @param deckId The id of the deck to be deleted
     */
    public DeleteDeckButtonClickedEventHandler(App app, int deckId) {
        this.app = app;
        this.deckId = deckId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        try {
            app.getDeckDAO().delete(deckId);
            app.setScene(new MainScene(app));
        } catch (SQLException ex) {

        }
    }
}
