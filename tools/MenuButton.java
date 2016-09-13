package game.tools;

import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuButton extends StackPane {
	
	private Text buttonName;
	private Rectangle rectangle;
	private boolean exited = false;
	
	public MenuButton(String buttonName) {
		this.buttonName = new Text(buttonName);
		this.buttonName.setFont(new Font(25));
		this.buttonName.setFill(Color.WHITE);
		
		rectangle = new Rectangle(200, 35);
		rectangle.setOpacity(0.5);
		rectangle.setFill(Color.BLACK);
		rectangle.setEffect(new GaussianBlur(3.5));
		this.setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(rectangle, this.buttonName);
			
		this.setOnMouseEntered(event-> {

			exited = false;
			this.buttonName.setFill(Color.BLACK);			
			this.rectangle.setFill(Color.WHITE);
			this.buttonName.setTranslateX(10);
			this.rectangle.setTranslateX(10);
			
		});
		
		this.setOnMouseExited(event->{
			exited = true;
			this.buttonName.setFill(Color.WHITE);			
			this.rectangle.setFill(Color.BLACK);
			this.buttonName.setTranslateX(0);
			this.rectangle.setTranslateX(0);
		});
		
		this.setOnMousePressed(e-> {
			this.rectangle.setFill(Color.FIREBRICK);
		});
		
		this.setOnMouseReleased(e->{
			if(exited)
			this.rectangle.setFill(Color.BLACK);
			else 
				this.rectangle.setFill(Color.WHITE);
		});
		
	}
	
}
