package okti.gui;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import okti.db.DeckDAO;
import okti.db.FlashcardDAO;
import okti.db.UserDAO;
import okti.domain.User;

public class App extends Application {
    public static final double APP_WIDTH = 800;
    private static final double APP_HEIGHT = 600;
    private static final String APP_NAME = "OKTI";
    private static DeckDAO deckDAO;
    private static FlashcardDAO flashcardDAO;
    private static UserDAO userDAO;
    private MainScene mainScene;
    private Stage stage;
    private User currentUser;
    
    /**
     * Function that launches the app.
     */
    public void launchApp() {
        launch(App.class);
    }
    
    @Override
    public void start(Stage stage) {
        mainScene = new MainScene(this, deckDAO);
        
        this.stage = stage;
        this.stage.setTitle("OKTI");
        this.stage.setWidth(APP_WIDTH);
        this.stage.setHeight(APP_HEIGHT);
        this.stage.setScene((new LoginScene(this)).createScene()/*mainScene.createScene()*/);
        this.stage.show();
    }
    
    /**
     * Setter for the static deck DAO.
     * @param deckDAO The deck DAO of the app
     */
    public void setDeckDAO(DeckDAO deckDAO) {
        App.deckDAO = deckDAO;
    }
    
    /**
     * Setter for the static user DAO.
     * @param userDAO The user DAO of the app
     */
    public void setUserDAO(UserDAO userDAO) {
        App.userDAO = userDAO;
    }
    
    /**
     * Setter for the static flashcard DAO.
     * @param flashcardDAO The flashcard DAO of the app
     */
    public void setFlashcardDAO(FlashcardDAO flashcardDAO) {
        App.flashcardDAO = flashcardDAO;
    }
    
    /**
     * Setter for the scene of the app.
     * @param scene The scene of the app
     */
    public void setScene(AppScene scene) {
        stage.setScene(scene.createScene());
    }
    
    /**
     * Getter for the static deck DAO.
     * @return The deck DAO of the app
     */
    public DeckDAO getDeckDAO() {
        return App.deckDAO;
    }
    
    /**
     * Getter for the static user DAO.
     * @return The user DAO of the app
     */
    public UserDAO getUserDAO() {
        return App.userDAO;
    }
    
    /**
     * Getter for the static flashcard DAO.
     * @return The flashcard DAO of the app
     */
    public FlashcardDAO getFlashcardDAO() {
        return App.flashcardDAO;
    }
    
    /**
     * Getter for the main scene of the app.
     * @return The main scene of the app
     */
    public MainScene getMainScene() {
        return this.mainScene;
    }
    
    /**
     * Prompts the user for a string.
     * @param text Text of the prompt
     * @return Returns the input string or an empty string
     */
    public String promptString(String text) {
        TextInputDialog td = new TextInputDialog();
        td.setTitle(text);
        td.setHeaderText(null);
        td.setGraphic(null);
        Optional<String> result = td.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        return "";
    }

    /**
     * Setter for the current user.
     * @param user Current user of the app
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
}
