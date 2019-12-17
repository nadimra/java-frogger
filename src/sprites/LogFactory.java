package sprites;

import java.util.HashMap;

import model.LevelCreator.ActorTypes;

/**
 * This class creates different types of logs
 * Using the factory and flyweight design pattern
 * @author Nadim Rahman
 *
 */
public class LogFactory {

    private static HashMap <String, Log> hm = new HashMap<String, Log>(); 
    
    /**
     * Create the log
     * @param typeOfActor the type of log
     * @param xpos
     * @param ypos
     * @param s for speed
     * @return log
     */
	public static Log getLog(ActorTypes typeOfActor, int xpos, int ypos, double s){
        Log p = null; 
        if (hm.containsKey(typeOfActor)) 
            p = hm.get(typeOfActor); 
        else
        { 
			if(typeOfActor == ActorTypes.LogBig){
				p = new LogBig(xpos,ypos,s);
			}
			if(typeOfActor == ActorTypes.LogMedium){
				p =  new LogMedium(xpos,ypos,s);
			}
			if(typeOfActor == ActorTypes.LogSmall){
				p = new LogSmall(xpos,ypos,s);
			}
        }
		return p;
	}
	
	
}
