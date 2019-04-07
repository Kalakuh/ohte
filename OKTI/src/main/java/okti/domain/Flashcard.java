package okti.domain;

import okti.db.DatabaseObject;

public class Flashcard extends DatabaseObject {
    private final String question;
    private final String answer;
    private final int deckId;
    
    /**
     * Constructor for a flashcard.
     * @param deckId Id of the deck
     * @param question Question as a string
     * @param answer Answer as a string
     */
    public Flashcard(int deckId, String question, String answer) {
        this.deckId = deckId;
        this.question = question;
        this.answer = answer;
    }
    
    /**
     * Getter for the question of the flashcard.
     * @return The question of the flashcard
     */
    public String getQuestion() {
        return this.question;
    }
    
    /**
     * Getter for the answer of the flashcard.
     * @return The answer of the flashcard
     */
    public String getAnswer() {
        return this.answer;
    }
    
    /**
     * Getter for the deck id of the flashcard.
     * @return The deck id of the flashcard
     */
    public int getDeckId() {
        return this.deckId;
    }
}
