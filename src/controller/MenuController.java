package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Main;

/**
* This class controls the menu screen
* 
* @author Nadim Rahman
* 
*/
public class MenuController {

	private Main mainApp;
	
    /**
     * Method to control what happens when the user clicks the play button
     */
	@FXML
	private void onPlayClick() throws FileNotFoundException {
	    mainApp.showGame();
	}
	
    /**
     * Method to control what happens when the user clicks the highscore button
     */
	@FXML
	private void onHighScoreClick() {
		mainApp.showHighscoreScreen();
	}
	
    /**
     * Method to control what happens when the user clicks the help button
     */
	@FXML
	private void onHelpClick() {
	    mainApp.showHelpMenu();

	}
	
    /**
     * Method to control what happens when the user clicks the quit button
     */
	@FXML
	private void onQuitClick() {
		 System.exit(0);
	    
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
