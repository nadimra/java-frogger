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
		mainApp.showHighscoreScreen();
	}
	
	@FXML
	private void onHelpClick() {
	    mainApp.showHelpMenu();

	}
	
	@FXML
	private void onQuitClick() {
		 System.exit(0);
	    
	}
	
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
}
