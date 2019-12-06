package p4_group_8_repo;

public class Lane extends Actor {
	static final int LANE_SIZE = 50;
	private int laneNum;
	private double speed;
	private String actorType;
	private int numActors;
	private int xStartPos;
	private int offset;
	private MyStage background;
	
	public Lane(MyStage background, int laneNum, double speed, String actorType, int numActors, int xStartPos, int offset) {
		this.background = background;

		this.laneNum = laneNum;
		this.speed = speed;
		this.actorType = actorType;
		this.numActors = numActors;
		this.xStartPos = xStartPos;
		this.offset = offset;
		System.out.println("Lanenum: " + laneNum + ", speed: "+speed+", type: " + actorType + ", num actors: " + numActors);
		populateLane();
	}
	
	private void populateLane() {
		int shift = 0;
		for(int i=1; i<= numActors; i++) {
			if(actorType.equals("LogBig")) {
				background.add(LogFactory.getLog("LogBig", xStartPos + shift, laneNum*LANE_SIZE, speed));
				System.out.println("created log");
				shift = shift + offset;
			}
		}
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
