package okti;

import okti.db.Database;
import okti.db.DeckDAO;
import okti.db.FlashcardDAO;
import okti.gui.App;

public class Main {
    
    /**
     * Main function of the program.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new Database("jdbc:sqlite:okti.db");
        DeckDAO deckDAO = new DeckDAO(database);
        FlashcardDAO flashcardDAO = new FlashcardDAO(database);
        
        App app = new App();
        app.setDeckDAO(deckDAO);
        app.setFlashcardDAO(flashcardDAO);
        app.launchApp();
    }
}
