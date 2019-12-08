package model;

import javafx.scene.input.KeyCode;

public class CommandDown implements Command{

	Animal animal; 
	KeyCode key;
	  
    // The constructor is passed the light it 
    // is going to control. 
    public CommandDown(Animal animal, KeyCode key) 
    { 
       this.animal = animal; 
       this.key = key;
    } 
    
    public void execute(String img) 
    { 
		animal.handleVerticalMovement(animal.getMoveY(),animal.getImage(img));	 
    } 
    
    public KeyCode getKey() {
    	return key;
    }
}
