package model;

import java.util.HashMap;

import model.LevelCreator.ActorTypes;

public class TurtleFactory {
		private static HashMap <String, Turtle> hm = new HashMap<String, Turtle>(); 

		public static Turtle getTurtle(ActorTypes typeOfActor, int xpos, int ypos, double s){
	        Turtle p = null; 
	        if (hm.containsKey(typeOfActor)) 
	            p = hm.get(typeOfActor); 
	        else
	        { 
				if(typeOfActor == ActorTypes.NormalTurtle){
					p = new NormalTurtle(xpos,ypos,s);
				}
				if(typeOfActor == ActorTypes.WetTurtle){
					p = new WetTurtle(xpos,ypos,s);
				}
	        }
	        return p;
		}
		
		
	}

