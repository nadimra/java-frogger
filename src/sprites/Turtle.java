package sprites;

import javafx.scene.image.Image;

/**
 * This class represents an abstract turtle
 * @author Nadim Rahman
 *
 */
public abstract class Turtle extends AnimalObstacle {
	protected Image turtle1;
	protected Image turtle2;
	protected Image turtle3;
	
	public Turtle(int xpos, int ypos, double s) {
		super(xpos,ypos,s);
	}
}
