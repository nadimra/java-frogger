package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

public class PauseMenuController {

	private Main mainApp;
	
    @FXML
    private Label scoreText;
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    }
	
    
    public void setCurrentPoints(int points) {
    	scoreText.setText("" + points);
    }
    
	@FXML
	private void onContinueClick() {
	    mainApp.showContinuedGame();
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
