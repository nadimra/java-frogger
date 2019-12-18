package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.GameOverController;
import controller.HighscoreInputController;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.HighscoreManagerSingleton;
import model.Main;

class GameOverController_Test {

	JFXPanel fxPanel;
	AnchorPane gameOverScreen;
	GameOverController controller;
	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/GameOver.fxml"));
        gameOverScreen = (AnchorPane) loader.load();
		
        controller = loader.getController();
	}
	
	@Test
	void checkScoreLabelCorrect() {
		controller.setPoints(20);
		String scoreLabel = controller.getScoreText();
		assertEquals(scoreLabel,""+20);
	}

	@Test
	void checkFailureFeedback() throws FileNotFoundException {
		// Not possible to get -1 score so won't be a highscore
		controller.setPoints(-1);
		boolean earnedHighscore = HighscoreManagerSingleton.getInstance().checkTopTen(controller.getPoints());
		controller.setFeedbackString(earnedHighscore);
		
		String feedbackString = controller.getFeedbackLabel();
		assertEquals(feedbackString,"Try again to get in the highscores!");
	}
	
	@Test
	void checkHighscoreFeedback() throws FileNotFoundException {
		// Not possible to get -1 score so won't be a highscore
		controller.setPoints(HighscoreManagerSingleton.getInstance().getTopScore());
		boolean earnedHighscore = HighscoreManagerSingleton.getInstance().checkTopTen(controller.getPoints());
		controller.setFeedbackString(earnedHighscore);
		
		String feedbackString = controller.getFeedbackLabel();
		assertEquals(feedbackString,"You got a highscore!, Click the button submit your score!");
	}
}
