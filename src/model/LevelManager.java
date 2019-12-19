package model;

import java.io.FileNotFoundException;

/**
 * This class manages which level is displayed on the screen
 * @author Nadim Rahman
 *
 */
public class LevelManager {
	private LevelCreator level;
	private int currentLevel;
	
	// Number of levels in the game
	public static final int MAX_LEVELS = 3;

	/**
	 * Initialises the variables
	 * @param background
	 * @throws FileNotFoundException
	 */
	public LevelManager(MyStage background) throws FileNotFoundException {
		currentLevel = 0;
		level = new LevelCreator(background);
	}
	
	/**
	 * Loads the next level
	 * @throws FileNotFoundException
	 */
	public void getNextLevel() throws FileNotFoundException {
		currentLevel += 1;
		// Checks if there still needs levels to be completed
		if(currentLevel<=MAX_LEVELS) {
			level.clearLevel();
			level.loadLevelFile(currentLevel);
		}
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public int getNumEnds() {
		return level.getNumEnds();
	}
	
	/**
	 * Check whether the level screen needs updating with objects
	 * @return true if needs updating, false otherwise
	 */
	public boolean needUpdate() {
		return level.needUpdateAdditions();
	}
	
	/**
	 * Add items to the level 
	 */
	public void updateAdditions() {
		level.addItem();;
	}
}
