package game.objects;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class QuestionBox extends StackPane {
	private String question;
	private Text questionText;
	private Rectangle background;
	
	// Constructor:
	public QuestionBox(String questionStr, double backgroundWidth, double backgroundHeight) {
		this.question = questionStr;
		this.questionText = new Text(questionStr);
		
		
		background = new Rectangle(backgroundWidth, backgroundHeight);
		background.setFill(Color.BISQUE);
		
		this.getChildren().addAll(background, questionText);
	
	}
	
	// questionText Setter:
	public void setQuestionText(String questionStr) {
		this.questionText.setText(questionStr);
	}
	
	public Rectangle getRectBackground() {
		return this.background;
	}
}
