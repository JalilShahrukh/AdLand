package game.maps;

import java.util.ArrayList;

import game.objects.CollisionObject;
import game.player.Player;
import game.player.PlayerController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/*
 * AUTHOR: Shahrukh Jalil/Mohsin Hassan
 * LAST MODIFICATION: 1:44 PM 4/25/2016
 * 
 * NOTE:
 * 
 */


public abstract class Map extends Pane {	
	
//---------------------- Data Field -------------------------//	
	private int screenWidth;                             //
	private int screenHeight;                            //
                                                             //	
	private ImageView backgroundView;                    //
	private ImageView floorView;                         //
	private Image floorImage;                            //
	private Image backgroundImage;                       //
	                                                     //
	private Player player;                               //
	private KeyFrame keyFrame;                           //
	private Timeline timeline;                           //
	private ArrayList<CollisionObject> collisionObjList; //
	private ArrayList<Node> regularObjList;              //
	private int collisionObjCount = -1;                  //
	private int regularObjCount = -1;                    //
	private double gravity = 15;                         //
//-----------------------------------------------------------//
	
	
/* *****************
 *    CONSTRUCTOR
 * *****************/
	public Map(Image backgroundImage , Image floorImage, Player player, int screenWidth, int screenHeight) {		
		this.backgroundImage = backgroundImage;
		this.floorImage = floorImage;
		this.player = player;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;	
		
		collisionObjList = new ArrayList<CollisionObject>();
		regularObjList = new ArrayList<Node>();
		
		backgroundView = new ImageView(backgroundImage);
		floorView = new ImageView(floorImage);
		buildMapFunctionality();
		
		this.getChildren().addAll(backgroundView, floorView);		
	}
	
	
/* **********************
 *   build Map Functionality
 * **********************/
	private void buildMapFunctionality() {
		double leftMovingZone = (screenWidth/8);
		double rightMovingZone = (screenWidth- (screenWidth/3.5));
		
		keyFrame = new KeyFrame(Duration.millis(1), e-> {
			
			player.setTranslateY(player.getTranslateY()+gravity/PlayerController.FPS);
			
			Bounds playerBound = player.localToScene(player.getBoundsInLocal());
			Bounds thisMapBound = floorView.localToScene(floorView.getBoundsInLocal());
			
			boolean notStart = thisMapBound.getMinX() < 0;
			boolean notEnd = thisMapBound.getMinX() > (-(floorImage.getWidth())+ screenWidth);
		
			// Moving in the leftMovingZone
			if(playerBound.getMinX() <= leftMovingZone && player.getArrowPressed().equals("LEFT") && notStart) {
				player.setTranslateX(player.getTranslateX()+player.getSpeed()/PlayerController.FPS);
				backgroundView.setTranslateX(backgroundView.getTranslateX()+player.getSpeed()/PlayerController.FPS/3);
				floorView.setTranslateX(floorView.getTranslateX()+player.getSpeed()/PlayerController.FPS);
				moveCollisionObjs("RIGHT");
				moveRegularObjs("RIGHT");
			}
			
			// Moving in the rightMovingZone
			else if(playerBound.getMinX() >= rightMovingZone && player.getArrowPressed().equals("RIGHT") && notEnd) {
				player.setTranslateX(player.getTranslateX()-player.getSpeed()/PlayerController.FPS);
				backgroundView.setTranslateX(backgroundView.getTranslateX()-player.getSpeed()/PlayerController.FPS/3);
				floorView.setTranslateX(floorView.getTranslateX()-player.getSpeed()/PlayerController.FPS);
				moveCollisionObjs("LEFT");
				moveRegularObjs("LEFT");
				
			} 
							
		});
		
		timeline = new Timeline(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();		
	}
	
	public void addCollisionObject(CollisionObject obj, double locationX, double locationY) {
		obj.relocate(locationX, locationY);
		collisionObjList.add(obj);
		collisionObjCount++;		
		this.getChildren().add(collisionObjList.get(collisionObjCount));
	}
	
	public void addRegularObject(Node obj, double locationX, double locationY) {
		obj.relocate(locationX, locationY);
		regularObjList.add(obj);
		regularObjCount++;		
		this.getChildren().add(regularObjList.get(regularObjCount));
	}
	
	private void moveCollisionObjs(String direction) {
		switch(direction) {
		
		case "LEFT":
			for(int i = 0; i < collisionObjList.size(); i++) {
				CollisionObject obj = collisionObjList.get(i);
				obj.setTranslateX(obj.getTranslateX()-player.getSpeed()/PlayerController.FPS);
			}
			break;
			
		case "RIGHT":
			for(int i = 0; i < collisionObjList.size(); i++) {
				CollisionObject obj = collisionObjList.get(i);
				obj.setTranslateX(obj.getTranslateX()+player.getSpeed()/PlayerController.FPS);
			}
			break;
			
		default:
			break;
			
		}
	}
	
	private void moveRegularObjs(String direction) {
		switch(direction) {
		
		case "LEFT":
			for(int i = 0; i < regularObjList.size(); i++) {
				Node obj = regularObjList.get(i);
				obj.setTranslateX(obj.getTranslateX()-player.getSpeed()/PlayerController.FPS);
			}
			break;
			
		case "RIGHT":
			for(int i = 0; i < regularObjList.size(); i++) {
				Node obj = regularObjList.get(i);
				obj.setTranslateX(obj.getTranslateX()+player.getSpeed()/PlayerController.FPS);
			}
			break;
			
		default:
			break;
			
		}
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	
	public double getGravity() {
		return gravity;
	}
	
	
}
