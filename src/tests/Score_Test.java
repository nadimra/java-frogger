package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import model.MyStage;
import model.Score;

class Score_Test {
	
	@Test
	void checkDefaultZero() {
		Score score = new Score(null);
		int defaultScore = 0;
		int actualScore = score.getPoints();
		assertEquals(defaultScore,actualScore);
	}

	@Test
	void checkPointsAddedCorrect() {
		Score score = new Score(null);
		score.updatePoints(10);
		int actualScore = score.getPoints();
		assertEquals(actualScore,10);
	}

}
