package sprites;

import java.util.HashMap;

import model.Lane;
import model.LevelCreator.ActorTypes;

/**
 * This class creates different types of obstacles
 * Using the factory and flyweight design pattern
 * @author Nadim Rahman
 *
 */
public class ObstacleFactory {
    private static HashMap <String, Obstacle> hm = new HashMap<String, Obstacle>(); 

    /**
     * Create the obstacle
     * @param typeOfActor the type of obstacles
     * @param xpos
     * @param ypos
     * @param s for speed
     * @return log
     */
	public static Obstacle getObstacle(ActorTypes typeOfActor, int xpos, int ypos, double s,Lane lane){
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
				p = new Ambulance(xpos,ypos,s, lane);
			}
        }
		return p;
	}
}
