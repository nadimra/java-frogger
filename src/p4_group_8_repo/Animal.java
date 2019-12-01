package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The object of this class represents the player character.
 * 
 * @author Nadim Rahman
 * @version 1.0
 * @since 27-11-2019
 *
 */
public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	
	int points = 0;
	int end = 0;
	
	private boolean secondAnimation = false;
	boolean noMove = false;
	
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	/**
	 * This method sets up the class and initialises key variables.
	 * @param imageLink stores the image of the frog.
	 * 
	 */
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(Main.maxWidth/2);
		setY(Main.maxHeight-movement*2);
		
		imgW1 = new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/resources/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/resources/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/resources/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/resources/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/resources/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/resources/froggerRightJump.png", imgSize, imgSize, true, true);
		
		keyPress();
		keyRelease();
	}
	
	/**
	 * This method is called when a key is pressed and manages what happens for specific keys.
	 * 
	 */
	public void keyPress() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				KeyCode keyPress = event.getCode();
				if (noMove) {} // Don't do anything
				else {
					// Set sprite back to the normal directional sprite
					if (getSecondAnimation()) {
						switch(keyPress) {
							case W: 
								changeScore = false;
								handleVerticalMovement(-movement, imgW1);	 
								break;
							case A:       	
								handleHorizontalMovement(-movementX, imgA1);
								break;
							case S:
								handleVerticalMovement(movement, imgS1);	 
								break;
							case D:	            	
								handleHorizontalMovement(movementX, imgD1);
								break;
						}
					}
					else {
						// Set sprite to the 'jumping' directional sprite
						switch(keyPress) {
							case W: 
								handleVerticalMovement(-movement, imgW2);	 
								break;
							case A: 
					            handleHorizontalMovement(-movementX, imgA2);      
					            break;
							case S:
					            handleVerticalMovement(movement, imgS2);	 
					            break;
							case D:
					            handleHorizontalMovement(movementX, imgD2);   
					            break;
						}
					}
				}
			}
				
		});	
	}
	
	/**
	 * This method is called when a key is released and manages what happens for specific keys.
	 * 
	 */
	public void keyRelease() {
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				KeyCode keyPress = event.getCode();
				if (noMove) {} // Don't do anything
				else {
					switch(keyPress) {
						case W:
							if (getY() < w) {
								changeScore = true;
								w = getY();
								points+=10;
							}
					        handleVerticalMovement(-movement, imgW1);   
					        break;         
						case A:	            	
					         handleHorizontalMovement(-movementX, imgA1);   
					         break;
						case S:
					         handleVerticalMovement(movement, imgS1);  
					         break;
						case D:            	
					         handleHorizontalMovement(movementX, imgD1);
					         break;
					}
				}
			}
		});
	}
	
	/**
	 * This method handles the horizontal movement of a player.
	 * @param movePixels is the amount of pixels the sprite should move horizontally.
	 * @param imageSet is the Image that will be set on the sprite when a movement occurs.
	 * 
	 */
	public void handleHorizontalMovement(double movePixels, Image imageSet) {
	   	 move(movePixels, 0);
	   	 setImage(imageSet);
	   	 setSecondAnimation();
	}
	
	/**
	 * This method handles the vertical movement of a player.
	 * @param movePixels is the amount of pixels the sprite should move vertically.
	 * @param imageSet is the Image that will be set on the sprite when a movement occurs.
	 * 
	 */
	public void handleVerticalMovement(double movePixels, Image imageSet) {
	   	 move(0, movePixels);
	   	 setImage(imageSet);
	   	 setSecondAnimation();
	}
	
	/**
	 * This method reverts the value of the secondAnimation variable.
	 * 
	 */
	public void setSecondAnimation() {
		secondAnimation = !getSecondAnimation();
	}
	
	/**
	 * Method to check if the sprite is 'jumping' or not
	 * 
	 */
	public boolean getSecondAnimation() {
		return secondAnimation;
	}
	
	@Override
	public void act(long now) {
		int bounds = 0;
		
		handleBoundFrog();
		
		if (carDeath) {
			noMove = true;
			if ((now)%11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/resources/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/resources/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/resources/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
		}
		
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/resources/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/resources/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/resources/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/resources/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				updatePoints(-50);
			}
			updatePoints(50);
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	
	/**
	 * This method checks if the player has reached all the end points in a level.
	 * 
	 */
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	/**
	 * This method updates the points.
	 * @param n is the amount of points to add to the total points.
	 * 
	 */
	public void updatePoints(int n) {
		points = getPoints() + n;
	}
	
	/**
	 * This method returns a boolean which decides whether to update the score on the GUI or not, and resets the value after.
	 * 
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	private void handleBoundFrog() {
		//Bound the frog to the screen
		if (getY()<0 || getY()>734) {
			setY(Main.maxHeight-movement*2);
		}
		if (getX()<0-imgSize/2) {
			move(movement*2, 0);
		}
		if (getX()>Main.maxWidth-imgSize/2) {
			move(-movement*2, 0);
		}
	}

}
