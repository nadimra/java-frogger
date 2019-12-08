package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Highscore;
import model.Main;

public class LevelIntroController {
	
    private Stage dialogStage;
    private boolean proceedClicked;
	
	@FXML
	private Label levelLabel;
	
	@FXML
	private Label highscoreLabel;
	
    @FXML
    private void initialize() {

    }

	
    private void setIntroText(int levelNum,int highscore) {
        levelLabel.setText("" + levelNum);
        highscoreLabel.setText("" + levelNum);
    }
	
	@FXML
	private void onProceedClick() throws FileNotFoundException {
		proceedClicked= true;
        dialogStage.close();
	}
	

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage,int levelNum, int highScore) {
        this.dialogStage = dialogStage;
		setIntroText(levelNum, highScore);
    }

	public boolean isProceedClicked() {
		// TODO Auto-generated method stub
		return false;
	}

}
