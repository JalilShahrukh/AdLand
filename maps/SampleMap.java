package game.maps;


import javax.swing.JOptionPane;

import game.objects.AnswerBox;
import game.objects.Challenge;
import game.objects.CollisionObject;
import game.objects.CrateBox;
import game.objects.QuestionBox;
import game.player.Player;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SampleMap extends Map {
	private static final Image backgroundImg
	= new Image(SampleMap.class.getResourceAsStream("../images/background2.jpg"));
	private static final Image floorImg 
	= new Image(SampleMap.class.getResourceAsStream("../images/floor3.png"));
	
	Label scoreLabel;
	int score = 0;
	
	
	
	public SampleMap(Player player, int screenWidth, int screenHeight) {
		super(backgroundImg, floorImg, player, screenWidth, screenHeight);
		
		scoreLabel = new Label("Score: " + score);
		scoreLabel.setTextFill(Color.WHITE);
		scoreLabel.setFont(new Font(30));
		
		this.getChildren().add(scoreLabel);
		
		// Create challenges
		Challenge [] ch = new Challenge[4];
		QuestionBox [] questionBox = new QuestionBox[4];
		boolean [] answered =  new boolean[4]; 
		
		
		for(int i = 0; i < ch.length; i++) {
			answered[i] = false;
			ch[i] = new Challenge(0 + i*2);
			questionBox[i] = new QuestionBox(ch[i].generateQuestion(), 120 , 50);
			this.addRegularObject(questionBox[i], 200 + (i*500), 300);
			
			final AnswerBox answer1 = new AnswerBox();
	        final AnswerBox answer2 = new AnswerBox();
	        final AnswerBox answer3 = new AnswerBox();
	        
	        ch[i].setAnswerBoxes(answer1, answer2, answer3);
	        
	        answer1.buildCollisionWith(player, this);
	        answer2.buildCollisionWith(player, this);
	        answer3.buildCollisionWith(player, this);
	        
	        final int x = i;
	       
	        questionBox[i].setOnMouseClicked(e-> {
	        	// get correct answerbox;
	        	AnswerBox correctAnsBox = ch[x].getCorrectAnswerBox();
	        	
	        	Bounds correctBoxBounds = correctAnsBox.localToScene(correctAnsBox.getBoundsInLocal());
	        	Bounds playerBounds = player.localToScene(player.getBoundsInLocal());
	        	
	        	if(correctBoxBounds.intersects(playerBounds)) {
	        		System.out.println("YOU ARE CORRECT");
	        		if(!answered[x]) {
	        			score+=(100/ch.length);
		        		scoreLabel.setText("Score: " + score);
		        		questionBox[x].getRectBackground().setFill(Color.GREEN);
		        		answered[x] = true;
	        		}
	        		
	        		
	        		
	        		
	        	}
	        	else {
	        		if(!answered[x]) {
	        			System.out.println("YOU ARE SO WRONG DUDE!");
		        		answer1.setVisible(false);
		        		answer2.setVisible(false);
		        		answer3.setVisible(false);
		        		
		        		
		        		
		        		questionBox[x].getRectBackground().setFill(Color.RED);
		        		answered[x] = true;
	        		}
	        	}
	        	
	        	answer1.setTranslateY(-9999);
        		answer2.setTranslateY(-9999);
        		answer3.setTranslateY(-9999);
	      
	        });
	        
	        this.addCollisionObject(answer1, 130 + (i*500), 465);
	        this.addCollisionObject(answer2, 240+ (i*500), 465);
	        this.addCollisionObject(answer3, 340 + (i*500), 465);
	        
	        
		}
		
		
		
		
		

                
		
                // DONT DELETE THIS ONE:
		CollisionObject obj = new CollisionObject(floorImg.getWidth(), 65);
		obj.buildCollisionWith(player, this);
		obj.setVisible(false);
		this.addCollisionObject(obj, 0, 555);
                
                // LEFT WALL - DON"T DELETE
                CollisionObject leftWall = new CollisionObject(100, screenHeight);
		leftWall.buildCollisionWith(player, this);
		leftWall.setVisible(false);
		this.addCollisionObject(leftWall, -100, 0);
		
                // RIGHT WALL -- DON"T DELETE
                CollisionObject rightWall = new CollisionObject(100, screenHeight);
		rightWall.buildCollisionWith(player, this);
		rightWall.setVisible(false);
		this.addCollisionObject(rightWall, floorImg.getWidth(), 0);
	}

}
