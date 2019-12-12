package commands;

import javafx.scene.input.KeyCode;
import sprites.Animal;

/**
* This class provides the execution when the right key is pressed
* 
* @author Nadim Rahman
* 
*/
public class CommandRight implements Command{
	Animal animal; 
	KeyCode key;
	  
	/**
	* This method initialises the variables
	* @param animal is the player variable controlled by the command
	* @param key is the keycode to control this class
	* 
	*/
    public CommandRight(Animal animal, KeyCode key) 
    { 
       this.animal = animal; 
       this.key = key;
    } 
    
    /**
    * This method handles the execution of the right command
    * @param img is the sprite to be loaded when the command executes
    * 
    */
    public void execute(String img) 
    { 
		animal.handleHorizontalMovement(animal.getMoveX(),animal.getImage(img));	 
    } 
    
	/**
	 * 
	 * @return KeyCode representing the right command button is returned
	 */
    public KeyCode getKey() {
    	return key;
    }
}
