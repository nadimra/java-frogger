package model;

import java.util.ArrayList;

import javafx.scene.image.Image;
import sprites.Heart;

/**
 * This class manages the lives for each level
 * @author Nadim Rahman
 *
 */
public class LivesManager {
	private static int numLives;
	private boolean updateLives = false;
	private MyStage background;
	private int imgSize = 40;
	private ArrayList<Heart> livesCollection;
	private int originalLives;
	private boolean gameOver;


	/**
	 * Initialises the variables
	 * @param background
	 * @param lives
	 */
	public LivesManager(MyStage background, int lives) {
		this.background = background;
		numLives = lives;
		originalLives = lives;
        livesCollection = new ArrayList<Heart>();

		createLives();
		displayLives();
		
	}
	
	/**
	 * Display the lives on the creen
	 */
    public void displayLives() {
        for (Heart heart : livesCollection) { 		      
            background.add(heart);
        }
    }
   
    /**
     * Create the specified number of lives
     */
    public void createLives() {
    	for(int i = 1; i<= numLives; i++) {
    		livesCollection.add(new Heart(imgSize,20 + i*imgSize,20));
    	}
    }
    
    /**
     * Check if the screen needs updating
     * @return updateLives
     */
    public boolean getUpdateLives() {
    	return updateLives;
    }
    

    public void setUpdateLives(boolean val) {
    	updateLives = val;
    }
    
    /**
     * Give the user an additional life
     */
    public void addLives() {
    	// Check if the user has the max number of lives
    	if(numLives<originalLives){
    		numLives = numLives + 1;
    	
	    	Heart last = livesCollection.get(livesCollection.size() - (originalLives - numLives)-1); 
	    	last.setAlive();
    	}	
    	
    }
    
    /**
     * Decrement the number of lives
     */
    public void loseLife() {
    	numLives = numLives - 1;
    	// Get the last heart displayed on the screen and set the image
    	Heart last = livesCollection.get(livesCollection.size() - (originalLives - numLives)); 
    	last.setDead();
    	// End the game if the user has run out of lives
    	if(numLives == 0) {
	    	gameOver = true;
    	}
    }
    
    public boolean getGameOver() {
    	return gameOver;
    }
    
    public int getNumLives() {
    	return numLives;
    }

}
