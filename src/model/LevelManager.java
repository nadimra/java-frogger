package model;

import java.io.FileNotFoundException;

public class LevelManager {
	LevelCreator level;
	private int currentLevel;
	private static final int MAX_LEVELS = 2;

	public LevelManager(MyStage background) throws FileNotFoundException {
		currentLevel = 1;
		level = new LevelCreator(background,currentLevel);
	}
	
	public void getNextLevel() throws FileNotFoundException {
		currentLevel += 1;
		if(currentLevel<=MAX_LEVELS) {
			level.clearLevel();
			level.loadLevelFile(currentLevel);
		}
	}
}
