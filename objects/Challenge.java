package game.objects;

import java.text.DecimalFormat;
import java.util.Random;

public class Challenge {
	private static final DecimalFormat decFormat =
			new DecimalFormat("#0.00");
	
	private static final char ADD = '+';
	private static final char SUB = '-';
	private static final char MUL = '*';
	private static final char DIV = '/';
	
	
	
	private String questionGenerated;
	private double firstOperand;
	private double secondOperand;
	private char operator;
	private Random ran = new Random(); // LOL
	
	private int difficulty;
	
	private double correctAnswer;
	private AnswerBox correctAnswerBox;
	
	
	
	// Constructor
	public Challenge(int difficulty) {
		this.difficulty = difficulty;		
	}
	
	
	public String generateQuestion() {
		System.out.println("Creating firstOperand... ");
		firstOperand = difficulty + ran.nextInt(10);
		System.out.println("firstOperand Created: " + firstOperand);
		
		secondOperand = difficulty + ran.nextInt(10);
		operator = getRandomOperator();	
		
		questionGenerated = firstOperand + " " + operator + " " + secondOperand;		
		return questionGenerated;
	}
	
	
	private char getRandomOperator() {
		int option = new java.util.Random().nextInt(4);
		
		switch(option) {
		case 0: return ADD;
		case 1: return SUB;
		case 2: return MUL;
		case 3: return DIV;
		default:
			return 'E'; // E for Error
		}	
		
		
	}
	
	public void setAnswerBoxes(AnswerBox... ansBoxes) {
		
		double firstOperandNum = Double.parseDouble(""+firstOperand);
		System.out.println("Debugging firstOperand: " + firstOperand);
		
		double secondOperandNum = Double.parseDouble(""+secondOperand);
		System.out.println("Debugging secondOperand: " + secondOperand);
		
		correctAnswer = -1;
		
		switch(operator) {
		
		case ADD:
			correctAnswer = firstOperandNum + secondOperandNum;
			break;
		case SUB:
			correctAnswer = firstOperandNum - secondOperandNum;
			break;
		case MUL:
			correctAnswer = firstOperandNum * secondOperandNum;
			break;
		case DIV:
			correctAnswer = firstOperandNum / secondOperandNum;
			break;
		default:
			correctAnswer = -9999; // this represents ERROR
		}
		
		
		
		int correctBoxNum = ran.nextInt(ansBoxes.length);
		
		// Give random answers and 1 correct answer to the ansBoxes.
		for(int i = 0; i < ansBoxes.length; i++) {
			if(correctBoxNum == i) {
				ansBoxes[i].setAnswer(""+ decFormat.format(correctAnswer));
				this.correctAnswerBox = ansBoxes[i];
			}
			else {
				int randomNum = 1 + ran.nextInt(3);
				double badAnswer = getRandomBadAnswer(correctAnswer, randomNum);
				ansBoxes[i].setAnswer("" + decFormat.format(badAnswer));
			}
			
			
		}
		
		
		
	}	
	
	// This makes sure that the badAnswers are not the same as the right answer
	private double getRandomBadAnswer(double correctAnswer, double randomNum) {
		int ranOption = ran.nextInt(2);
		if(ranOption == 0) {
			return (correctAnswer - randomNum);
		}
		else {
			return (correctAnswer + randomNum);
		}
	}
	
	public AnswerBox getCorrectAnswerBox() {
		return this.correctAnswerBox;
	}
}
