package sprites;

import java.util.Random;

import controller.MainGameController;
import javafx.scene.image.Image;
import model.Lane;
import model.Main;

/**
 * This class represents an obstacle which can unload lives at random times
 * @author Nadim Rahman
 *
 */
public class Ambulance extends Obstacle {
	private int xSize = 80;
	private int ySize = 40;
	private String imageLink = "file:src/resources/ambulance.png";
	
	private boolean droppedHeart;
	private int timeDrop;
	private Timer timer;
	private DroppedHeart heartActor;
	private Lane lane;
	
	/**
	 * Initialise variables
	 * @param xpos the initial x position
	 * @param yposAssigned the initial y position
	 * @param s the speed the object is moving
	 * @param lane number that the object is located
	 */
	public Ambulance(int xpos, int yposAssigned, double s, Lane lane) {
		super(xpos, yposAssigned, s);
		this.lane = lane;
		// TODO Auto-generated constructor stub
		setImage(new Image(imageLink, xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));
		chooseRandomTime();
		timer = new Timer();
	}
	
	/**
	 * Controls the actor every frame
	 * @param now is the duration the object has been living for
	 */
	@Override
	public void act(long now) {
		// Move the actor
		move(speed , 0);
		
		// Setting the bounds
		if (getX()>600 && speed>0) {
			setX(-180);
		}
		if (getX()<-xSize && speed<0) {
			setX(Main.maxWidth);
		}
		
		// Control the timer object for the actor
    	if (timer.getLastTime() != 0) {
            if (now > timer.getLastTime() + 1_000_000_000) {
                timer.incrementSeconds();
                timer.setLastTime(now);
            }
       } else {
            timer.setLastTime(now);
       }
    	
    	// Unload a heart if a certain time is reached
		if(timer.getSeconds() == timeDrop) {
			createDropHeart();
		}
	}
	
	/**
	 * Adjusts the y position so that the image is in the middle of lane
	 * @param ypos original lane y position
	 * @return an adjusted y position 
	 */
	private int adjustPosY(int ypos) {
		return yPos = ((Lane.LANE_SIZE)-ySize)/2+ypos;
	}

	/**
	 * Choose to unload a life at any time within the level
	 */
	public void chooseRandomTime() {
        Random rand = new Random(); 
        timeDrop = rand.nextInt(60); 
	}
	
	/**
	 * Check if the ambulance has dropped a heart
	 * @param true if the ambulance has already unloaded
	 */
	private void setDroppedHeart(boolean bool) {
		droppedHeart = bool;
	}
	
	private boolean getDroppedHeart() {
		return droppedHeart;
	}
	
	/**
	 * Drop a heart
	 */
	public void createDropHeart() {
		//Check if the heart not dropped yet
		if(!getDroppedHeart()) {
			// Check if the ambulance is within the screen
			if((getX()<(Main.maxWidth)) && (getX()>0)) {
				heartActor = new DroppedHeart(getX(),yPos);
				
				//Add the item to the lane
				lane.addLaneItem(heartActor);
				setDroppedHeart(true);
			}
			else {
			// Wait the next second to drop the heart
				timeDrop += 1;
			}
		}
	}
	

	
}
