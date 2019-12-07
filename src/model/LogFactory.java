package model;

import model.LevelCreator.ActorTypes;

public class LogFactory {

	public static Log getLog(ActorTypes typeOfActor, int xpos, int ypos, double s){
		if(typeOfActor == ActorTypes.LogBig){
			return new LogBig(xpos,ypos,s);
		}
		if(typeOfActor == ActorTypes.LogMedium){
			return new LogMedium(xpos,ypos,s);
		}
		if(typeOfActor == ActorTypes.LogSmall){
			return new LogSmall(xpos,ypos,s);
		}
		return null;
	}
	
	
}
