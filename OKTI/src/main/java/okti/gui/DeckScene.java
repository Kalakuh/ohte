package okti.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import okti.event.ReturnToMainMenuButtonClickedEventHandler;

public class DeckScene extends AppScene {
    public DeckScene(App app) {
        super(app);
    }
    
    @Override
    public Scene createScene() {
        GridPane grid = new GridPane();
        Button mainReturnButton = new Button("Palaa päävalikkoon");
        mainReturnButton.setOnMouseClicked(new ReturnToMainMenuButtonClickedEventHandler(super.getApp()));
        grid.add(mainReturnButton, 0, 0);
        
        return new Scene(grid);
    }
}
