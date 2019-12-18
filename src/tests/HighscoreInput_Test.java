package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.HighscoreInputController;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Main;

class HighscoreInput_Test {

	JFXPanel fxPanel;
	AnchorPane highscoreInput;
	HighscoreInputController controller;
	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view/HighscoreInput.fxml"));
        highscoreInput = (AnchorPane) loader.load();
		
        controller = loader.getController();
	}
	
	@Test
	void checkLowerBoundary() throws IOException {

        controller.setInputVield("123");
		boolean shouldBeTrue = controller.isInputValid();
		assertTrue(shouldBeTrue);
	}

	@Test
	void checkHigherBoundary() throws IOException {

        controller.setInputVield("123456789");
		boolean shouldBeTrue = controller.isInputValid();
		assertTrue(shouldBeTrue);
	}
	
	@Test
	void checkLowerInvalidBoundary() throws IOException {
        controller.setInputVield("12");
		boolean shouldBeFalse = controller.isInputValid();
		assertFalse(shouldBeFalse);
	}
	
	@Test
	void checkHigherInvalidBoundary() throws IOException {
        controller.setInputVield("1234567891");
		boolean shouldBeFalse = controller.isInputValid();
		assertFalse(shouldBeFalse);
	}
	
	@Test
	void checkValidationLabel() throws FileNotFoundException {
        controller.setInputVield("1234567891");
        controller.handleSubmit();
        String validationCheck = "Please input a valid name";
        String actualValidationString = controller.getValidationLabel();
        assertEquals(validationCheck,actualValidationString);
	}
}
