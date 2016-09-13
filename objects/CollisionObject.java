package game.objects;

import game.maps.Map;
import game.player.Player;
import game.player.PlayerController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CollisionObject extends Pane {
	protected Rectangle upRect;
	protected Rectangle downRect;
	protected Rectangle leftRect;
	protected Rectangle rightRect;
	private Timeline collisionTimeline;
	
	public CollisionObject (double width, double height) {
		upRect = new Rectangle(width, 20);
		downRect = new Rectangle(width, 20);
		leftRect = new Rectangle(20, height);
		rightRect = new Rectangle(20, height);		
		

	
				
		upRect.setFill(Color.CHARTREUSE);
		downRect.setFill(Color.RED);
		leftRect.setFill(Color.AQUA);
		rightRect.setFill(Color.AQUAMARINE);
		
		downRect.setTranslateY(downRect.getTranslateY()+height - downRect.getHeight());
		rightRect.setTranslateX(rightRect.getTranslateX()+width - rightRect.getWidth());
		
		rightRect.setTranslateY(rightRect.getTranslateY()+20);
		leftRect.setTranslateY(leftRect.getTranslateY()+20);
		
		
		
		this.getChildren().addAll(upRect,downRect,leftRect,rightRect);
	}
	
	public void buildCollisionWith(Player player, Map map) {
		final double gravity = map.getGravity();
		collisionTimeline = new Timeline(new KeyFrame(Duration.millis(0.5), e-> {
			// Player bounds
			Bounds headBound = player.getHead().localToScene(player.getHead().getBoundsInLocal());
			Bounds bodyBound = player.getBody().localToScene(player.getBody().getBoundsInLocal());
			Bounds feetBound = player.getFeet().localToScene(player.getFeet().getBoundsInLocal());
			
			// object bounds
			Bounds upRectBound = upRect.localToScene(upRect.getBoundsInLocal());
			Bounds downRectBound = downRect.localToScene(downRect.getBoundsInLocal());
			Bounds leftRectBound = leftRect.localToScene(leftRect.getBoundsInLocal());
			Bounds rightRectBound = rightRect.localToScene(rightRect.getBoundsInLocal());
			
		
			
			if(upRectBound.intersects(feetBound)) {							
				player.setTranslateY(player.getTranslateY()-gravity/PlayerController.FPS*2);
				//map.setGravity(0);
				player.setAllowToJump(true);
				if(player.jumpedOnce) {
					player.handleResetPos();
					player.jumpedOnce = false;
				}				
			}
//			else {
//				map.setGravity(gravity);
//			}
			
			if(downRectBound.intersects(headBound)) {
				player.setTranslateY(player.getTranslateY()-player.getJumpForce()/PlayerController.FPS*2);
			}		
			
			if(leftRectBound.intersects(bodyBound)) {
				player.setTranslateX(player.getTranslateX()-player.getSpeed()/PlayerController.FPS*2);
			}
			if(rightRectBound.intersects(bodyBound)) {
				player.setTranslateX(player.getTranslateX()+player.getSpeed()/PlayerController.FPS*2);
			}			
			
		}));
		
		collisionTimeline.setCycleCount(Timeline.INDEFINITE);
		collisionTimeline.play();
	}

	
	
}
