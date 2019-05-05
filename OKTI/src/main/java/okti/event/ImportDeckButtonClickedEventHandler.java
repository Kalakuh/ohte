package okti.event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import okti.domain.Deck;
import okti.domain.Flashcard;
import okti.gui.App;
import okti.gui.MainScene;

/**
 * This class implements the event handler for importing a deck when the corresponding button has been clicked.
 */
public class ImportDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    /**
     * Event handler for the import deck button.
     * @param app App where the button is
     */
    public ImportDeckButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Tuo pakka");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DCK", "*.dck"));
            File file = fileChooser.showOpenDialog(app.getStage());
            Scanner scanner = new Scanner(file);
            String name = scanner.nextLine();
            app.getDeckDAO().saveOrUpdate(new Deck(name, app.getCurrentUser().getId()));
            Deck deck = app.getDeckDAO().findLast();
            while (scanner.hasNextLine()) {
                String question = scanner.nextLine();
                String answer = scanner.nextLine();
                app.getFlashcardDAO().saveOrUpdate(new Flashcard(deck.getId(), question, answer));
            }
            app.setScene(new MainScene(app));
        } catch (Exception e) {
        }
    }
    
}
