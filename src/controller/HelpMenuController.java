package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Main;

public class HelpMenuController {

	private Main mainApp;
	

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    }

	@FXML
	private void onBackClick() {
	    mainApp.showMenu();
	}
	

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
