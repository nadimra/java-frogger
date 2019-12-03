package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainGameController {
    static final int maxWidth = 600;
    static final int maxHeight = 800;
    
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	Level level;
	Score score;
	
	private Main mainApp;
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    public void initialize(Stage primaryStage) {
	    background = new MyStage();
	    Scene scene  = new Scene(background,maxWidth,maxHeight);

		BackgroundImage froggerback = new BackgroundImage("file:src/resources/iKogsKW.png");	    
		background.add(froggerback);

		level = new Level(background);
		score = new Score(background);

		animal = new Animal("file:src/resources/froggerUp.png");
		background.add(animal);
		background.start();
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
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
		        	if (animal.getChangeScore()) {
		        		score.setNumber(animal.getPoints());
		        	}
		        	if (animal.getStop()) {
		        		System.out.print("STOP");
		        		background.stopMusic();
		        		stop();
		        		background.stop();
		        		Alert alert = new Alert(AlertType.INFORMATION);
		        		alert.setTitle("You Have Won The Game!");
		        		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
		        		alert.setContentText("Highest Possible Score: 800");
		        		alert.show();
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

	/**
	 * This method is called whenever the game is stopped, so it will need to stop updating certain objects
	 * 
	 */
    public void stop() {
        timer.stop();
    }
}
