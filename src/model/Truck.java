package model;

public class Truck extends Obstacle {

	public Truck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
	}
	
	protected String setDirection() {
		if(speed>= 0) {
			return "Right.png";
		}
		if(speed< 0) {
			return "Left.png";
		}
		return "Right.png";
	}
	
	protected void setPos(int xpos, int ypos) {
		setX(xpos);
		setY(ypos);		
	}

}
