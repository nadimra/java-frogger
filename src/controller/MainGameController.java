package p4_group_8_repo;

import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;



public class MainGameController extends Application{
    static final int maxWidth = 600;
    static final int maxHeight = 800;
    Scene scene;
    
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	//Level level;
	LevelCreator level;
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
		level = new LevelCreator(background,1);
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
		        	if (score.updateScore()) {
		        		score.setNumber(score.getPoints());
		        	}
		        	if (animal.getStop()) {
		        		try {
							handleGameOver(true);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	lives.updateLives();
		        	if(lives.getGameOver()) {
		        		try {
							handleGameOver(false);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	if(displayTimer.getTimesUp()) {
		        		try {
							handleGameOver(false);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
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
								animal.handleVerticalMovement(-animal.getMoveX(), animal.imgW1);	 
								break;
							case A:       	
								animal.handleHorizontalMovement(-animal.getMoveY(), animal.imgA1);
								break;
							case S:
								animal.handleVerticalMovement(animal.getMoveY(), animal.imgS1);	 
								break;
							case D:	            	
								animal.handleHorizontalMovement(animal.getMoveX(), animal.imgD1);
								break;
						}
					}
					else {
						// Set sprite to the 'jumping' directional sprite
						switch(keyPress) {
							case W: 
								animal.handleVerticalMovement(-animal.getMoveY(), animal.imgW2);	 
								break;
							case A: 
								animal.handleHorizontalMovement(-animal.getMoveX(), animal.imgA2);      
					            break;
							case S:
								animal.handleVerticalMovement(animal.getMoveY(),animal.imgS2);	 
					            break;
							case D:
								animal.handleHorizontalMovement(animal.getMoveX(), animal.imgD2);   
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
							if (animal.getY() < animal.w) {
								score.updatePoints(10);
								animal.setW(animal.getY());
							}
							animal.handleVerticalMovement(-animal.movement, animal.imgW1);   
					        break;         
						case A:	            	
							animal.handleHorizontalMovement(-animal.movementX, animal.imgA1);   
					         break;
						case S:
							animal.handleVerticalMovement(animal.movement, animal.imgS1);  
					         break;
						case D:            	
							animal.handleHorizontalMovement(animal.movementX, animal.imgD1);
					         break;
					}
				}
			}
		});
	}
	

}


