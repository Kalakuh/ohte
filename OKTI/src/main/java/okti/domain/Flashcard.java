package okti.domain;

import okti.db.DatabaseObject;

public class Flashcard extends DatabaseObject {
    private final String question;
    private final String answer;
    private final int deckId;
    
    public Flashcard(int deckId, String question, String answer) {
        this.deckId = deckId;
        this.question = question;
        this.answer = answer;
    }
    
    public String getQuestion() {
        return this.question;
    }
    
    public String getAnswer() {
        return this.answer;
    }
    
    public int getDeckId() {
        return this.deckId;
    }
}
