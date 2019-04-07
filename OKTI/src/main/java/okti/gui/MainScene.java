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
import okti.event.PractiseDeckButtonClickedEventHandler;

public class MainScene extends AppScene {
    private static final int COLUMNS = 5;
    private final int cellSize;
    private DeckDAO deckDAO;
    
    /**
     * Constructor for a deck practise scene.
     * @param app App in which the scene is
     * @param deckDAO deck DAO of the app
     */
    public MainScene(App app, DeckDAO deckDAO) {
        super(app);
        this.deckDAO = deckDAO;
        this.cellSize = (int) (App.APP_WIDTH / COLUMNS);
    }

    /**
     * Add deck buttons to the grid.
     * @param grid The grid of the scene
     * @param decks List of the decks.
     */
    private void addButtons(GridPane grid, List<Deck> decks) {
        int x = 0;
        int y = 0;
        for (Deck deck : decks) {
            Button button = new Button(deck.getName());
            button.setMinWidth(cellSize);
            button.setMinHeight(cellSize);
            button.setOnMouseClicked(new PractiseDeckButtonClickedEventHandler(super.getApp(), deck.getId()));
            grid.add(button, x, y);
            x = (x + 1) % 5;
            if (x == 0) {
                y++;
            }
        }
        Button newDeckButton = new Button("Uusi pakka");
        newDeckButton.setMinWidth(cellSize);
        newDeckButton.setMinHeight(cellSize);
        newDeckButton.setOnMouseClicked(new NewDeckButtonClickedEventHandler(super.getApp()));
        grid.add(newDeckButton, x, y);
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
        
        addButtons(grid, decks);
        
        return new Scene(grid);
    }
}
