package p4_group_8_repo;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The object of this class puts everything together and displays the interface to the user.
 * 
 * @author Nadim Rahman
 * @version 1.0
 * @since 20-11-2019
 *
 */


public class Main extends Application {
	
    static final int maxWidth = 600;
    static final int maxHeight = 800;
    
	private MyStage background;
	private Stage primaryStage;
	
    private AnchorPane menuScreen;
    private AnchorPane gameScreen;
    private AnchorPane pauseScreen;
    private AnchorPane gameOverScreen;


    private MainGameController game;

	
	
	/**
	 * This method loads the initial GUI.
	 * @param primaryStage the wrapper/ application window
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
	    background = new MyStage();

	    showMenu();
	}

	
    /**
     * Initializes the root layout.
     */
    public void showMenu() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Menu.fxml"));
            menuScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(menuScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            MenuController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Initializes the root layout.
     */
    public void showGame() {
            // Load root layout from fxml file.
        	game = new MainGameController();
        	game.setMainApp(this);
        	game.initialize();
        	primaryStage.setScene(game.getScene());
        	primaryStage.show();  	
    }
    
    /**
     * Initializes the root layout.
     */
    public void showContinuedGame() {
            // Load root layout from fxml file.
        	game.continueGame();
        	primaryStage.setScene(game.getScene());
        	primaryStage.show();  	
    }
    
    /**
     * Initializes the root layout.
     */
    public void showPauseMenu(int points) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("PauseMenu.fxml"));
            pauseScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(pauseScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            PauseMenuController controller = loader.getController();
            controller.setCurrentPoints(points);
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Initializes the root layout.
     */
    public void showHelpMenu() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("HelpMenu.fxml"));
            menuScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(menuScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            HelpMenuController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Initializes the root layout.
     */
    public void showGameOver(int points) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("GameOver.fxml"));
            gameOverScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(gameOverScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            GameOverController controller = loader.getController();
            controller.setPoints(points);
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
