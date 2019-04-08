package okti.domain;

import java.sql.SQLException;
import java.util.List;
import okti.db.Database;
import okti.db.DatabaseObject;
import okti.db.FlashcardDAO;

public class Deck extends DatabaseObject {
    private String name;
    
    /**
     * Constructor for Deck objects.
     * @param name Name of the deck
     */
    public Deck(String name) {
        this.name = name;
    }
    
    /**
     * Getter for the name of the deck.
     * @return The name of the deck
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Setter for the name of the deck.
     * @param name The name of the deck
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void onDeletion(Database db) {
        FlashcardDAO dao = new FlashcardDAO(db);
        List<Flashcard> cards = dao.findByDeckId(super.getId());
        for (Flashcard card : cards) {
            try {
                dao.delete(card.getId());
            } catch (SQLException ex) {
                
            }
        }
    }
}
