package game.panes;

import game.maps.SampleMap;
import game.player.Player;
import game.player.PlayerController;
import game.player.SalaryMan;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GamePlay extends Pane{
    
    // Maps:
    private SampleMap sampleMap;
    
    // Map Scenes:
    private Scene sampleMapScene;
    
    // Player:
    private SalaryMan salaryMan;
    
    // Player Controller
    private PlayerController controls;
    
    
    public GamePlay(Stage stage, int screenWidth, int screenHeight) {
        
        // Initialize player
        salaryMan = new SalaryMan();
        
        // Initialize player controls
        controls = new PlayerController(salaryMan);
        controls.buildControls();
        
        // Initialize sampleMap
        sampleMap = new SampleMap(salaryMan, screenWidth, screenHeight);
        sampleMapScene = new Scene(sampleMap, screenWidth, screenHeight);
        
        this.getChildren().addAll(sampleMap, salaryMan);
        
        stage.setScene(sampleMapScene);        
    }

    
    
    
}
