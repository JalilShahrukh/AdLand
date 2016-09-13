package game;


import game.panes.GameMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application{
	// Window size:
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600; 	
        
    // Panes:
    private GameMenu gameMenuPane;
        
    // Scenes:
    private Scene gameMenuScene;
        
	@Override
	public void start(Stage primaryStage) {     
            // Initialize GameMenu
            gameMenuPane = new GameMenu(WINDOW_WIDTH, WINDOW_HEIGHT);
            gameMenuScene = new Scene(gameMenuPane, WINDOW_WIDTH, WINDOW_HEIGHT);
            
            // build menu buttons' functionalities
            gameMenuPane.buildButtonControls(primaryStage);           
            
            primaryStage.setScene(gameMenuScene);
            primaryStage.show();
		
	}
	
	
	public static void main (String [] args) {
		launch(args);
	}

}
