package okti.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import okti.db.DeckDAO;
import okti.domain.Deck;
import okti.event.NewDeckButtonClickedEventHandler;

public class MainScene extends AppScene {
    private static final int COLUMNS = 5;
    private final int cellSize;
    private DeckDAO deckDAO;
    
    public MainScene(App app, DeckDAO deckDAO) {
        super(app);
        this.deckDAO = deckDAO;
        this.cellSize = (int) (App.APP_WIDTH / COLUMNS);
    }

    @Override
    public Scene createScene() {
        List<Deck> decks;
        GridPane grid = new GridPane();
        
        for (int i = 0; i < COLUMNS; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(cellSize));
        }
        
        try {
            decks = deckDAO.findAll();
        } catch (SQLException ex) {
            decks = new ArrayList<>();
        }
        
        int x = 0;
        int y = 0;
        for (Deck deck : decks) {
            Button button = new Button(deck.getName());
            button.setMinWidth(cellSize);
            button.setMinHeight(cellSize);
            grid.add(button, x, y);
            x++;
            if (x % 5 == 0) {
                y++;
                x = 0;
            }
        }
        Button newDeckButton = new Button("Uusi pakka");
        newDeckButton.setMinWidth(cellSize);
        newDeckButton.setMinHeight(cellSize);
        newDeckButton.setOnMouseClicked(new NewDeckButtonClickedEventHandler(super.getApp()));
        grid.add(newDeckButton, x, y);
        
        return new Scene(grid);
    }
}
