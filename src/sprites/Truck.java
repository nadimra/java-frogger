package sprites;

import model.Lane;
import model.Main;

/**
 * This class is an abstract class for different types of truck obstacles
 * @author Nadim Rahman
 *
 */
public class Truck extends Obstacle {
	private int xSize;
	private int ySize;
	
	/**
	 * Initialise the variables
	 * @param xpos
	 * @param ypos
	 * @param s for speed
	 * @param xSize
	 * @param ySize
	 */
	public Truck(int xpos, int ypos, double s, int xSize, int ySize) {
		super(xpos, ypos, s);
		this.xSize = xSize;
		this.ySize = ySize;
	}

	/**
	 * Control how the truck acts
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		// Check if the truck has gone off the screen
		if (getX()>Main.maxWidth && speed>0)
			setX(-xSize);
		if (getX()<-xSize && speed<0)
			setX(Main.maxWidth);
	}
	
	protected int adjustPosY(int ypos) {
		return yPos = ((Lane.LANE_SIZE)-ySize)/2+ypos;
	}
	
}
