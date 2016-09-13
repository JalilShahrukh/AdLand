package game.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CrateBox extends CollisionObject {
	private static final Image img = new Image(CrateBox.class.getResourceAsStream("../images/cratebox.png"));
	
	public CrateBox() {
		super(85, 85);
		ImageView imageView = new ImageView(img);
		imageView.setFitWidth(85);
		imageView.setFitHeight(85);
		this.getChildren().add(0, imageView);
		// TODO Auto-generated constructor stub
	
		upRect.setVisible(false);
		downRect.setVisible(false);
		leftRect.setVisible(false);
		rightRect.setVisible(false);
	}


}
