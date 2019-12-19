package sprites;

import javafx.scene.image.Image;

/**
 * This class controls the end destination objects in a level
 * @author Nadim Rahman
 *
 */
public class End extends Actor{
	private boolean activated = false;
	public static final int imgSize = 60;
	public static final int yPos = 96;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * Initialise the variables and set the image
	 * @param x position
	 * @param y position
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/resources/End.png", imgSize, imgSize, true, true));
	}
	
	/**
	 * Change the image when the player reaches the end
	 */
	public void setEnd() {
		setImage(new Image("file:src/resources/FrogEnd.png", imgSize, imgSize, true, true));
		activated = true;
	}
	
	/**
	 * Check if the end has been reached already
	 * @return
	 */
	public boolean isActivated() {
		return activated;
	}
	
	public int getImageSize() {
		return imgSize;
	}

}
