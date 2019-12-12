package commands;

import javafx.scene.input.KeyCode;
import sprites.Animal;

/**
* This class provides the execution when the down key is pressed
* 
* @author Nadim Rahman
* 
*/
public class CommandDown implements Command{

	Animal animal; 
	KeyCode key;
	  
	/**
	 * This method initialises the variables
	* @param animal is the player variable controlled by the command
	* @param key is the keycode to control this class
	*/
    public CommandDown(Animal animal, KeyCode key) 
    { 
       this.animal = animal; 
       this.key = key;
    } 
    
    /**
    * This method handles the execution of the down command
    * @param img is the sprite to be loaded when the command executes
    * 
    */
    public void execute(String img) 
    { 
    	// Move the animal down
		animal.handleVerticalMovement(animal.getMoveY(),animal.getImage(img));	 
    } 
    
	/**
	 * 
	 * @return KeyCode representing the down command button is returned
	 */
    public KeyCode getKey() {
    	return key;
    }
}
