package model;

import java.util.ArrayList;

import model.LevelCreator.ActorTypes;

public class Lane extends Actor {
	static final int LANE_SIZE = 50;
	private int laneNum;
	private double speed;
	private ActorTypes typeOfActor;
	private int numActors;
	private int xStartPos;
	private int offset;
	private MyStage background;
	private ArrayList<Actor> itemCollection;
	
	
	public Lane(MyStage background, int laneNum, double speed, ActorTypes typeOfActor, int numActors, int xStartPos, int offset) {
		
		itemCollection = new ArrayList<Actor>();

		this.background = background;

		this.laneNum = laneNum;
		this.speed = speed;
		this.typeOfActor = typeOfActor;
		this.numActors = numActors;
		this.xStartPos = xStartPos;
		this.offset = offset;
		
		populateLane();
		
		
	}
	
	public Lane(MyStage background, int laneNum, ActorTypes typeOfActor, int numActors) {
		itemCollection = new ArrayList<Actor>();
		
		this.background = background;
		this.typeOfActor = typeOfActor;
		this.numActors = numActors;	
		calculateOffset();
		populateLane();

	}

	private void populateLane() {
		int shift = 0;
		for(int i=1; i<= numActors; i++) {
				if(typeOfActor == ActorTypes.LogBig || typeOfActor == ActorTypes.LogMedium || typeOfActor == ActorTypes.LogSmall) {
					Actor log = LogFactory.getLog(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed);
					itemCollection.add(log);
					background.add(log);
					shift = shift + offset;
				}
				if(typeOfActor == ActorTypes.TruckBig || typeOfActor == ActorTypes.TruckSmall) {
					Actor obs = ObstacleFactory.getTruck(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed);
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
	
	public void clearLane() {
		for(Actor item: itemCollection) {
			background.remove(item);
		}

	}
	
	public ArrayList<Actor> getItemCollection(){
		return itemCollection;
	}
	
	private void calculateOffset() {
		offset = ((Main.maxWidth-(End.imgSize*numActors))/(numActors+1));
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
