package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverController {

	private Main mainApp;
	
	@FXML
	private Label feedbackString;
	
	@FXML
	private Label scoreText;
	
	@FXML
	private Label winOrLose;

    public void setPoints(int points) {
    	scoreText.setText("" + points);
    }
    
    public void setWinOrLose(boolean win) {
    	if(win) {
    		winOrLose.setText("YOU WON");
    	}
    	else {
    		winOrLose.setText("YOU LOST");
    	}
    }
    
    public void setFeedbackString(boolean earnedHighscore) {
    	if(earnedHighscore) {
    		feedbackString.setText("You got a highscore!, Click the button submit your score!");
    	}
    	else {
    		feedbackString.setText("Try again to get in the highscores!");
    	}
    }
    
	@FXML
	private void onQuitClick() {
	    mainApp.showMenu();
	}
	
	@FXML
	private void onResetClick() {
	    mainApp.showGame();

	}
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
