package model;

import javafx.scene.image.Image;

public class Heart extends Actor{
	int dim;
	Image aliveImg;
	Image deadImg;

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Heart(int dim, int x, int y) {
		aliveImg = new Image("file:src/resources/heart.png", dim, dim, true, true);
		deadImg = new Image("file:src/resources/heartdead.png", dim, dim, true, true);

		setImage(aliveImg);
		setX(x);
		setY(y);
	}
	
	public void setDead() {
		setImage(deadImg);

	}
	
}
