package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import controller.GameOverController;
import controller.HelpMenuController;
import controller.HighscoreController;
import controller.HighscoreInputController;
import controller.LevelIntroController;
import controller.MainGameController;
import controller.MenuController;
import controller.PauseMenuController;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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
	
   public  static final int maxWidth = 600;
    public static final int maxHeight = 800;
    
	private MyStage background;
	private Stage primaryStage;
	
    private AnchorPane menuScreen;
    private AnchorPane helpScreen;
    private AnchorPane gameScreen;
    private AnchorPane pauseScreen;
    private AnchorPane gameOverScreen;
    private AnchorPane highscoreScreen;
	private AnchorPane levelIntroScreen;



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
            loader.setLocation(Main.class.getResource("/view/Menu.fxml"));
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
     * @throws FileNotFoundException 
     */
    public void showGame() throws FileNotFoundException {
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
            loader.setLocation(Main.class.getResource("/view/PauseMenu.fxml"));
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
            loader.setLocation(Main.class.getResource("/view/HelpMenu.fxml"));
            helpScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(helpScreen);
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
    public void showGameOver(int points, boolean win, boolean earnedHighscore) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/GameOver.fxml"));
            gameOverScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(gameOverScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            GameOverController controller = loader.getController();
            controller.setPoints(points);
            controller.setWinOrLose(win);
            controller.setFeedbackString(earnedHighscore);
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Initializes the root layout.
     */
    public void showHighscoreScreen() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Highscore.fxml"));
            highscoreScreen = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(highscoreScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            HighscoreController controller = loader.getController();
            //controller.setValuesInTable(new HighscoreManager().getScores());

            controller.setMainApp(this,HighscoreManagerSingleton.getInstance().getScores());
            
        } catch (IOException e) {
        }
    }
    
    public boolean showHighscoreInput(int points) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/HighscoreInput.fxml"));
            AnchorPane highscoreInput = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New Highscore");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(highscoreInput);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            HighscoreInputController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setSubmitScore(points);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Initializes the root layout.
     */
    public void showLevelIntro(int levelNum, int highscore) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/LevelIntro.fxml"));
            AnchorPane levelIntro = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Level Overview");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(levelIntro);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            LevelIntroController controller = loader.getController();
            controller.setDialogStage(dialogStage,levelNum,highscore);

            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(e -> dialogStage.hide());

            dialogStage.show();
            delay.play();
            
            // Show the dialog and wait until the user closes it

            
        } catch (IOException e) {
        }
    }
    
    
}
