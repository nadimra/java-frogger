package controller;

import java.io.FileNotFoundException;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Animal;
import model.BackgroundImage;
import model.CommandUp;
import model.DisplayTimer;
import model.HighscoreManagerSingleton;
import model.LevelCreator;
import model.LevelManager;
import model.LivesManager;
import model.Main;
import model.MyStage;
import model.Options;
import model.Score;
import model.Command;
import model.CommandDown;
import model.CommandLeft;
import model.CommandRight;



public class MainGameController extends Application{
    static final int maxWidth = 600;
    static final int maxHeight = 800;
    static final int levelTime = 60;
    
    Scene scene;
    
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	//Level level;
	LevelManager levelManager;
	Score score;
	LivesManager lives;
	DisplayTimer displayTimer;

	Command controlUp;
	Command controlDown;
	Command controlLeft;
	Command controlRight;
	Options options;
	
	
	private Main mainApp;
	private int seconds;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     * @throws FileNotFoundException 
     */
    public void initialize() throws FileNotFoundException {
	    background = new MyStage();
	    scene  = new Scene(background,maxWidth,maxHeight);

		BackgroundImage froggerback = new BackgroundImage("file:src/resources/background.png");	    
		background.add(froggerback);

		//level = new Level(background);
		levelManager = new LevelManager(background);
		score = new Score(background);
		lives = new LivesManager(background,3);
		displayTimer = new DisplayTimer(background, levelTime);

		animal = new Animal("file:src/resources/froggerUp.png",score,lives);
		
		controlUp = new CommandUp(animal,KeyCode.W);
		controlDown = new CommandDown(animal, KeyCode.S);
		controlLeft = new CommandLeft(animal, KeyCode.A);
		controlRight = new CommandRight(animal, KeyCode.D);
		options = new Options(controlUp,controlDown, controlLeft,controlRight);

		background.add(animal);
		background.start();

		keyPress();
		keyRelease();

		startGame();  
		
	}
    
	/**
	 * This method creates a timer that is called in each frame while it is active. 
	 * 
	*/
	public void onUpdate() {
    	timer = new AnimationTimer() {
    	//  An extending class has to override the method handle(long)

    		@Override
	        public void handle(long now) {
    			
    				// Continiously check and update score
		        	if (score.updateScore()) {
		        		score.setNumber(score.getPoints());
		        	}
		        	
    				// Check if player has completed the level
		        	if (animal.getStop()) {
		        		try {
		        			if(levelManager.getCurrentLevel() == levelManager.MAX_LEVELS) {
		        				handleGameOver(true);
		        			}
		        			else {
		        				handleNextLevel();
		        			}

						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	
		        	// Continously check lives and update 
		        	lives.updateLives();
		        	
		        	// Check if lives all gone
		        	if(lives.getGameOver()) {
		        		try {
							handleGameOver(false);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	
		        	// Check if timer has run out
		        	if(displayTimer.getTimesUp()) {
		        		try {
							handleGameOver(false);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	
		        	// Update timer
		        	if (displayTimer.getLastTime() != 0) {
		                 if (now > displayTimer.getLastTime() + 1_000_000_000) {
		                     displayTimer.incrementSeconds();
		                     displayTimer.setLastTime(now);
		                 }
		            } else {
	                     displayTimer.setLastTime(now);

		            }
		        	

	        }
    	};
	}
	
	
	/**
	 * This method is called whenever the game is stopped, so it will need to stop updating certain objects
	 * 
	 */
    public void stop() {
        timer.stop();
    }

    public Scene getScene() {
    	return scene;
    }

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void pauseGame() {
		background.stop();
		timer.stop();
		mainApp.showPauseMenu(score.getPoints());
	}
	
	public void continueGame() {
		background.start();
		timer.start();
	}
    
	public void handleGameOver(boolean win) throws FileNotFoundException {
		background.stopMusic();
		stop();
		background.stop();
		boolean earnedHighscore = HighscoreManagerSingleton.getInstance().checkTopTen(score.getPoints());
		mainApp.showGameOver(score.getPoints(),win,earnedHighscore);
	}
	
	
	/**
	 * This method manages the start of the game.
	 * @throws FileNotFoundException 
	 * 
	 */
	public void startGame() throws FileNotFoundException {
		score.setNumber(0);
		background.playMusic();
		levelManager.getNextLevel();
		displayTimer.resetTimer();
		animal.setNumEnds(levelManager.getNumEnds());
		background.remove(animal);
		background.add(animal);
    	onUpdate();
        timer.start();
		mainApp.showLevelIntro(levelManager.getCurrentLevel(), 100);
    }
	
	public void handleNextLevel() throws FileNotFoundException {
		animal.setStop();
		levelManager.getNextLevel();
		displayTimer.resetTimer();
		animal.setNumEnds(levelManager.getNumEnds());
		background.remove(animal);
		background.add(animal);
        mainApp.showLevelIntro(levelManager.getCurrentLevel(), 100);
	}
	
	/**
	 * This method is called when a key is pressed and manages what happens for specific keys.
	 * 
	 */
	public void keyPress() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				KeyCode keyPress = event.getCode();
				if(keyPress == KeyCode.ESCAPE) {
					pauseGame();
				}
				if (animal.getNoMove()) {} // Don't do anything
				else {
					// Set sprite back to the normal directional sprite
					if (animal.getSecondAnimation()) {
						if(keyPress == options.getUpKey()) {
								score.setChangeScore(false);
								options.pressUp("W1");
						}
						if(keyPress == options.getLeftKey()) {
								options.pressLeft("A1");
						}
						if(keyPress == options.getDownKey()) {
								options.pressDown("S1");
						}		
						if(keyPress == options.getRightKey()) {
								options.pressRight("D1");
						}
					}
					else {
						// Set sprite to the 'jumping' directional sprite
						if(keyPress == options.getUpKey()) {
								options.pressUp("W2");
						}
						if(keyPress == options.getLeftKey()) {
								options.pressLeft("A2");
						}
						if(keyPress == options.getDownKey()) {
								options.pressDown("S2");
						}
						if(keyPress == options.getRightKey()) {
								options.pressRight("D2");
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
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				KeyCode keyPress = event.getCode();
				if (animal.getNoMove()) {} // Don't do anything
				else {
					if(keyPress == options.getUpKey()) {
						double animalW = animal.getW();
						if (animal.getY() < animalW) {
							score.updatePoints(10);
							animal.setW(animal.getY());
						}
						options.pressUp("W1");	
					}
					if(keyPress == options.getLeftKey()) {
						options.pressLeft("A1");
					}
					if(keyPress == options.getDownKey()) {
						options.pressDown("S1");
					}
					if(keyPress == options.getRightKey()) {
						options.pressRight("D1");
					}
				}
			}
			
		});
	}
	

}


