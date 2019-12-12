package commands;

import javafx.scene.input.KeyCode;

/**
* This class is a manager for all the movement commands in the game
* 
* @author Nadim Rahman
* 
*/
public class Options {
	  private Command goUp;
	  private Command goDown;
	  private Command goLeft;
	  private Command goRight;
	  
	  /**
	  * This class initialises the key variables
	  * @param up is the command for vertical up movement
	  * @param down is the command for vertical down movement
	  * @param left is the command for horizontal left movement
	  * @param right is the command for horizontal right movement
	  * 
	  * @author Nadim Rahman
	  * 
	  */
	  public Options(Command up, Command down, Command left, Command right )
	  {
	    this.goUp = up;
	    this.goDown = down;
	    this.goLeft = left;
	    this.goRight = right;
	  }
	  
	  /**
	  * This method executes when the up key is pressed
	  * @param img is the image string when up movement happens
	  * 
	  */
	  public void pressUp(String img) {
		  goUp.execute(img);
	  }
	  
	  /**
	  * This method executes when the down key is pressed
	  * @param img is the image string when down movement happens
	  * 
	  */
	  public void pressDown(String img) {
		  goDown.execute(img);
	  }
	  
	  /**
	  * This method executes when the left key is pressed
	  * @param img is the image string when left movement happens
	  * 
	  */
	  public void pressLeft(String img) {
		  goLeft.execute(img);
	  }
	  
	  /**
	  * This method executes when the right key is pressed
	  * @param img is the image string when right movement happens
	  * 
	  */
	  public void pressRight(String img) {
		  goRight.execute(img);
	  }
	  
	  /**
	  * @return the key for the up command
	  * 
	  */
	  public KeyCode getUpKey() {
		  return goUp.getKey();
	  }
	  
	  /**
	  * @return the key for the down command
	  * 
	  */
	  public KeyCode getDownKey() {
		  return goDown.getKey();
	  }
	  
	  /**
	  * @return the key for the left command
	  * 
	  */
	  public KeyCode getLeftKey() {
		  return goLeft.getKey();
	  }
	  
	  /**
	  * @return the key for the right command
	  * 
	  */
	  public KeyCode getRightKey() {
		  return goRight.getKey();
	  }
}
