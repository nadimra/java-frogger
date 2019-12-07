package model;

public class Truck extends Obstacle {

	public Truck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
	}
	
	protected void setPos(int xpos, int ypos) {
		setX(xpos);
		setY(ypos);		
	}

}
