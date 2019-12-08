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
import model.DisplayTimer;
import model.HighscoreManagerSingleton;
import model.LevelCreator;
import model.LevelManager;
import model.LivesManager;
import model.Main;
import model.MyStage;
import model.Score;



public class MainGameController extends Application{
    static final int maxWidth = 600;
    static final int maxHeight = 800;
    Scene scene;
    
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	//Level level;
	LevelManager levelManager;
	Score score;
	LivesManager lives;
	DisplayTimer displayTimer;

	
	
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
		displayTimer = new DisplayTimer(background, 20);

		animal = new Animal("file:src/resources/froggerUp.png",score,lives);
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
		        			animal.setStop();
		        			levelManager.getNextLevel();
		        			background.remove(animal);
		        			background.add(animal);

							//handleGameOver(true);
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
	
	
	/**
	 * This method manages the start of the game.
	 * 
	 */
	public void startGame() {
		score.setNumber(0);
		background.playMusic();
    	onUpdate();
        timer.start();
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
						switch(keyPress) {
							case W: 
								score.setChangeScore(false);
								animal.handleVerticalMovement(-animal.getMoveX(),  animal.getImage("W1"));	 
								break;
							case A:       	
								animal.handleHorizontalMovement(-animal.getMoveY(), animal.getImage("A1"));
								break;
							case S:
								animal.handleVerticalMovement(animal.getMoveY(),  animal.getImage("S1"));	 
								break;
							case D:	            	
								animal.handleHorizontalMovement(animal.getMoveX(),  animal.getImage("D1"));
								break;
						}
					}
					else {
						// Set sprite to the 'jumping' directional sprite
						switch(keyPress) {
							case W: 
								animal.handleVerticalMovement(-animal.getMoveY(), animal.getImage("W2"));	 
								break;
							case A: 
								animal.handleHorizontalMovement(-animal.getMoveX(),  animal.getImage("A2"));      
					            break;
							case S:
								animal.handleVerticalMovement(animal.getMoveY(), animal.getImage("S2"));	 
					            break;
							case D:
								animal.handleHorizontalMovement(animal.getMoveX(),  animal.getImage("D2"));   
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
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				KeyCode keyPress = event.getCode();
				if (animal.getNoMove()) {} // Don't do anything
				else {
					switch(keyPress) {
						case W:
							double animalW = animal.getW();
							if (animal.getY() < animalW) {
								score.updatePoints(10);
								animal.setW(animal.getY());
							}
							animal.handleVerticalMovement(-animal.getMoveY(), animal.getImage("W1"));   
					        break;         
						case A:	            	
							animal.handleHorizontalMovement(-animal.getMoveX(), animal.getImage("A1"));   
					         break;
						case S:
							animal.handleVerticalMovement(animal.getMoveY(), animal.getImage("S1"));  
					         break;
						case D:            	
							animal.handleHorizontalMovement(animal.getMoveX(), animal.getImage("D1"));
					         break;
					}
				}
			}
		});
	}
	

}


