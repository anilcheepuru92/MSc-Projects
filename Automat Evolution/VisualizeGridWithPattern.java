package finalassignment2;

import static finalassignment2.EvolutionResult.COLUMNS;
import static finalassignment2.EvolutionResult.ROWS;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

import peasy.PeasyCam;
import processing.core.PApplet;

/*
 * This class members offer the following functionality:
 * 		1. Fetching the final result pattern
 * 		2. Plotting the grid with the obtained result
 */
public class VisualizeGridWithPattern extends PApplet{

	private PeasyCam camera;
	private Rectangle[][] rectArray = null;
	private boolean[][] finalPattern = new boolean[ROWS][COLUMNS];
	private double xCoordinate = 0;
	private double yCoordinate = 0;
	private final double cellHeight = 2;
	private final double cellWidth = 2;
	
	public static void main(String[] args) {
		PApplet.main(VisualizeGridWithPattern.class);
	}
	
	public void settings() {
		size(600, 400, P3D);
	}	
	
	public void setup() {
		camera = new PeasyCam(this, 50, -40, 0, 100);
		rectArray = new Rectangle[ROWS][COLUMNS];
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLUMNS; j++) {
				Rectangle r = new Rectangle(xCoordinate, yCoordinate, cellWidth, cellHeight);
				rectArray[i][j] = r;
				xCoordinate = xCoordinate + cellWidth;
			}
			xCoordinate = 0;
			yCoordinate = yCoordinate + cellHeight;
		}
		
		//To get the result pattern
		try {
			System.out.println("Enter ONE of these Pattern Options [ example / pattern1 / pattern2 / pattern3 ]:: ");
			//Receiving the input from the user
			Scanner sc = new Scanner(System.in);
			String pattern = sc.nextLine();
			System.out.println("Enter the Required EVOLUTION NUMBER here:: ");
			int count = sc.nextInt();
			if(count<=0)
				throw new Exception("EVOLUTION NUMBER SHOULD BE A WHOLE NUMBER GREATER THAN 0");
			//using the received input to fetch the required pattern
			finalPattern = EvolutionResult.getFinalPattern(pattern, count);
		}catch (InputMismatchException e) {
			throw new InputMismatchException("CHARACTERS/DECIMALS ARE NOT ALLOWED FOR EVOLUTION NUMBER. INPUT A WHOLE NUMBER GREATER THAN 0");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//To visualize the resulting final pattern in a grid
	public void draw() {
		background(190);
		for (int i = rectArray[0].length - 1; i >= 0; i--) {
			for (int j = 0; j < rectArray.length; j++) {
				if (finalPattern[i][j] == true)
					rectArray[(ROWS - 1) - i][j].draw(Color.YELLOW, this);	//yellow <=> alive
				else
					rectArray[(ROWS - 1) - i][j].draw(Color.GRAY, this);	//gray <=> dead
			}
		}
	}
}