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

    public void setPoints(int points) {
    	scoreText.setText("" + points);
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