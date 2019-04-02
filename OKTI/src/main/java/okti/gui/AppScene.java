package okti.gui;

import javafx.scene.Scene;

public abstract class AppScene {
    private App app;
    
    public AppScene(App app) {
        this.app = app;
    }
    
    public abstract Scene createScene();
    
    protected App getApp() {
        return app;
    }
}
