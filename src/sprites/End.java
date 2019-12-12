package sprites;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	public static final int imgSize = 60;
	public static final int yPos = 96;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/resources/End.png", imgSize, imgSize, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/resources/FrogEnd.png", imgSize, imgSize, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public int getImageSize() {
		return imgSize;
	}

}
