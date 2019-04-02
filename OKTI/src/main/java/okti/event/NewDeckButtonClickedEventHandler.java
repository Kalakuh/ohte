package okti.event;

import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import okti.gui.App;

public class NewDeckButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    public NewDeckButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        String name = app.promptString("Anna pakalle nimi");
        
        if (!name.isEmpty()) {
            app.setScene(app.getDeckScene());
        }
    }
}
