package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

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
	
	int points;
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        submitButton.setDisable(true);
    }

    public void setPoints(int points) {
    	this.points = points;
    	scoreText.setText("" + points);
    }
    
    public void setWinOrLose(boolean win) {
        submitButton.setDisable(false);
    	if(win) {
    		winOrLose.setText("YOU WON");
    	}
    	else {
    		winOrLose.setText("YOU LOST");
    	}
    }
    
    public void setFeedbackString(boolean earnedHighscore) {
    	this.earnedHighscore = earnedHighscore;
    	if(earnedHighscore) {
    		feedbackString.setText("You got a highscore!, Click the button submit your score!");
    	}
    	else {
    		feedbackString.setText("Try again to get in the highscores!");
    	}
    }
    
	@FXML
	private void onViewHighscoreClick() {
	    mainApp.showHighscoreScreen();
	}
    
	@FXML
	private void onSubmitHighscoreClick() {
		if(earnedHighscore) {
		    mainApp.showHighscoreInput(points);
		}
	}
	
	@FXML
	private void onQuitClick() {
	    mainApp.showMenu();
	}
	
	@FXML
	private void onResetClick() throws FileNotFoundException {
	    mainApp.showGame();

	}
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}