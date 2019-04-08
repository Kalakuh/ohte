package okti.event;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class PracticeKeyboardEventHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT:
                System.out.println("VASEN");
                break;
            case RIGHT:
                System.out.println("OIKEA");
                break;
            case SPACE:
                System.out.println("VÄLILYÖNTI");
                break;
            default:
                break;
        }
    }
    
}
