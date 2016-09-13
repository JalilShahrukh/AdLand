package game.panes;
import game.tools.MenuButton;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GameMenu extends Pane {
    private Label title;
    private MenuButton startButton;
    private MenuButton settingsButton;
    private MenuButton quitButton;
    private VBox menu;
    private Stage stage;
    
    // Next possible scenes:
    private Scene gamePlayScene;
    private Scene settingsScene;
    private double screenWidth;
    private double screenHeight;

/* **************
     CONSTRUCTOR
 * **************/
    public GameMenu(double screenWidth, double screenHeight) {
    	this.screenWidth = screenWidth;
    	this.screenHeight = screenHeight;
        title = new Label("Adventure Land");
        title.setFont(new Font(40));
        startButton = new MenuButton("Start");
        settingsButton = new MenuButton("Settings");
        quitButton = new MenuButton("Quit");
        menu = new VBox(startButton, quitButton);
        menu.relocate(screenWidth/2, screenWidth/2);
        
        this.setStyle("-fx-background-color: CHOCOLATE");
        
        
        
        this.getChildren().addAll(title, menu);
    }
    
    public void buildButtonControls(Stage stage) {
        startButton.setOnMouseClicked(e-> {
        	GamePlay gamePlayPane = new GamePlay(stage,(int) screenWidth,(int) screenHeight);
        	gamePlayScene = new Scene(gamePlayPane, screenWidth, screenHeight);
            stage.setScene(gamePlayScene);
        });
        
        settingsButton.setOnMouseClicked(e->{
            stage.setScene(settingsScene);
        });
        
        quitButton.setOnMouseClicked(e->{
            System.exit(0);
        });
    }
    
    public void setGamePlayScene(Scene scene) {
        this.gamePlayScene = scene;
    }
    
    public void setSettingsScene(Scene scene) {
        this.settingsScene = scene;
    }
    
    
    public MenuButton getStartButton() {
        return startButton;
    }
    public MenuButton getSettingsButton() {
        return settingsButton;
    }
    
    public MenuButton getQuitButton() {
        return quitButton;
    }
    
    
    

}


