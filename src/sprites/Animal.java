package sprites;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Lane;
import model.LivesManager;
import model.Main;
import model.Score;

/**
 * The object of this class represents the player character.
 * 
 * @author Nadim Rahman
 * @version 1.0
 * @since 27-11-2019
 *
 */
public class Animal extends Actor {
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	
	private int points = 0;
	private int end = 0;
	
	private boolean secondAnimation = false;
	boolean noMove = false;
	
	private double movement = 12.5*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private int deathCount;
	private LivesManager lives;
	
	private Score score;
	
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private ArrayList<End> inter = new ArrayList<End>();
	private boolean updateDeath;
	private int numEnds;
	private boolean collideDroppedHeart;
	private DroppedHeart heartCollision;
	

	/**
	 * This method sets up the class and initialises key variables.
	 * @param imageLink stores the image of the frog.
	 * @param score 
	 * @param lives
	 * 
	 */
	public Animal(String imageLink, Score score, LivesManager lives) {
		initialisePlayer(imageLink);
		this.score = score;
		this.lives = lives;
		
		imgW1 = new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/resources/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/resources/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/resources/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/resources/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/resources/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/resources/froggerRightJump.png", imgSize, imgSize, true, true);
		
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
	
	/**
	 * Method to control how the player acts, such as collisions and deaths.
	 * 
	 */
	@Override
	public void act(long now) {
		int bounds = 0;
		
		handleBoundFrog();
		handleCarDeath(now);
		handleWaterDeath(now);
		handleCollision();
		
	}
	
	/**
	 * This method checks if the player has reached all the end points in a level.
	 * 
	 */
	public boolean getStop() {
		return end==getNumEnds();
	}
	
	public void setStop() {
		end=0;
	}
	
	/**
	 * Sets the number of ends there are in the level
	 * @param n for number of ends
	 */
	public void setNumEnds(int n) {
		numEnds = n;
	}
	
	public int getNumEnds() {
		return numEnds;
	}
	
	/**
	 * Method to bound the player within the screen.
	 * 
	 */
	private void handleBoundFrog() {
		//Bound the frog to the screen
		if (getY()<0 || getY()>Main.maxHeight-movement*1.5) {
			setY(Main.maxHeight-movement*1.5);
		}
		if (getX()<0-imgSize/2) {
			move(movement*2, 0);
		}
		if (getX()>Main.maxWidth-imgSize/2) {
			move(-movement*2, 0);
		}
	}
	
	/**
	 * Method to handle the players death when hitting a car.
	 * 
	 */
	private void handleCarDeath(long now) {
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
				initialisePlayer("file:src/resources/froggerUp.png");
				lives.loseLife();

			}

		}
	}
	
	/**
	 * Method to handle the players death when touching water.
	 * 
	 */
	private void handleWaterDeath(long now) {
		if (waterDeath) {
			noMove = true;
			if ((now)%11 ==0) {
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
				initialisePlayer("file:src/resources/froggerUp.png");
				lives.loseLife();

			}

			
		}
	}
	
	/**
	 * Method to handle the specific types of collisions between objects.
	 * 
	 */
	private void handleCollision() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			handleCarCollision();
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			handleLogCollision();
		}
		else if (getIntersectingObjects(NormalTurtle.class).size() >= 1 && !noMove) {
			handleTurtleCollision();
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			handleWetTurtleCollision();
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			handleEndCollision();
		}
		else if (getIntersectingObjects(DroppedHeart.class).size() >= 1) {
			collideDroppedHeart = true;
			heartCollision =getOneIntersectingObject(DroppedHeart.class);
		}
		else if (getY()<Lane.LANE_SIZE*9 -25){
			waterDeath = true;
		}
	}
	
	/**
	 * Method to control what happens when the player hits a car.
	 * 
	 */
	private void handleCarCollision() {
		carDeath = true;
	}
	
	/**
	 * Method to control what happens when the player hits a log.
	 * 
	 */
	private void handleLogCollision() {
		move(getIntersectingObjects(Log.class).get(0).getSpeed(),0);

	}
	
	/**
	 * Method to control what happens when the player touches a turtle.
	 * 
	 */
	private void handleTurtleCollision() {
		move(getIntersectingObjects(NormalTurtle.class).get(0).getSpeed(),0);
	}
	
	/**
	 * Method to control what happens when the player touches a wet turtle.
	 * 
	 */
	private void handleWetTurtleCollision() {
		if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
			waterDeath = true;
		} else {
			// Move the player with the turtle
			move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
		}
	}
	
	/**
	 * Method to control what happens when the player touches an end object.
	 * 
	 */
	private void handleEndCollision() {
		inter = (ArrayList<End>) getIntersectingObjects(End.class);
		if (getIntersectingObjects(End.class).get(0).isActivated()) {
		}
		else {
			score.updatePoints(50);
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
		}
		setW(Main.maxHeight);
		// Reset player position
		initialisePlayer("file:src/resources/froggerUp.png");
	}
	
	/**
	 * Method to control the player when they get restarted to the start point.
	 * @param imageLink is the image of the player sprite
	 */
	private void initialisePlayer(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(Main.maxWidth/2);
		setY(Main.maxHeight-movement*1.5);
		noMove = false;
		waterDeath = false;
		carDeath = false;
		carD = 0;
	}
	
	/**
	 * Check if the player is moving
	 * @return noMove 
	 */
	public boolean getNoMove() {
		return noMove;
	}
	
	public double getMoveX() {
		return movementX;
	}
	
	public double getMoveY() {
		return movement;
	}
	
	public double getW() {
		return w;
	}
	
	public void setW(double setW) {
		w = setW;
	}
	
	/**
	 * Check if the user has collected a dropped heart
	 * @return collideDroppedHeart
	 */
	public boolean getCollidedDroppedHeart() {
		return collideDroppedHeart;
	}
	
	public void setCollidedDroppedHeart(boolean val) {
		collideDroppedHeart = val;
	}
	
	public DroppedHeart getHeartCollision() {
		return heartCollision;
	}
	
	/**
	 * Return an image link depending on the actors movement
	 * @param imageName is the movement the actor made
	 * @return an Image
	 */
	public Image getImage(String imageName) {
		switch(imageName) {
		  case "W1":
			return imgW1;
		  case "W2":
			return imgW2;
		  case "A1":
			return imgA1;
		case "A2":
			return imgA2;
		case "S1":
			return imgS1;
		  case "S2":
			return imgS2;
		  case "D1":
			return imgD1;
		  case "D2":
			return imgD2;
		}
		return null;

	}
		

	
}
