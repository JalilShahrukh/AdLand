package game.objects;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AnswerBox extends CollisionObject {
	private static final Image img = new Image(CrateBox.class.getResourceAsStream("../images/cratebox.png"));
	
	private Label answerLabel;
	
	// DEFAULT CONSTRUCTOR
	public AnswerBox() {
		super(85, 85);		
		
		answerLabel = new Label("");
		answerLabel.setFont(Font.font(30));
		answerLabel.setTextFill(Color.WHITE);
		ImageView imageView = new ImageView(img);
		imageView.setFitWidth(85);
		imageView.setFitHeight(85);
		this.getChildren().add(0, imageView);
		this.getChildren().add(answerLabel);
		// TODO Auto-generated constructor stub
	
		upRect.setVisible(false);
		downRect.setVisible(false);
		leftRect.setVisible(false);
		rightRect.setVisible(false);
	}
	
	
	// CONSTRUCTOR
	public AnswerBox(String answerStr) {
		super(85, 85);		
		
		answerLabel = new Label(answerStr);
		answerLabel.setFont(Font.font(30));
		answerLabel.setTextFill(Color.WHITE);
		ImageView imageView = new ImageView(img);
		imageView.setFitWidth(85);
		imageView.setFitHeight(85);
		this.getChildren().add(0, imageView);
		this.getChildren().add(answerLabel);
		// TODO Auto-generated constructor stub
	
		upRect.setVisible(false);
		downRect.setVisible(false);
		leftRect.setVisible(false);
		rightRect.setVisible(false);
	}
	
	
	
	public void setAnswer(String ans) {
		answerLabel.setText(ans);
	}
}
