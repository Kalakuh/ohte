package okti.event;

import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.domain.Deck;
import okti.gui.App;
import okti.gui.DeckScene;

public class NewDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    public NewDeckButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        String name = app.promptString("Anna pakalle nimi");
        if (!name.isEmpty()) {
            try {
                app.getDeckDAO().saveOrUpdate(new Deck(name));
                int deckId = app.getDeckDAO().findLast().getId();
                app.setScene(new DeckScene(app, deckId));
            } catch (SQLException ex) {
                
            }
        }
    }
}
