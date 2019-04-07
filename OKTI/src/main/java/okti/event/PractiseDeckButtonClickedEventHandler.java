package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;
import okti.gui.PracticeScene;

public class PractiseDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    private int deckId;
    
    public PractiseDeckButtonClickedEventHandler(App app, int deckId) {
        this.app = app;
        this.deckId = deckId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(new PracticeScene(app, deckId));
    }
}
