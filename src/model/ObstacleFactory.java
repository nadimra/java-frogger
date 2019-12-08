package model;

import model.LevelCreator.ActorTypes;

public class ObstacleFactory {
	public static Obstacle getTruck(ActorTypes typeOfActor, int xpos, int ypos, double s){
		if(typeOfActor == ActorTypes.TruckBig){
			return new TruckBig(xpos,ypos,s);
		}
		if(typeOfActor == ActorTypes.TruckSmall){
			return new TruckSmall(xpos,ypos,s);
		}

		return null;
	}
}
