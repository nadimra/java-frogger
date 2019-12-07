package p4_group_8_repo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HighscoreController {

	private Main mainApp;
	
    @FXML
    private TableView<Highscore> scoreTable;
    @FXML
    private TableColumn<Highscore, String> nameColumn;
    @FXML
	private TableColumn<Highscore, Integer> scoreColumn;
 
	
	

   @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
	   	nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
	   	scoreColumn.setCellValueFactory(cellData -> cellData.getValue().getScore().asObject());
	    scoreTable.getSelectionModel().setCellSelectionEnabled(false);
    }
    
    public void setValuesInTable(ObservableList<Highscore> listTable) {
        scoreTable.setItems(listTable);

    }

	@FXML
	private void onBackClick() {
	    mainApp.showMenu();
	}
	
	public void setMainApp(Main mainApp,ObservableList<Highscore> listTable) {
		this.mainApp = mainApp;
		scoreTable.setItems(listTable);
	}
	
}
