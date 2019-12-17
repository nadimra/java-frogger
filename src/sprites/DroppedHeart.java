package sprites;

import javafx.scene.image.Image;

/**
 * This class creates a dropped heart from an Ambulance 
 * @author Nadim Rahman
 *
 */
public class DroppedHeart extends Actor {
	int dim = 40;
	Image heartImage;
	Ambulance ambulance;


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Create a dropped heart and place the image
	 * @param x position
	 * @param y position
	 */
	public DroppedHeart(double x, int y) {
		heartImage = new Image("file:src/resources/heart.png", dim, dim, true, true);
		setImage(heartImage);
		setX(x);
		setY(y);
	}
	
	
}
