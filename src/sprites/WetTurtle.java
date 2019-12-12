package sprites;

import javafx.scene.image.Image;

public class WetTurtle extends Turtle{

	private int xSize = 120;
	private int ySize = 50; 
	
	Image turtle4;

	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, double s) {
		super(xpos,ypos,s);
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png",xSize, ySize,false, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2Wet.png", xSize, ySize, false, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3Wet.png", xSize, ySize, false, true);
		turtle4 = new Image("file:src/resources/TurtleAnimation4Wet.png", xSize, ySize, false, true);
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
