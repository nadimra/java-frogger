package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

	private Main mainApp;
	
	@FXML
	private void onPlayClick() {
	    mainApp.showGame();
	}
	
	@FXML
	private void onHighScoreClick() {
	    
	}
	
	@FXML
	private void onHelpClick() {
	    
	}
	
	@FXML
	private void onQuitClick() {
	    
	}
	
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
