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
	
	public Lane(MyStage background, int laneNum, ActorTypes typeOfActor, int numActors) {
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
					background.add(LogFactory.getLog(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed));
					shift = shift + offset;
				}
				if(typeOfActor == ActorTypes.TruckBig || typeOfActor == ActorTypes.TruckSmall) {
					background.add(ObstacleFactory.getLog(typeOfActor, xStartPos + shift, laneNum*LANE_SIZE, speed));
					shift = shift + offset;
				}
				
				if(typeOfActor == ActorTypes.EndBlock) {
					shift = shift + offset;
					background.add(new End(shift+ (i-1)*End.imgSize,End.yPos));
					System.out.println("check");
				}
				
		}
	}
	
	
	private void calculateOffset() {
		offset = ((Main.maxWidth-(End.imgSize*numActors))/(numActors+1));
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
