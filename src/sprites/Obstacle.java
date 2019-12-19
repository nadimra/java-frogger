package sprites;

import javafx.scene.image.Image;

/**
 * This class creates an obstacle for the roads
 * @author Nadim Rahman
 *
 */
public abstract class Obstacle extends Actor {
	protected double speed;
	protected int xSize;
	protected int ySize;
	protected int xPos;
	protected int yPos;
	
	public void act(long now) {
	}
	
	/**
	 * Initialises the variables and sets the positions
	 * @param xpos
	 * @param ypos
	 * @param s
	 */
	public Obstacle(int xpos, int ypos, double s) {
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public int getXSize() {
		return xSize;
	}
	
	public int getYSize() {
		return ySize;
	}
	
	protected void setPos(int xpos, int ypos) {
		setX(xpos);
		setY(ypos);		
	}
}
