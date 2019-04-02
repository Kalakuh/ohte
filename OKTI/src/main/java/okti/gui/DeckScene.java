package okti.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class DeckScene extends AppScene {
    public DeckScene(App app) {
        super(app);
    }
    
    @Override
    public Scene createScene() {
        GridPane grid = new GridPane();
        Button newDeckButton = new Button("Hello World!");
        grid.add(newDeckButton, 0, 0);
        
        return new Scene(grid);
    }
}
