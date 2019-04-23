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
import okti.event.DeleteDeckButtonClickedEventHandler;
import okti.event.EditDeckButtonClickedEventHandler;
import okti.event.ExportDeckButtonClickedEventHandler;
import okti.event.ImportDeckButtonClickedEventHandler;
import okti.event.NewDeckButtonClickedEventHandler;
import okti.event.PractiseDeckButtonClickedEventHandler;

public class MainScene extends AppScene {
    private static final int COLUMNS = 4;
    private final int cellSize;
    private final double heightRatio = 1.0 / 3;
    
    /**
     * Constructor for a deck practise scene.
     * @param app App in which the scene is
     * @param deckDAO deck DAO of the app
     */
    public MainScene(App app) {
        super(app);
        this.cellSize = (int) (App.APP_WIDTH / COLUMNS);
    }

    /**
     * Add deck buttons to the grid.
     * @param grid The grid of the scene
     * @param decks List of the decks.
     */
    private void addDeckButtons(GridPane grid, List<Deck> decks) {
        int x = 0;
        int y = 0;
        for (Deck deck : decks) {
            Button button = new Button(deck.getName());
            button.setMinWidth(cellSize);
            button.setMinHeight(cellSize);
            button.setOnMouseClicked(new PractiseDeckButtonClickedEventHandler(super.getApp(), deck.getId()));
            grid.add(button, 3 * x, 2 * y, 3, 1);
            x = (x + 1) % COLUMNS;
            if (x == 0) {
                y++;
            }
        }
        Button newDeckButton = new Button("Uusi pakka");
        newDeckButton.setMinWidth(cellSize);
        newDeckButton.setMinHeight(cellSize);
        newDeckButton.setOnMouseClicked(new NewDeckButtonClickedEventHandler(super.getApp()));
        grid.add(newDeckButton, 3 * x, 2 * y, 3, 1);
        Button importButton = new Button("Tuo pakka");
        importButton.setMinWidth(cellSize);
        importButton.setMinHeight(cellSize * heightRatio);
        importButton.setOnMouseClicked(new ImportDeckButtonClickedEventHandler(super.getApp()));
        grid.add(importButton, 3 * x, 2 * y + 1);
    }
    
    /**
     * Add edit buttons to the grid.
     * @param grid The grid of the scene
     * @param decks List of the decks.
     */
    private void addEditButtons(GridPane grid, List<Deck> decks) {
        int x = 0;
        int y = 0;
        for (Deck deck : decks) {
            Button edit = new Button("Muokkaa");
            edit.setMinWidth(cellSize / 3);
            edit.setMinHeight(cellSize * heightRatio);
            edit.setOnMouseClicked(new EditDeckButtonClickedEventHandler(super.getApp(), deck.getId()));
            grid.add(edit, 3 * x, 2 * y + 1);
            Button delete = new Button("Poista");
            delete.setMinWidth(cellSize / 3);
            delete.setMinHeight(cellSize * heightRatio);
            delete.setOnMouseClicked(new DeleteDeckButtonClickedEventHandler(super.getApp(), deck.getId()));
            grid.add(delete, 3 * x + 1, 2 * y + 1);
            Button exportButton = new Button("Vie");
            exportButton.setMinWidth(cellSize / 3);
            exportButton.setMinHeight(cellSize * heightRatio);
            exportButton.setOnMouseClicked(new ExportDeckButtonClickedEventHandler(super.getApp(), deck.getId()));
            grid.add(exportButton, 3 * x + 2, 2 * y + 1);
            x = (x + 1) % COLUMNS;
            if (x == 0) {
                y++;
            }
        }
    }
    
    @Override
    public Scene createScene() {
        List<Deck> decks;
        GridPane grid = new GridPane();
        
        for (int i = 0; i < 3 * COLUMNS; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(cellSize / 3));
        }
        
        decks = super.getApp().getDeckDAO().findByUserId(super.getApp().getCurrentUser().getId());
        
        addDeckButtons(grid, decks);
        addEditButtons(grid, decks);
        
        return new Scene(grid);
    }
}
