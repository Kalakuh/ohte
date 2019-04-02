package okti.domain;

import okti.db.DatabaseObject;

public class Deck extends DatabaseObject {
    private String name;
    
    public Deck(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
