package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelpMenuController {

	private Main mainApp;
	

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
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
