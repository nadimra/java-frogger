package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PauseMenuController {

	private Main mainApp;
	
    @FXML
    private Label scoreText;
	
	@FXML
	private void onContinueClick() {
	    mainApp.showGame();
	}
	
	@FXML
	private void onQuitClick() {
	    mainApp.showMenu();
	}
	
	@FXML
	private void onResetClick() {
	    
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
