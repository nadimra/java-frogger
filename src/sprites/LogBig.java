package sprites;

import javafx.scene.image.Image;
import model.Lane;

public class LogBig extends Log {
	
	private int xSize = 178;
	private int ySize = 35;
	private String imageLink = "file:src/resources/log3.png";
	
	public LogBig(int xpos, int yposAssigned, double s) { 
		super(xpos, yposAssigned, s);
		setImage(new Image(imageLink, xSize,ySize, false, true));
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
	
	private void setPos(int xpos, int ypos) {
		setX(xpos);
		setY(ypos);		
	}
	
	

}
