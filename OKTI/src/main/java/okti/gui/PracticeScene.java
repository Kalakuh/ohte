package okti.gui;

import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import okti.domain.Flashcard;
import okti.event.NewCardButtonClickedEventHandler;
import okti.event.ReturnToMainMenuButtonClickedEventHandler;

public class PracticeScene extends AppScene {
    private final int deckId;
    
    public PracticeScene(App app, int deckId) {
        super(app);
        this.deckId = deckId;
    }
    
    @Override
    public Scene createScene() {
        GridPane grid = new GridPane();
        Button mainReturnButton = new Button("Palaa päävalikkoon");
        mainReturnButton.setOnMouseClicked(new ReturnToMainMenuButtonClickedEventHandler(super.getApp()));
        grid.add(mainReturnButton, 0, 0);
        
        Text kysymysText = new Text("Kysymys");
        kysymysText.setUnderline(true);
        grid.add(kysymysText, 0, 1);
        
        Text vastausText = new Text("Vastaus");
        vastausText.setUnderline(true);
        grid.add(vastausText, 1, 1);
        
        List<Flashcard> cards = super.getApp().getFlashcardDAO().findByDeckId(deckId);
        
        for (int y = 0; y < cards.size(); y++) {
            grid.add(new Text(cards.get(y).getQuestion()), 0, y + 2);
            grid.add(new Text(cards.get(y).getAnswer()), 1, y + 2);
        }
        
        return new Scene(grid);
    }
}
