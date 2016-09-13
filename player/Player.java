package game.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * AUTHOR: Shahrukh Jalil/Mohsin Hassan
 * LAST MODIFICATION: 9:43 AM  4/25/2016
 * 
 * NOTE:
 * 	The Player class is an abstract class that contains 
 *  all the fundamentals: necessary variables and functions
 *  that a player should have. This class should be extended 
 *  by a class (or classes) with the intention of becoming a 
 *  player.
 */

public abstract class Player extends Pane {
	
//-------------- Data Field ---------------//	
	private ImageView playerView;      //
	private boolean allowToJump;       //
	private boolean allowToMove;       //
	private String arrowPressed;       //
	private double speed;              //
	private int hp;                    //
	                                   //
	protected Rectangle head;          //
	protected Rectangle body;          //
	protected Rectangle feet;          //
	private double jumpForce;          //
	public boolean jumpedOnce = true;  //
	                                   //
//-----------------------------------------//
	
	
	
	
/* ***************
 *   CONSTRUCTOR
 * ***************/
	public Player() {
		this.playerView = new ImageView();
		
		double width = 25;
		double height = 25;
		
		head = new Rectangle(width, height);
		body = new Rectangle(width, height);
		feet = new Rectangle(width, height);
		
		head.setTranslateX(body.getTranslateX());
		head.setTranslateY(body.getTranslateY());
		body.setTranslateX(body.getTranslateX());
		body.setTranslateY(body.getTranslateY()+ head.getHeight()+5);
		feet.setTranslateX(feet.getTranslateX());
		feet.setTranslateY(feet.getTranslateY()+ head.getHeight()*2+10);
		
		head.setFill(Color.AQUAMARINE);
		body.setFill(Color.CHARTREUSE);
		feet.setFill(Color.AQUA);
		
		setAllowToJump(false);
		setAllowToMove(true);
		setArrowPressed("");
		setSpeed(5.0);
		setHp(100);
		setJumpForce(10);
		
		playerView.setFocusTraversable(true);		
		this.getChildren().addAll(playerView, head, body, feet);
		
	}
	
	
	
	
/* *************
 *   MUTATORS
 * ************/
	public void setImage(Image playerImage) {
		this.playerView.setImage(playerImage);
	}
	
	public void setAllowToJump(boolean allowToJump) {
		this.allowToJump = allowToJump;
	}
	
	public void setAllowToMove(boolean allowToMove) {
		this.allowToMove = allowToMove;
	}
	
	public void setArrowPressed(String arrowPressed) {
		this.arrowPressed = arrowPressed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setJumpForce(double jumpForce) {
		this.jumpForce = jumpForce;
	}
	
	
	
/* **************
 *    ACCESSORS
 * *************/
	public Image getImage() {
		return playerView.getImage();
	}
	
	public ImageView getImageView() {
		return playerView;
	}
	
	public boolean getAllowToJump() {
		return allowToJump;
	}
	
	public boolean getAllowToMove() {
		return allowToMove;
	}
	
	public String getArrowPressed() {
		return arrowPressed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Rectangle getHead() {
		return head;
	}
	
	public Rectangle getBody() {
		return body;
	}
	
	public Rectangle getFeet() {
		return feet;
	}
	
	public double getJumpForce() {
		return jumpForce;
	}
	
	
	
	
	
	
	
/* ******************
 *    abstract Methods
 * *****************/
	
	public abstract void handleSprites();
	public abstract void handleLeftScale();
	public abstract void handleRightScale();
	public abstract void handleResetPos();
	public abstract void handleJumpPos();
}
