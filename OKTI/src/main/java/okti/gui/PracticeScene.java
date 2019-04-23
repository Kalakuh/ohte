package okti.gui;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        BorderPane pane = new BorderPane();
        
        Button mainReturnButton = new Button("Palaa päävalikkoon");
        mainReturnButton.setOnMouseClicked(new ReturnToMainMenuButtonClickedEventHandler(super.getApp()));
        mainReturnButton.setFocusTraversable(false);
        pane.setTop(mainReturnButton);
        
        List<Flashcard> cards = ArrayUtil.selectRandomSubsetOfSizeN(super.getApp().getFlashcardDAO().findByDeckId(deckId), PRACTICE_SET_SIZE);
        
        Text cardText = new Text(cards.get(0).getQuestion());
        if (!cards.get(0).getQuestion().matches(".*[0-9a-zA-ZåäöÅÄÖ].*") && cards.get(0).getQuestion().length() <= 3) { // make for example short kanji strings larger
            cardText.setFont(new Font(100));
        } else {
            cardText.setFont(new Font(36));
        }
        VBox vbox = new VBox();
        vbox.getChildren().addAll(cardText);
        vbox.setAlignment(Pos.CENTER_LEFT);
        pane.setCenter(cardText);
        
        Text instructions = new Text("Paina välilyöntiä kääntääksesi kortin.\nPaina oikeaa nuolinäppäintä jos osaat kortin.\nPaina vasenta nuolinäppäintä jos et osannut korttia.");
        pane.setBottom(instructions);
        
        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(new PracticeKeyboardEventHandler(super.getApp(), cards, cardText));
        return scene;
    }
}
