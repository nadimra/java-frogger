package sprites;

import javafx.scene.image.Image;

/**
 * This class represents the background image of the game
 * @author Nadim Rahman
 *
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 889, true, true));
		
	}

}
