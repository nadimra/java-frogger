package model;

import javafx.scene.input.KeyCode;

public class Options {
	  private Command goUp;
	  private Command goDown;
	  private Command goLeft;
	  private Command goRight;
	  
	  public Options(Command up, Command down, Command left, Command right )
	  {
	    this.goUp = up;
	    this.goDown = down;
	    this.goLeft = left;
	    this.goRight = right;
	  }
	  
	  public void pressUp(String img) {
		  goUp.execute(img);
	  }
	  
	  public void pressDown(String img) {
		  goDown.execute(img);
	  }
	  
	  public void pressLeft(String img) {
		  goLeft.execute(img);
	  }
	  
	  public void pressRight(String img) {
		  goRight.execute(img);
	  }
	  
	  public KeyCode getUpKey() {
		  return goUp.getKey();
	  }
	  
	  public KeyCode getDownKey() {
		  return goDown.getKey();
	  }
	  
	  public KeyCode getLeftKey() {
		  return goLeft.getKey();
	  }
	  
	  public KeyCode getRightKey() {
		  return goRight.getKey();
	  }
}
