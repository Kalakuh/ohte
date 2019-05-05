package okti.event;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import okti.domain.Flashcard;
import okti.gui.App;

/**
 * This class implements the event handler for responding to user's keyboard actions in the practice scene.
 */
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
            setText(cards.get(cardIndex).getQuestion());
        } else {
            setText(cards.get(cardIndex).getAnswer());
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
            setText(cards.get(cardIndex).getQuestion());
        }
    }
    
    /**
     * Sets the text of the practice scene.
     * @param text The new text
     */
    private void setText(String text) {
        cardText.setText(text);
        if (!text.matches(".*[0-9a-zA-ZåäöÅÄÖ].*") && text.length() <= 3) { // make for example short kanji strings larger
            cardText.setFont(new Font(100));
        } else {
            cardText.setFont(new Font(36));
        }
    }
}
