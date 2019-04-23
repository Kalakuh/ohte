package okti.event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import okti.domain.Deck;
import okti.domain.Flashcard;
import okti.gui.App;

public class ExportDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    private int deckId;
    
    /**
     * Event handler for the button for exporting a deck.
     * @param app App where the button is
     * @param deckId Id of the deck that we are exporting
     */
    public ExportDeckButtonClickedEventHandler(App app, int deckId) {
        this.app = app;
        this.deckId = deckId;
    }
    
    @Override
    public void handle(MouseEvent t) {
        try {
            Deck deck = app.getDeckDAO().findOne(deckId);
            String name = deck.getName();
            String output = name + "\n";
            List<Flashcard> cards = app.getFlashcardDAO().findByDeckId(deckId);
            for (Flashcard card : cards) {
                output += card.getQuestion() + "\n";
                output += card.getAnswer() + "\n";
            }
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Tallenna pakka");
            File file = fileChooser.showSaveDialog(app.getStage());
            if (!file.getAbsolutePath().endsWith(".dck")) {
                file = new File(file.getAbsolutePath() + ".dck");
            }
            FileWriter fw = new FileWriter(file);
            fw.write(output);
            fw.close();
        } catch (Exception e) {
        }
    }
}
