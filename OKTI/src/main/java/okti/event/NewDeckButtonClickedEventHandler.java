package okti.event;

import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.domain.Deck;
import okti.gui.App;
import okti.gui.DeckScene;

public class NewDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    /**
     * Constructor for an event handler of a new deck button.
     * @param app The app object where the button is
     */
    public NewDeckButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        String name = app.promptString("Anna pakalle nimi");
        if (!name.isEmpty()) {
            try {
                app.getDeckDAO().saveOrUpdate(new Deck(name, app.getCurrentUser().getId()));
                int deckId = app.getDeckDAO().findLast().getId();
                app.setScene(new DeckScene(app, deckId));
            } catch (SQLException ex) {
                
            }
        }
    }
}
