package controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Highscore;
import model.Main;

/**
 * Class controls the intro dialog displayed at the start of every level
 * 
 * @author Nadim Rahman
 * 
 */
public class LevelIntroController {
	
    private Stage dialogStage;
    private boolean proceedClicked;
	
	@FXML
	private Label levelLabel;

	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Sets the text of the window to the appropriate data
     * @levelNum is the level the user is playing
     * @highscore is the highscore of that level
     * 
     */
    private void setIntroText(int levelNum,int highscore) {
        levelLabel.setText("" + levelNum);
    }
	
    /**
     * Controls what happens when proceed is clicked
     */
	@FXML
	private void onProceedClick() throws FileNotFoundException {
		proceedClicked= true;
        dialogStage.close();
	}
	

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     * @param the level the user is playing
     * @param the highscore for that level
     */
    public void setDialogStage(Stage dialogStage,int levelNum, int highScore) {
        this.dialogStage = dialogStage;
		setIntroText(levelNum, highScore);
    }

    /**
     * Checks if the proceed button is clicked
     */
	public boolean isProceedClicked() {
		// TODO Auto-generated method stub
		return false;
	}

}
