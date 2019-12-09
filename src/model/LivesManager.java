package model;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class LivesManager {
	private static int numLives;
	private boolean updateLives = false;
	private MyStage background;
	private int imgSize = 40;
	private ArrayList<Heart> livesCollection;
	private int originalLives;
	private boolean gameOver;

    /**
     * This method manages the scoring display and is updated after each change
     *
     */
	
	public LivesManager(MyStage background, int lives) {
		this.background = background;
		numLives = lives;
		originalLives = lives;
        livesCollection = new ArrayList<Heart>();

		createLives();
		displayLives();
		
	}
	
    public void displayLives() {
        for (Heart heart : livesCollection) { 		      
            background.add(heart);
        }
    }
    
    public void createLives() {
    	for(int i = 1; i<= numLives; i++) {
    		livesCollection.add(new Heart(imgSize,20 + i*imgSize,20));
    	}
    }
    
    public boolean getUpdateLives() {
    	return updateLives;
    }
    
    public void setUpdateLives(boolean val) {
    	updateLives = val;
    }
    
    public void addLives() {
    	
    	if(numLives<originalLives){
    		numLives = numLives + 1;
    	
	    	Heart last = livesCollection.get(livesCollection.size() - (originalLives - numLives)-1); 
	    	last.setAlive();
    	}	
    	
    }
    
    public void loseLife() {
    	numLives = numLives - 1;
    	Heart last = livesCollection.get(livesCollection.size() - (originalLives - numLives)); 
    	last.setDead();
    	if(numLives == 0) {
	    	gameOver = true;
    	}
    }
    

    
    public boolean getGameOver() {
    	return gameOver;
    }

}
