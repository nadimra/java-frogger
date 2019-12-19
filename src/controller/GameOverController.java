package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

/**
* This class controls the game over screen
* 
* @author Nadim Rahman
* 
*/
public class GameOverController {

	
	private Main mainApp;
	
	@FXML
	private Label feedbackString;
	
	@FXML
	private Label scoreText;
	
	@FXML
	private Label winOrLose;
	
	@FXML
	private Button submitButton;
	
	boolean earnedHighscore;
	
	private Scene scene;
	
	private int points;
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Make sure the submit button is disabled unless they achieved a highscore
        submitButton.setDisable(true);
    }

    /**
     * Updates the game over screen to display the points that the user earned
     * @param points is the score displayed on the screen
     */
    public void setPoints(int points) {
    	this.points = points;
    	scoreText.setText("" + points);
    }
    
    public int getPoints() {
    	return points;
    }
    
    /**
     * Updates the game over screen to display that the user has won or lost
     * @param win is a boolean that determines if the user has won the game or not
     */
    public void setWinOrLose(boolean win) {
        submitButton.setDisable(false);
    	if(win) {
    		winOrLose.setText("YOU WON");
    	}
    	else {
    		winOrLose.setText("YOU LOST");
    	}
    }
    
    /**
     * Updates the game over screen to display whether the user can submit a highscore or not
     * @param earnedHighscore is a boolean that determines if the user has reached the highscore
     */
    public void setFeedbackString(boolean earnedHighscore) {
    	this.earnedHighscore = earnedHighscore;
    	if(earnedHighscore) {
    		feedbackString.setText("You got a highscore!, Click the button submit your score!");
    	}
    	else {
    		feedbackString.setText("Try again to get in the highscores!");
    	}
    }
    
    /**
     * Method to control what happens when the user clicks the view highscore button
     */
	@FXML
	private void onViewHighscoreClick() {
	    mainApp.showHighscoreScreen();
	}
    
    /**
     * Method to control what happens when the user clicks the submit highscore button
     */
	@FXML
	private void onSubmitHighscoreClick() {
		// Checks if the user has reached the leaderboards first
		if(earnedHighscore) {
		    mainApp.showHighscoreInput(points);
		}
	}
	
    /**
     * Method to control what happens when the user clicks the quit button
     */
	@FXML
	private void onQuitClick() {
	    mainApp.showMenu();
	}
	
    /**
     * Method to control what happens when the user clicks the reset button
     */
	@FXML
	private void onResetClick() throws FileNotFoundException {
	    mainApp.showGame();
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	public String getScoreText() {
		return scoreText.getText();
	}

	public String getFeedbackLabel() {
		return feedbackString.getText();
	}
}
