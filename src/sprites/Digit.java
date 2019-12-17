package sprites;

import javafx.scene.image.Image;

/**
 * This ckass represents a single digit on the screen for the score and time
 * @author Nadim Rahman
 *
 */
public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Initialise the variables
	 * @param n for the digit number
	 * @param dim for size
	 * @param x position
	 * @param y position
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/resources/"+n+".png", dim, dim, true, true);
		// Set and assign the image
		setImage(im1);
		setX(x);
		setY(y);
	}
	
	
}
