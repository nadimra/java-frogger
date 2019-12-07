package model;

public abstract class AnimalObstacle extends Actor {
	protected double speed;
	protected int xPos;
	protected int yPos;

	public AnimalObstacle(int xpos, int ypos, double s) {
		speed = s;
		xPos = xpos;
		yPos = ypos;
		setX(xpos);
		setY(ypos);
	}
	
	public void act(long now) {}

}
