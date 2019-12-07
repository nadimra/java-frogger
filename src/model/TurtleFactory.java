package model;

import model.LevelCreator.ActorTypes;

public class TurtleFactory {

		public static Turtle getTurtle(ActorTypes typeOfActor, int xpos, int ypos, double s){
			if(typeOfActor == ActorTypes.NormalTurtle){
				return new NormalTurtle(xpos,ypos,s);
			}
			if(typeOfActor == ActorTypes.WetTurtle){
				return new WetTurtle(xpos,ypos,s);
			}

			return null;
		}
		
		
	}

