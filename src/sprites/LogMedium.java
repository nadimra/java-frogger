package sprites;

import javafx.scene.image.Image;
import model.Lane;

public class LogMedium extends Log {
	
	private static int xSize = 117;
	private static int ySize = 35;
	private String imageLink = "file:src/resources/log2.png";
	
	/**
	 * Initialises the variables and sets the image
	 * @param xpos
	 * @param yposAssigned
	 * @param sfor speed
	 */
	public LogMedium(int xpos, int yposAssigned, double s) { 
		super(xpos, yposAssigned, s, xSize, ySize);
		setImage(new Image(imageLink, xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));

	}

	
}
