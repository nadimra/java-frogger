package commands;

import javafx.scene.input.KeyCode;


/**
* This class provides an interface to implement the command design pattern and execute each command
* 
* @author Nadim Rahman
* 
*/
public interface Command {
	
	/**
	 * 
	 * @param img is the sprite that is loaded when the command happened
	 */
    public void execute(String img); 
    
	/**
	 * 
	 * @return KeyCode representing the command button is returned
	 */
    public KeyCode getKey();
}
