package okti.gui;

import javafx.scene.Scene;

public abstract class AppScene {
    private App app;
    
    /**
     * Constructor for an abstract scene.
     * @param app App in which the scene is
     */
    public AppScene(App app) {
        this.app = app;
    }
    
    /**
     * Constructs a scene object.
     * @return Constructed scene
     */
    public abstract Scene createScene();
    
    /**
     * Getter for the app object.
     * @return The app object of the scene
     */
    protected App getApp() {
        return app;
    }
}
