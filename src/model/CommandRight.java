package model;

import javafx.scene.input.KeyCode;

public class CommandRight implements Command{
	Animal animal; 
	KeyCode key;
	  
    // The constructor is passed the light it 
    // is going to control. 
    public CommandRight(Animal animal, KeyCode key) 
    { 
       this.animal = animal; 
       this.key = key;
    } 
    
    public void execute(String img) 
    { 
		animal.handleHorizontalMovement(animal.getMoveX(),animal.getImage(img));	 
    } 
    
    public KeyCode getKey() {
    	return key;
    }
}
