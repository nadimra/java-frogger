package model;

import javafx.scene.image.Image;

public class DroppedHeart extends Actor {
	int dim = 40;
	Image heartImage;
	Ambulance ambulance;


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public DroppedHeart(double d, int y) {
		heartImage = new Image("file:src/resources/heart.png", dim, dim, true, true);
		setImage(heartImage);
		setX(d);
		setY(y);
	}
	
	
}
