package model;

import java.io.FileNotFoundException;

public class LevelManager {
	LevelCreator level;
	private int currentLevel;
	public static final int MAX_LEVELS = 2;

	public LevelManager(MyStage background) throws FileNotFoundException {
		currentLevel = 0;
		level = new LevelCreator(background);
	}
	
	public void getNextLevel() throws FileNotFoundException {
		currentLevel += 1;
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
}
