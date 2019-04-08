package okti.domain;

import okti.db.DatabaseObject;

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
}
