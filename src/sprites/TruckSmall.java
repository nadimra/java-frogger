package sprites;

import javafx.scene.image.Image;
import model.Lane;
import model.Main;

/** 
 * This class represents a small truck
 * @author Nadim Rahman
 *
 */
public class TruckSmall extends Truck{
	private static int xSize = 120;
	private static int ySize = 40;
	private String imageLink = "file:src/resources/truck1";
	
	/**
	 * Initialise the variables
	 * @param xpos
	 * @param yposAssigned
	 * @param s
	 */
	public TruckSmall(int xpos, int yposAssigned, double s) { 
		super(xpos, yposAssigned, s,xSize,ySize);
		setImage(new Image(imageLink+setDirection(), xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));
	}
	

}
