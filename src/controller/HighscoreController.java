package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Highscore;
import model.Main;

/**
* This class controls the highscore screen
* 
* @author Nadim Rahman
* 
*/
public class HighscoreController {

	private Main mainApp;
	
    @FXML
    private TableView<Highscore> scoreTable;
    @FXML
    private TableColumn<Highscore, String> nameColumn;
    @FXML
	private TableColumn<Highscore, Integer> scoreColumn;

    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
   @FXML
    private void initialize() {
        // Initialize the scoreTable table with the two columns.
	   	nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
	   	scoreColumn.setCellValueFactory(cellData -> cellData.getValue().getScore().asObject());
	    scoreTable.getSelectionModel().setCellSelectionEnabled(false);
    }
    
   /**
    * Method sets the values in the highscore table
    * @param sends a list of the Highscore data
    */
    public void setValuesInTable(ObservableList<Highscore> listTable) {
        scoreTable.setItems(listTable);

    }

    /**
     * Method controls what happens when the back button is clicked
     */
	@FXML
	private void onBackClick() {
	    mainApp.showMenu();
	}
	
    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
	public void setMainApp(Main mainApp,ObservableList<Highscore> listTable) {
		this.mainApp = mainApp;
		scoreTable.setItems(listTable);
	}
	
}
