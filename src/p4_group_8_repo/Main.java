package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The object of this class puts everything together and displays the interface to the user.
 * 
 * @author Nadim Rahman
 * @version 1.0
 * @since 20-11-2019
 *
 */


public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	Level level;
	Score score;
	
	public static void main(String[] args) {
		launch(args);
	}

	
	/**
	 * This method loads the initial GUI.
	 * @param primaryStage the wrapper/ application window
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);

		BackgroundImage froggerback = new BackgroundImage("file:src/resources/iKogsKW.png");	    
		background.add(froggerback);

		level = new Level(background);
		score = new Score(background);

		animal = new Animal("file:src/resources/froggerUp.png");
		background.add(animal);
		//background.add(new Digit(0, 30, 360, 25));	
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
		        	if (animal.changeScore()) {
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
