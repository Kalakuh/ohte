package okti.gui;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import okti.db.Database;
import okti.db.DeckDAO;

public class App extends Application {
    public static double APP_WIDTH = 800;
    private static double APP_HEIGHT = 600;
    private static final String APP_NAME = "OKTI";
    private static DeckDAO deckDAO;
    private MainScene mainScene;
    private DeckScene deckScene;
    private Stage stage;
    
    public void launchApp() {
        launch(App.class);
    }
    
    @Override
    public void start(Stage stage) {
        mainScene = new MainScene(this, deckDAO);
        deckScene = new DeckScene(this);
        
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
    
    public void setScene(AppScene scene) {
        stage.setScene(scene.createScene());
    }
    
    public DeckScene getDeckScene() {
        return this.deckScene;
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
