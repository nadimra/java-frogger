package sprites;

/**
 * This class represents the different animal obstacles
 * @author Nadim Rahman
 *
 */
public abstract class AnimalObstacle extends Actor {
	protected double speed;
	protected int xPos;
	protected int yPos;

	/**
	 * Initialise the variables
	 * @param xpos
	 * @param ypos
	 * @param s for speed
	 */
	public AnimalObstacle(int xpos, int ypos, double s) {
		speed = s;
		xPos = xpos;
		yPos = ypos;
		setX(xpos);
		setY(ypos);
	}
	
	public void act(long now) {}

	public double getSpeed() {
		return speed;
	}
}
