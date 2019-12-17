package sprites;

import javafx.scene.image.Image;
import model.Lane;

public class LogSmall extends Log {
	
	private static int xSize = 84;
	private static int ySize = 35;
	private String imageLink = "file:src/resources/log2.png";
	
	/**
	 * Initialises the variables and sets the image
	 * @param xpos
	 * @param yposAssigned
	 * @param s for speed
	 */
	public LogSmall(int xpos, int yposAssigned, double s) { 
		super(xpos, yposAssigned, s, xSize, ySize);
		setImage(new Image(imageLink, xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));

	}
	
}
