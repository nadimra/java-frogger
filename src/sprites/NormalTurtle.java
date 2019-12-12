package sprites;

import javafx.scene.image.Image;

public class NormalTurtle extends Turtle{
	private int xSize = 120;
	private int ySize = 50;
	
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);	
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public NormalTurtle(int xpos, int ypos, double s) {
		super(xpos,ypos,s);
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", xSize, ySize, false, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2.png", xSize, ySize, false, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3.png", xSize, ySize, false, true);
		setImage(turtle2);
	}
}
