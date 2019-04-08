package okti.gui;

import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import okti.domain.Flashcard;
import okti.event.PracticeKeyboardEventHandler;
import okti.event.ReturnToMainMenuButtonClickedEventHandler;
import okti.util.ArrayUtil;

public class PracticeScene extends AppScene {
    private final int deckId;
    private final static int PRACTICE_SET_SIZE = 10;
    
    /**
     * Constructor for a deck practice scene.
     * @param app App in which the scene is
     * @param deckId Id of the deck
     */
    public PracticeScene(App app, int deckId) {
        super(app);
        this.deckId = deckId;
    }
    
    @Override
    public Scene createScene() {
        GridPane grid = new GridPane();
        
        Button mainReturnButton = new Button("Palaa päävalikkoon");
        mainReturnButton.setOnMouseClicked(new ReturnToMainMenuButtonClickedEventHandler(super.getApp()));
        mainReturnButton.setFocusTraversable(false);
        grid.add(mainReturnButton, 0, 0);
        
        Text kysymysText = new Text("Kysymys");
        kysymysText.setUnderline(true);
        grid.add(kysymysText, 0, 1);
        
        Text vastausText = new Text("Vastaus");
        vastausText.setUnderline(true);
        grid.add(vastausText, 1, 1);
        
        List<Flashcard> cards = ArrayUtil.selectRandomSubsetOfSizeN(super.getApp().getFlashcardDAO().findByDeckId(deckId), PRACTICE_SET_SIZE);
        
        for (int y = 0; y < cards.size(); y++) {
            grid.add(new Text(cards.get(y).getQuestion()), 0, y + 2);
            grid.add(new Text(cards.get(y).getAnswer()), 1, y + 2);
        }
        Scene scene = new Scene(grid);
        scene.setOnKeyPressed(new PracticeKeyboardEventHandler());
        return scene;
    }
}
