package okti;

import okti.db.Database;
import okti.db.DeckDAO;
import okti.gui.App;

public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new Database("jdbc:sqlite:okti.db");
        DeckDAO deckDAO = new DeckDAO(database);
        App app = new App();
        app.setDeckDAO(deckDAO);
        app.launchApp();
    }
}
