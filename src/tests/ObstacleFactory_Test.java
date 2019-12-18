package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.LevelCreator.ActorTypes;
import sprites.Log;
import sprites.LogFactory;
import sprites.Obstacle;
import sprites.ObstacleFactory;
import sprites.Truck;

class ObstacleFactory_Test {

	JFXPanel fxPanel;
	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
	}
	
	@Test
	void checkReturnTruckBig() {
		Obstacle obstacle = ObstacleFactory.getObstacle(ActorTypes.TruckBig, 0, 0, 0, null);
		boolean pass;
		if(obstacle.getClass().getSimpleName().equals(ActorTypes.TruckBig.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}
	
	@Test
	void checkReturnTruckSmall() {
		Obstacle obstacle = ObstacleFactory.getObstacle(ActorTypes.TruckSmall, 0, 0, 0, null);
		boolean pass;
		if(obstacle.getClass().getSimpleName().equals(ActorTypes.TruckSmall.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}
	

}
