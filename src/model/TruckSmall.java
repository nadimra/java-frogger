package model;

import javafx.scene.image.Image;

public class TruckSmall extends Truck{
	private int xSize = 120;
	private int ySize = 40;
	private String imageLink = "file:src/resources/truck1";
	
	public TruckSmall(int xpos, int yposAssigned, double s) { 
		super(xpos, yposAssigned, s);
		setImage(new Image(imageLink+setDirection(), xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	private int adjustPosY(int ypos) {
		return yPos = ((Lane.LANE_SIZE)-ySize)/2+ypos;
	}
}
