package okti.event;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.domain.Flashcard;
import okti.gui.App;
import okti.gui.DeckScene;

public class DeleteFlashcardButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private final App app;
    private final int flashcardId;
    
    /**
     * Mouse event handler for flashcard deletion button.
     * @param app App where the button is
     * @param flashcardId Id of the flashcard
     */
    public DeleteFlashcardButtonClickedEventHandler(App app, int flashcardId) {
        this.app = app;
        this.flashcardId = flashcardId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        try {
            Flashcard card = app.getFlashcardDAO().findOne(flashcardId);
            app.getFlashcardDAO().delete(flashcardId);
            app.setScene(new DeckScene(app, card.getDeckId()));
        } catch (SQLException ex) {
        
        }
    }
}
