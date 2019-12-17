package sprites;

import javafx.scene.image.Image;
import model.Lane;
import model.Main;

/**
 * This class represents a big log object
 * @author Nad
 *
 */
public class LogBig extends Log {
	
	private static int xSize = 178;
	private static int ySize = 35;
	private String imageLink = "file:src/resources/log3.png";
	
	/**
	 * Initialises the variables and sets the image
	 * @param xpos
	 * @param yposAssigned
	 * @param s for speed
	 */
	public LogBig(int xpos, int yposAssigned, double s) { 
		super(xpos, yposAssigned, s, xSize, ySize);
		setImage(new Image(imageLink, xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));

	}
	

	
	

}
