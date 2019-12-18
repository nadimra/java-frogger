package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import model.LevelCreator.ActorTypes;
import sprites.Obstacle;
import sprites.ObstacleFactory;
import sprites.Turtle;
import sprites.TurtleFactory;

class TurtleFactory_Test {

	JFXPanel fxPanel;
	
	@BeforeEach
	public void init() throws IOException {
		fxPanel = new JFXPanel();
	}
	
	@Test
	void checkReturnNormalTurtle() {
		Turtle turtle = TurtleFactory.getTurtle(ActorTypes.NormalTurtle, 0, 0, 0);
		boolean pass;
		if(turtle.getClass().getSimpleName().equals(ActorTypes.NormalTurtle.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}
	
	@Test
	void checkReturnWetTurtle() {
		Turtle turtle = TurtleFactory.getTurtle(ActorTypes.WetTurtle, 0, 0, 0);
		boolean pass;
		if(turtle.getClass().getSimpleName().equals(ActorTypes.WetTurtle.name())) {
			pass = true;
		}
		else {
			pass = false;
		}
		assertTrue(pass);
	}

	
}
