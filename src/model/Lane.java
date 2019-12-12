package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.LevelCreator.ActorTypes;
import sprites.Actor;
import sprites.LogFactory;
import sprites.ObstacleFactory;
import sprites.TurtleFactory;
import sprites.End;

/**
* This class creates a lane with objects
* 
* @author Nadim Rahman
* 
*/
public class Lane extends Actor {
	public static final int LANE_SIZE = 50;
	private int laneNum;
	private double speed;
	private ActorTypes typeOfActor;
	private int numActors;
	private int xStartPos;
	private int offset;
	private MyStage background;
	private ArrayList<Actor> itemCollection;
	private ArrayList<Actor> addedLaneItems = new ArrayList<>();

	
	/**
	* Initialises the variables
	* 
	* @param background
	* @param laneNum
	* @param speed
	* @param typeOfActor
	* @param numActors
	* @param xStartPos
	* @param offset
	* 
	*/
	public Lane(MyStage background, int laneNum, double speed, ActorTypes typeOfActor, int numActors, int xStartPos, int offset) {
		
		itemCollection = new ArrayList<Actor>();
		addedLaneItems = new ArrayList<Actor>();


		this.background = background;

		this.laneNum = laneNum;
		this.speed = speed;
		this.typeOfActor = typeOfActor;
		this.numActors = numActors;
		this.xStartPos = xStartPos;
		this.offset = offset;
		
		populateLane();
		
		
	}
	
	/**
	* Initialises the variables, used for end objects
	* 
	* @param background
	* @param laneNum
	* @param speed
	* @param typeOfActor
	* @param numActors
	* @param xStartPos
	* @param offset
	* 
	*/
	public Lane(MyStage background, int laneNum, ActorTypes typeOfActor, int numActors) {
		itemCollection = new ArrayList<Actor>();
		
		this.background = background;
		this.typeOfActor = typeOfActor;
		this.numActors = numActors;	
		calculateOffset();
		populateLane();

	}

	/**
	* Populates the lane with objects
	* 
	*/
	private void populateLane() {
		int shift = 0;
		// Loops through the number of actors to add
		for(int i=1; i<= numActors; i++) {
				// Check the type of actor and call the assigned factory
				// Add item to the item collection and add to the stage, adjust shift so that next actor is positioned correctly
				if(typeOfActor == ActorTypes.LogBig || typeOfActor == ActorTypes.LogMedium || typeOfActor == ActorTypes.LogSmall) {
					Actor log = LogFactory.getLog(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed);
					itemCollection.add(log);
					background.add(log);
					shift = shift + offset;
				}
				if(typeOfActor == ActorTypes.TruckBig || typeOfActor == ActorTypes.TruckSmall || typeOfActor == ActorTypes.Ambulance) {
					Actor obs = ObstacleFactory.getObstacle(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed,this);
					itemCollection.add(obs);
					background.add(obs);
					shift = shift + offset;
				}
				
				if(typeOfActor == ActorTypes.EndBlock) {
					shift = shift + offset;
					Actor end = new End(shift+ (i-1)*End.imgSize,End.yPos);
					itemCollection.add(end);
					background.add(end);
				}
				
				if(typeOfActor == ActorTypes.NormalTurtle || typeOfActor == ActorTypes.WetTurtle) {
					Actor turtle = TurtleFactory.getTurtle(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed);
					itemCollection.add(turtle);
					background.add(turtle);
					shift = shift + offset;
				}
				

				
		}
	}
	
	/**
	* Get each item in the lane and remove from the background
	* 
	*/
	public void clearLane() {
		for(Actor item: itemCollection) {
			background.remove(item);
		}

	}
	
	public ArrayList<Actor> getItemCollection(){
		return itemCollection;
	}
	
	/**
	* Method to calculate the spacing of the end objects
	* 
	*/
	private void calculateOffset() {
		offset = ((Main.maxWidth-(End.imgSize*numActors))/(numActors+1));
	}
	
	/**
	 * Get items that were added after the level has been updated
	 * 
	 */
	public ArrayList<Actor> getAddedLaneItems() {
		return addedLaneItems;
	}
	
	/**
	 * Add an item that needs to be updated after the level has been created
	 * 
	 */
	public void addLaneItem(Actor item) {
		addedLaneItems.add(item);
	}
	
	/**
	 * @return a boolean if the level needs to be updated
	 * 
	 */
	public boolean needToAdd() {
		return addedLaneItems.size()>0;
	}
	
	/**
	 * Items have been added, so can be removed from the list
	 * 
	 */
	public void clearAddedLaneItems() {
		addedLaneItems.clear();
	}
	
	
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
