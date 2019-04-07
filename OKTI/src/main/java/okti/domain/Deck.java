package okti.domain;

import okti.db.DatabaseObject;

public class Deck extends DatabaseObject {
    private final String name;
    
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
}
