package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.GameOverController;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.LivesManager;
import model.Main;
import model.MyStage;

class LivesManager_Test {

	JFXPanel fxPanel;
	MyStage background;
	LivesManager lives;
	public static final int initialLives = 3;

	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
		background = new MyStage();
		lives = new LivesManager(background,initialLives);

	}
	
	@Test
	void checkCorrectNumLives() {
		assertEquals(lives.getNumLives(),3);
	}
	
	@Test
	void checkLoseLives() {
		lives.loseLife();
		assertEquals(lives.getNumLives(),2);
	}
	
	@Test
	void checkAddLivesIfLessThanMax() {
		lives.loseLife();
		lives.addLives();
		assertEquals(lives.getNumLives(),3);
	}

	@Test
	void checkDontAddLifeIfMax() {
		lives.addLives();
		assertEquals(lives.getNumLives(),3);
	}

	@Test
	void checkGameOverCorrectWhenLivesLost() {
		lives.loseLife();
		lives.loseLife();
		lives.loseLife();

		assertTrue(lives.getGameOver());
	}
	
	@Test
	void checkGameOverCorrectWhenLivesRemaim() {
		lives.loseLife();
		lives.loseLife();

		assertFalse(lives.getGameOver());
	}

}
