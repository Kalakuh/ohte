package okti.event;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import okti.domain.Flashcard;
import okti.gui.App;

public class PracticeKeyboardEventHandler implements EventHandler<KeyEvent> {
    private List<Flashcard> cards;
    private boolean flipped; // false == question side, true == answer side
    private int cardIndex;
    private Text cardText;
    private App app;
    
    /**
     * Constructor for the keyboard event handler of the practice scene.
     * @param app App object of the scene
     * @param cards List of cards to be practiced
     * @param text Card text element of the scene
     */
    public PracticeKeyboardEventHandler(App app, List<Flashcard> cards, Text text) {
        this.flipped = false;
        this.cards = cards;
        this.cardIndex = 0;
        this.cardText = text;
        this.app = app;
    }
    
    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT:
                cards.add(cards.get(cardIndex)); // add current (failed) card to the end of the deck, and take next
            case RIGHT:
                next();
                break;
            case SPACE:
                flip();
                break;
            default:
                break;
        }
    }
    
    /**
     * Flips the current card: question side becomes answer side and vice versa.
     */
    private void flip() {
        if (flipped) {
            cardText.setText(cards.get(cardIndex).getQuestion());
        } else {
            cardText.setText(cards.get(cardIndex).getAnswer());
        }
        flipped = !flipped;
    }
    
    /**
     * If all cards have been practised return to the main menu. Otherwise take the next card in the queue.
     */
    private void next() {
        flipped = false;
        cardIndex++;
        if (cardIndex == cards.size()) {
            // return to main menu
            app.setScene(app.getMainScene());
        } else {
            cardText.setText(cards.get(cardIndex).getQuestion());
        }
    }
}
