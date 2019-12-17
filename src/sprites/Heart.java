package sprites;

import javafx.scene.image.Image;

/**
 * Class controls a heart object to represent the lives a player has
 * @author Nadim Rahman
 *
 */
public class Heart extends Actor{
	int dim;
	Image aliveImg;
	Image deadImg;

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Initialises the variables and sets the image
	 * @param dim is the size
	 * @param x position
	 * @param y position
	 */
	public Heart(int dim, int x, int y) {
		aliveImg = new Image("file:src/resources/heart.png", dim, dim, true, true);
		deadImg = new Image("file:src/resources/heartdead.png", dim, dim, true, true);

		setImage(aliveImg);
		setX(x);
		setY(y);
	}
	
	/**
	 * Called when the player loses a life
	 */
	public void setDead() {
		setImage(deadImg);

	}
	
	/**
	 * Called when the player gains a life
	 */
	public void setAlive() {
		setImage(aliveImg);

	}
	
}
