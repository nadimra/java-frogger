package model;

import java.util.HashMap;

import model.LevelCreator.ActorTypes;

public class ObstacleFactory {
    private static HashMap <String, Obstacle> hm = new HashMap<String, Obstacle>(); 

	public static Obstacle getTruck(ActorTypes typeOfActor, int xpos, int ypos, double s){
        Obstacle p = null; 
        if (hm.containsKey(typeOfActor)) 
            p = hm.get(typeOfActor); 
        else
        { 
			if(typeOfActor == ActorTypes.TruckBig){
				p = new TruckBig(xpos,ypos,s);
			}
			if(typeOfActor == ActorTypes.TruckSmall){
				p = new TruckSmall(xpos,ypos,s);
			}
			if(typeOfActor == ActorTypes.Ambulance){
				p = new Ambulance(xpos,ypos,s);
			}
        }
		return p;
	}
}
