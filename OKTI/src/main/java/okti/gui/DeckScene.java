package okti.gui;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import okti.domain.Flashcard;
import okti.event.DeleteFlashcardButtonClickedEventHandler;
import okti.event.NewCardButtonClickedEventHandler;
import okti.event.ReturnToMainMenuButtonClickedEventHandler;

public class DeckScene extends AppScene {
    private final int deckId;
    
    /**
     * Constructor for a deck editing scene.
     * @param app App in which the scene is
     * @param deckId Id of the deck
     */
    public DeckScene(App app, int deckId) {
        super(app);
        this.deckId = deckId;
    }
    
    /**
     * Adds default buttons and texts.
     * @param pane Pane of the scene
     */
    private void addDefaultElements(BorderPane pane) {
        Button mainReturnButton = new Button("Palaa päävalikkoon");
        mainReturnButton.setOnMouseClicked(new ReturnToMainMenuButtonClickedEventHandler(super.getApp()));
        HBox mainReturn = new HBox();
        mainReturn.getChildren().add(mainReturnButton);
        mainReturn.setMaxWidth(200);
        
        Button newCardButton = new Button("Lisää kortti");
        newCardButton.setOnMouseClicked(new NewCardButtonClickedEventHandler(super.getApp(), deckId));
        HBox newCard = new HBox();
        newCard.getChildren().add(newCardButton);
        newCard.setMaxWidth(100);
        
        HBox filler = new HBox();
        filler.setMinWidth(200);
        
        HBox buttonContainer = new HBox();
        buttonContainer.getChildren().addAll(mainReturn, filler, newCard);
        
        pane.setTop(buttonContainer);
    }
    
    @Override
    public Scene createScene() {
        BorderPane pane = new BorderPane();
        
        addDefaultElements(pane);
        
        List<Flashcard> cards = super.getApp().getFlashcardDAO().findByDeckId(deckId);
        
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        VBox questions = new VBox();
        questions.setSpacing(10);
        VBox answers = new VBox();
        answers.setSpacing(10);
        VBox deleteButtons = new VBox();
        
        VBox deleteFiller = new VBox();
        deleteFiller.setMinHeight(20);
        deleteButtons.getChildren().add(deleteFiller);
        
        Text questionText = new Text("Kysymys");
        questionText.setUnderline(true);
        questions.getChildren().add(questionText);
        
        Text answerText = new Text("Vastaus");
        answerText.setUnderline(true);
        answers.getChildren().add(answerText);
        
        for (int y = 0; y < cards.size(); y++) {
            questions.getChildren().add(new Text(cards.get(y).getQuestion()));
            answers.getChildren().add(new Text(cards.get(y).getAnswer()));
            Button delete = new Button("Poista");
            delete.setOnMouseClicked(new DeleteFlashcardButtonClickedEventHandler(super.getApp(), cards.get(y).getId()));
            deleteButtons.getChildren().add(delete);
        }
        
        VBox filler1 = new VBox();
        filler1.setMinWidth(10);
        VBox filler2 = new VBox();
        filler2.setMinWidth(10);
        
        container.getChildren().addAll(questions, filler1, answers, filler2, deleteButtons);
        
        pane.setCenter(container);
        
        return new Scene(pane);
    }
}
