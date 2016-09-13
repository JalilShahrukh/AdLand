package game.player;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/*
 * AUTHOR: Shahrukh Jalil/Mohsin Hassan
 * LAST MODIFICATION: 9:43 AM  4/25/2016
 * 
 * NOTE:
 *  The purpose of this class is to build controls 
 *  so that the player could move left, right, jump, etc.
 *  Therefore all controls, or additional controls should
 *  go here.
 */

public class PlayerController {
	
//--------------- Data Field ----------------------//	
	public static final double FPS = 1000/30;  //
	private Timeline timeline;                 //
	private KeyFrame keyFrame;                 //
	private Player player;                     //
//-------------------------------------------------//	

	
	
/* ***************
 *   CONSTRUCTOR
 * ***************/	
	public PlayerController(Player player) {
		this.player = player;
	}
	
	
	
/* ******************
 *   BUILD CONTROLS
 * ******************/
	public void buildControls() {
		
		// KEY PRESSED
		player.setOnKeyPressed(e-> {
			switch(e.getCode()) {
			
			case LEFT:
				player.setArrowPressed("LEFT");
				player.setAllowToMove(true);
				player.handleLeftScale();
				
				break;
				
				
			case RIGHT:
				player.setArrowPressed("RIGHT");
				player.setAllowToMove(true);
				player.handleRightScale();
				
				break;
				
			case UP:
				if(player.getAllowToJump()) {
					player.setAllowToJump(false);
					jump();
				}
				break;
				
				
			default:
				break;			
			}
		});
		
		// KEY RELEASED
		player.setOnKeyReleased(e-> {
			switch(e.getCode()) {
			
			case LEFT:
				player.setAllowToMove(false);
				player.setArrowPressed("");
				player.handleResetPos();
				break;
				
				
			case RIGHT:
				player.setAllowToMove(false);
				player.setArrowPressed("");
				player.handleResetPos();
				break;
				
			
				
				
			default:
				break;			
			}
		});
		
		// Building player animation
		keyFrame = new KeyFrame(Duration.millis(1), e->{
			// LEFT
			if(player.getArrowPressed().equals("LEFT") && player.getAllowToMove()) {				
				player.setTranslateX(player.getTranslateX()-player.getSpeed()/FPS);
				if(player.getAllowToJump())
					player.handleSprites();
			}
			
			// RIGHT
			else if(player.getArrowPressed().equals("RIGHT") && player.getAllowToMove()) {				
				player.setTranslateX(player.getTranslateX()+player.getSpeed()/FPS);
				if(player.getAllowToJump())
					player.handleSprites();
			}	
		
		});
		
		timeline = new Timeline(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();		
	}
	
	private void jump () {
		player.handleJumpPos();
		player.jumpedOnce = true;
		TranslateTransition tt = new TranslateTransition(Duration.millis(300), player);
		tt.setByY(-100);
		tt.play();
	}
	


	
}
