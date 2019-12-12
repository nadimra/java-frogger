package sprites;

import java.util.Random;

import controller.MainGameController;
import javafx.scene.image.Image;
import model.Lane;
import model.Main;


public class Ambulance extends Obstacle {
	private int xSize = 80;
	private int ySize = 40;
	private String imageLink = "file:src/resources/ambulance.png";
	
	private boolean droppedHeart;
	private int timeDrop;
	private Timer timer;
	//private DroppedHeart heartActor;
	private DroppedHeart heartActor;
	private Lane lane;
	
	public Ambulance(int xpos, int yposAssigned, double s, Lane lane) {
		super(xpos, yposAssigned, s);
		this.lane = lane;
		// TODO Auto-generated constructor stub
		setImage(new Image(imageLink, xSize,ySize, false, true));
		setPos(xpos,adjustPosY(yposAssigned));
		chooseRandomTime();
		timer = new Timer();
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0) {
			setX(-180);
		}
		if (getX()<-xSize && speed<0) {
			setX(Main.maxWidth);
		}
		
    	if (timer.getLastTime() != 0) {
            if (now > timer.getLastTime() + 1_000_000_000) {
                timer.incrementSeconds();
                timer.setLastTime(now);
            }
       } else {
            timer.setLastTime(now);
       }
		if(timer.getSeconds() == timeDrop) {
			createDropHeart();
		}
		
		
	}
	
	
	private int adjustPosY(int ypos) {
		return yPos = ((Lane.LANE_SIZE)-ySize)/2+ypos;
	}

	public void chooseRandomTime() {
        Random rand = new Random(); 
        timeDrop = rand.nextInt(10); 
        System.out.println(timeDrop + "time drop item");
	}
	
	private void setDroppedHeart(boolean bool) {
		droppedHeart = bool;
	}
	
	private boolean getDroppedHeart() {
		return droppedHeart;
	}
	
	public void createDropHeart() {
		//Check if the heart not dropped yet
		if(!getDroppedHeart()) {
			if((getX()<(Main.maxWidth)) && (getX()>0)) {
				heartActor = new DroppedHeart(getX(),yPos);
				//Add the item to the lane
				lane.addLaneItem(heartActor);
				System.out.println("created heart at" + (getX()));
				setDroppedHeart(true);
			}
			else {
				timeDrop += 1;
			}
		}
	}
	
	

	
}
