package model;

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
	
	
	public Lane(MyStage background, int laneNum, double speed, ActorTypes typeOfActor, int numActors, int xStartPos, int offset) {
		this.background = background;

		this.laneNum = laneNum;
		this.speed = speed;
		this.typeOfActor = typeOfActor;
		this.numActors = numActors;
		this.xStartPos = xStartPos;
		this.offset = offset;
		populateLane();
	}
	
	private void populateLane() {
		int shift = 0;
		for(int i=1; i<= numActors; i++) {
				if(typeOfActor == ActorTypes.LogBig || typeOfActor == ActorTypes.LogMedium || typeOfActor == ActorTypes.LogSmall) {
					background.add(LogFactory.getLog(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed));
				}
				if(typeOfActor == ActorTypes.TruckBig || typeOfActor == ActorTypes.TruckSmall) {
					background.add(ObstacleFactory.getLog(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed));
				}
				shift = shift + offset;
		}
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
