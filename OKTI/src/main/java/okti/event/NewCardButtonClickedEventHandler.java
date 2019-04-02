package okti.event;

import java.sql.SQLException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.domain.Flashcard;
import okti.gui.App;
import okti.gui.DeckScene;

public class NewCardButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    private int deckId;
    
    public NewCardButtonClickedEventHandler(App app, int deckId) {
        this.app = app;
        this.deckId = deckId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        String question = app.promptString("Kortin kysymys");
        if (!question.isEmpty()) {
            String answer = app.promptString("Kortin vastaus");
            if (!answer.isEmpty()) {
                try {
                    app.getFlashcardDAO().saveOrUpdate(new Flashcard(deckId, question, answer));
                    app.setScene(new DeckScene(app, deckId));
                } catch (SQLException ex) {

                }
            }
        }
    }
}
