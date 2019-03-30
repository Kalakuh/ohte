package okti.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private static double APP_WIDTH = 800;
    private static double APP_HEIGHT = 600;
    private static String APP_NAME = "OKTI";
    
    public App() {
        
    }
    
    public void launchApp() {
        launch(App.class);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("OKTI");
        stage.setWidth(APP_WIDTH);
        stage.setHeight(APP_HEIGHT);
        stage.show();
    }
}
