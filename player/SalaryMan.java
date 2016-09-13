package game.player;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SalaryMan extends Player{

	private static final Image img = 
			new Image(SalaryMan.class.getResourceAsStream("../images/SalaryMan.png"));
	
	int clockCount = 0;
	int count = 0;
	
	private static final Rectangle2D [] CROPPED = {
			new Rectangle2D(0, 99, 57, 198), //0
			new Rectangle2D(342, 99, 57, 198), // 6			
			new Rectangle2D(57, 99, 57, 198), // 1			
			new Rectangle2D(114, 99, 57, 198),// 2
			new Rectangle2D(171, 99, 57, 198), //3
			new Rectangle2D(228, 99, 57, 198), // 4
			new Rectangle2D(285, 99, 57, 198), // 5
			
	};
	
	
	
	public SalaryMan() {
		this.setImage(img);
		this.getImageView().setViewport(CROPPED[2]);
		
		head.setTranslateX(head.getTranslateX() + 10);
		body.setTranslateX(body.getTranslateX() + 12);
		feet.setTranslateX(feet.getTranslateX() + 10);
		
		head.setTranslateY(head.getTranslateY() + 2);
		body.setTranslateY(body.getTranslateY() + 3);
		feet.setTranslateY(feet.getTranslateY() + 6);
		
		head.setVisible(false);
		body.setVisible(false);
		feet.setVisible(false);
		
	}
	
	
	
	
	@Override
	public void handleSprites() {
		if(clockCount >= 100) {
			clockCount = 0;
			if(count < CROPPED.length-1) {
				count++;
			}
			else {
				count = 0;
			}
			
			this.getImageView().setViewport(CROPPED[count]);
			
			
		}
		else {
			clockCount++;
		}
		
		
	}

	@Override
	public void handleLeftScale() {
		this.setScaleX(-1);
		
	}

	@Override
	public void handleRightScale() {
		this.setScaleX(1);
		
	}




	@Override
	public void handleResetPos() {
		this.getImageView().setViewport(CROPPED[0]);
		
	}




	@Override
	public void handleJumpPos() {
		this.getImageView().setViewport(CROPPED[2]);
		
	}

}
