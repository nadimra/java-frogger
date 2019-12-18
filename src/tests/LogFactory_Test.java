package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.LevelIntroController;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.LivesManager;
import model.Main;
import model.MyStage;
import sprites.Log;
import sprites.LogFactory;
import model.LevelCreator.ActorTypes;

class LogFactory_Test {
	JFXPanel fxPanel;
	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
	}
	
	@Test
	void checkReturnLogBig() {
		Log log = LogFactory.getLog(ActorTypes.LogBig, 0, 0, 0);
		boolean pass;
		if(log.getClass().getSimpleName().equals(ActorTypes.LogBig.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}
	
	@Test
	void checkReturnLogMedium() {
		Log log = LogFactory.getLog(ActorTypes.LogMedium, 0, 0, 0);
		boolean pass;
		if(log.getClass().getSimpleName().equals(ActorTypes.LogMedium.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}
	
	@Test
	void checkReturnLogSmall() {
		Log log = LogFactory.getLog(ActorTypes.LogSmall, 0, 0, 0);
		boolean pass;
		if(log.getClass().getSimpleName().equals(ActorTypes.LogSmall.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}

}
