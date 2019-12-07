package p4_group_8_repo;

import javafx.scene.image.Image;

public abstract class Log extends Actor {

	protected double speed;
	protected int xSize;
	protected int ySize;
	protected int xPos;
	protected int yPos;
	
	public void act(long now) {
	}
	
	public Log(int xpos, int ypos, double s) {
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	public boolean getLeft() {
		return speed < 0;
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
	
}
