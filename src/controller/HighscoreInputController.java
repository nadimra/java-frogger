package controller;


import java.io.FileNotFoundException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.HighscoreManagerSingleton;


/**
 * Dialog to edit details of a person.
 * 
 * @author Nadim Rahman
 */
public class HighscoreInputController {

    private Stage dialogStage;
    private boolean okClicked = false;
    
    private int scoreSubmit;
    
    @FXML
    private TextField inputField;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private Label validationLabel;
    

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    
    public void setSubmitScore(int score) {
    	scoreSubmit = score;
    }
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     * @throws FileNotFoundException 
     */
    @FXML
    private void handleSubmit() throws FileNotFoundException {
        if (isInputValid()) { 

            HighscoreManagerSingleton.getInstance().addScore(inputField.getText(), scoreSubmit);
            okClicked = true;
            dialogStage.close();
        }
        
        else {
            validationLabel.setText("Please input a valid name");

        }
    }


    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        if (!(inputField.getText().length() >= 3 && inputField.getText().length() <=9 )) {
            return false;
        }
        //validationLabel.setVisible(true);
        return true;
    }
}
