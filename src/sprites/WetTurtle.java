package sprites;

import javafx.scene.image.Image;
import model.Main;

/**
 * This class represents a wet turtle that moves across the screen and sinks
 * @author Nadim Rahman
 *
 */
public class WetTurtle extends Turtle{

	private int xSize = 120;
	private int ySize = 50; 
	
	Image turtle4;

	boolean sunk = false;
	
	/**
	 * Initialise the variables
	 * @param xpos
	 * @param ypos
	 * @param s
	 */
	public WetTurtle(int xpos, int ypos, double s) {
		super(xpos,ypos,s);
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png",xSize, ySize,false, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2Wet.png", xSize, ySize, false, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3Wet.png", xSize, ySize, false, true);
		turtle4 = new Image("file:src/resources/TurtleAnimation4Wet.png", xSize, ySize, false, true);
		setImage(turtle2);
	}
	
	/**
	 * This method controls how the turtle acts
	 * @param now is the time the turtle has lived for
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					// Turtle has sunk
					sunk = true;
				}
			
				// Move the turtle
				move(speed , 0);
				// Check if the turtle has gone off the screen
				if (getX()>Main.maxWidth && speed>0)
					setX(-xSize);
				if (getX()<-xSize && speed<0)
					setX(Main.maxWidth);
	}
	
	
	public boolean isSunk() {
		return sunk;
	}
}
