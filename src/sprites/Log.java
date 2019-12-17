package sprites;

import javafx.scene.image.Image;
import model.Lane;
import model.Main;

/**
 * This abstract class represents a general log object
 * @author Nadim Rahman
 *
 */
public abstract class Log extends Actor {

	protected double speed;
	protected int xSize;
	protected int ySize;
	protected int xPos;
	protected int yPos;
	
	/**
	 * Initialises the variables and sets position
	 * @param xpos
	 * @param ypos
	 * @param s
	 */
	public Log(int xpos, int ypos, double s, int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * Control movement of the log
	 * @param now amount of time object has lived for
	 */
	public void act(long now) {
		move(speed , 0);
		// Check if the log has gone off the screen
		if (getX()>Main.maxWidth && speed>0)
			setX(-xSize);
		if (getX()<-xSize && speed<0)
			setX(Main.maxWidth);
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
	
	/**
	 * Adjust the position of the image to be in the middle of the lane
	 * @param ypos given from lane
	 * @return
	 */
	protected int adjustPosY(int ypos) {
		return yPos = ((Lane.LANE_SIZE)-ySize)/2+ypos;
	}
	
	protected void setPos(int xpos, int ypos) {
		setX(xpos);
		setY(ypos);		
	}
	
}
