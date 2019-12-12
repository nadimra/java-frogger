package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

/**
* This class controls the help menu screen
* 
* @author Nadim Rahman
* 
*/
public class HelpMenuController {

	private Main mainApp;
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    }

    /**
     * Method to control what happens when the user clicks the back button
     */
	@FXML
	private void onBackClick() {
	    mainApp.showMenu();
	}
	
    /**
     * Method to set the main stage window with the correct GUI
     * @param mainApp is the GUI passed
     */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
