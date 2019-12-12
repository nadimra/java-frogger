package controller;

import java.io.FileNotFoundException;

import commands.Command;
import commands.CommandDown;
import commands.CommandLeft;
import commands.CommandRight;
import commands.CommandUp;
import commands.Options;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.HighscoreManagerSingleton;
import model.LevelCreator;
import model.LevelManager;
import model.LivesManager;
import model.Main;
import model.MyStage;
import model.Score;
import sprites.Animal;
import sprites.BackgroundImage;
import sprites.DisplayTimer;


/**
 * Class controls the gameplay
 * 
 * @author Nadim Rahman
 * 
 */
public class MainGameController extends Application{
    static final int maxWidth = 600;
    static final int maxHeight = 800;
    static final int levelTime = 60;
    
    private Scene scene;
    private AnimationTimer timer;
    private MyStage background;
    private Animal animal;
    private LevelManager levelManager;
    private Score score;
    private LivesManager lives;
    private DisplayTimer displayTimer;

    private Command controlUp;
    private Command controlDown;
    private Command controlLeft;
    private Command controlRight;
    private Options options;
	
	private Main mainApp;
	private int seconds;

    /**
     * Initializes the class
     * @throws FileNotFoundException 
     */
    public void initialize() throws FileNotFoundException {
    	
    	// Set the stage and add the different key sprites
	    background = new MyStage();
	    scene  = new Scene(background,maxWidth,maxHeight);
		BackgroundImage froggerback = new BackgroundImage("file:src/resources/background.png");	    
		background.add(froggerback);
		
		//Set up the lives, score, timer, and lives
		levelManager = new LevelManager(background);
		score = new Score(background);
		lives = new LivesManager(background,3);
		displayTimer = new DisplayTimer(background, levelTime);
		
		//Set up the player and controls
		animal = new Animal("file:src/resources/froggerUp.png",score,lives);
		setControls();
		
		//Add player to screen and start the scene
		background.add(animal);
		background.start();
		
		//Call these methods when key is released/pressed
		keyPress();
		keyRelease();
		
		//Initialise the game
		startGame();  
	}
    
    /**
     * Sets the controls for the player
     */
    private void setControls() {
		controlUp = new CommandUp(animal,KeyCode.W);
		controlDown = new CommandDown(animal, KeyCode.S);
		controlLeft = new CommandLeft(animal, KeyCode.A);
		controlRight = new CommandRight(animal, KeyCode.D);
		options = new Options(controlUp,controlDown, controlLeft,controlRight);
    }
    
	/**
	 * This method creates a timer that is called in each frame while it is active. 
	 * It is the main game loop.
	 * 
	*/
	private void onUpdate() {
    	timer = new AnimationTimer() {
    	//  An extending class has to override the method handle(long)

    		@Override
	        public void handle(long now) {
    				updateTimer(now);
    			
    				// Continiously check and update score
		        	if (score.updateScore()) {
		        		score.setNumber(score.getPoints());
		        	}
		        	
    				// Check if player has completed the level
		        	if (animal.getStop()) {
		        		try {
		        			if(levelManager.getCurrentLevel() == LevelManager.MAX_LEVELS) {
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
		        	
		        	// Check if the level has new additions that need updating on screen
		        	if(levelManager.needUpdate()) {
		        		levelManager.updateAdditions();
		        	}
		        	
		        	// Check if the player has collided with a dropped heart
		        	if(animal.getCollidedDroppedHeart()) {
		        		droppedHeartCollection();
		        	}

	        }
    	};
	}
	
	/**
	 * This method controls the timer and updates the seconds
	 * @param now is the milliseconds the program has been running for
	 * 
	*/
	private void updateTimer(long now) {
    	if (displayTimer.getLastTime() != 0) {
            if (now > displayTimer.getLastTime() + 1_000_000_000) {
            	// Second has passed
                displayTimer.incrementSeconds();
                displayTimer.setLastTime(now);
            }
       } else {
            displayTimer.setLastTime(now);

       }
	}
	
	/**
	 * This method controls the timer and updates the seconds
	 * 
	*/
	private void droppedHeartCollection() {
		lives.setUpdateLives(true);
		if(lives.getUpdateLives()) {
			animal.setCollidedDroppedHeart(false);
			background.remove(animal.getHeartCollision());
			lives.addLives();
			lives.setUpdateLives(false);
		}
	}
	
	/**
	 * This method is called whenever the game is stopped, so it will need to stop updating certain objects
	 * 
	 */
    public void stop() {
        timer.stop();
    }

	/**
	 * @return the current scene
	 * 
	 */
    public Scene getScene() {
    	return scene;
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

    /**
     * Method called when game is paused
     */
	public void pauseGame() {
		background.stop();
		timer.stop();
		mainApp.showPauseMenu(score.getPoints());
	}
	
    /**
     * Method called when game is continued from the pause menu
     */
	public void continueGame() {
		background.start();
		timer.start();
	}
    
    /**
     * Handles when the level is won / lost 
     */
	public void handleGameOver(boolean win) throws FileNotFoundException {
		background.stopMusic();
		stop();
		background.stop();
		// Checks if the user has earned a highscore
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
	
	/**
	 * This method handles what happens when a new level is loaded
	 * @throws FileNotFoundException 
	 * 
	 */
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


