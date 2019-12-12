package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

/**
* This class controls the pause menu
* 
* @author Nadim Rahman
* 
*/
public class PauseMenuController {

	private Main mainApp;
	
    @FXML
    private Label scoreText;
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }
	
    /**
     * Sets the points on the screen to the current points the user has got
     * @param points user has
     */
    public void setCurrentPoints(int points) {
    	scoreText.setText("" + points);
    }
    
    /**
     * Method called when user clicks continue button
     */
	@FXML
	private void onContinueClick() {
	    mainApp.showContinuedGame();
	}
	
    /**
     * Method called when user clicks quit button
     */
	@FXML
	private void onQuitClick() {
	    mainApp.showMenu();

	}
	
    /**
     * Method called when user clicks reset button
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
	
}
