package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import okti.gui.App;

public class ReturnToMainMenuButtonClickedEventHandler implements EventHandler<MouseEvent> {
    private App app;
    
    public ReturnToMainMenuButtonClickedEventHandler(App app) {
        this.app = app;
    }
    
    @Override
    public void handle(MouseEvent t) {
        app.setScene(app.getMainScene());
    }
}
