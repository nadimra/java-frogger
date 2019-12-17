package sprites;

import javafx.scene.image.Image;
import model.Main;

/**
 * This class represents a turtle that simply moves across the screen
 * @author Nadim Rahman
 *
 */
public class NormalTurtle extends Turtle{
	private int xSize = 120;
	private int ySize = 50;
	
	/**
	 * Initialise the variables
	 * @param xpos
	 * @param ypos
	 * @param s
	 */
	public NormalTurtle(int xpos, int ypos, double s) {
		super(xpos,ypos,s);
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", xSize, ySize, false, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2.png", xSize, ySize, false, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3.png", xSize, ySize, false, true);
		setImage(turtle2);
	}
	
	/**
	 * This method controls how the turtle acts
	 * @param now is the time the turtle has lived for
	 */
	@Override
	public void act(long now) {

		// Continuously change the turtle image to animate
				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);	
				}
		
		// Move the turtle
		move(speed , 0);
		// Check if the turtle has gone off the screen
		if (getX()>Main.maxWidth && speed>0)
			setX(-xSize);
		if (getX()<-xSize && speed<0)
			setX(Main.maxWidth);
	}
	
}
