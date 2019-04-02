package okti.gui;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import okti.db.DeckDAO;
import okti.db.FlashcardDAO;

public class App extends Application {
    public static double APP_WIDTH = 800;
    private static double APP_HEIGHT = 600;
    private static final String APP_NAME = "OKTI";
    private static DeckDAO deckDAO;
    private static FlashcardDAO flashcardDAO;
    private MainScene mainScene;
    private Stage stage;
    
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
        this.stage.setScene(mainScene.createScene());
        this.stage.show();
    }
    
    public void setDeckDAO(DeckDAO deckDAO) {
        App.deckDAO = deckDAO;
    }
    
    public void setFlashcardDAO(FlashcardDAO flashcardDAO) {
        App.flashcardDAO = flashcardDAO;
    }
    
    public void setScene(AppScene scene) {
        stage.setScene(scene.createScene());
    }
    
    public DeckDAO getDeckDAO() {
        return App.deckDAO;
    }
    
    public FlashcardDAO getFlashcardDAO() {
        return App.flashcardDAO;
    }
    
    public MainScene getMainScene() {
        return this.mainScene;
    }
    
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
}
