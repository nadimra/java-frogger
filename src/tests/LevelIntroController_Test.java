package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.GameOverController;
import controller.LevelIntroController;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Main;

class LevelIntroController_Test {

	JFXPanel fxPanel;
	AnchorPane levelIntro;
	LevelIntroController controller;
	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/LevelIntro.fxml"));
        levelIntro = (AnchorPane) loader.load();
		
        controller = loader.getController();
	}
	
	@Test
	void checkLevelLabel() {
		controller.setIntroText(5);
		String levelLabel = controller.getLevelLabelText();
		assertEquals(levelLabel,""+5);
	}

}
