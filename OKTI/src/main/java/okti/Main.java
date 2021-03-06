package okti;

import okti.db.Database;
import okti.db.DeckDAO;
import okti.db.FlashcardDAO;
import okti.db.UserDAO;
import okti.gui.App;

public class Main {
    
    /**
     * Main function of the program. Initializes database related objects and launches the app.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new Database("jdbc:sqlite:okti.db");
        DeckDAO deckDAO = new DeckDAO(database);
        FlashcardDAO flashcardDAO = new FlashcardDAO(database);
        UserDAO userDAO = new UserDAO(database);
        
        App app = new App();
        app.setDeckDAO(deckDAO);
        app.setFlashcardDAO(flashcardDAO);
        app.setUserDAO(userDAO);
        app.launchApp();
    }
}
