package p4_group_8_repo;

import javafx.scene.image.Image;

public class Level {
		MyStage background;

		private int speed;

		public Level(MyStage background) {
			this.background = background;
			createLogs();
			createAnimals();
			createEnds();
			createObstacles();

		}
		
		/**
		 * This method creates the different log objects
		 * 
		 */
		private void createLogs() {
			background.add(new Log("file:src/resources/log3.png", 150, 0, 166, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 220, 166, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 440, 166, 0.75));
			background.add(new Log("file:src/resources/logs.png", 300, 0, 276, -2));
			background.add(new Log("file:src/resources/logs.png", 300, 400, 276, -2));
			background.add(new Log("file:src/resources/log3.png", 150, 50, 329, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 270, 329, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 490, 329, 0.75));
		}
		
		/**
		 * This method creates the different animals enemy objects
		 * 
		 */
		private void createAnimals() {
			background.add(new Turtle(500, 376, -1, 130, 130));
			background.add(new Turtle(300, 376, -1, 130, 130));
			background.add(new WetTurtle(700, 376, -1, 130, 130));
			background.add(new WetTurtle(600, 217, -1, 130, 130));
			background.add(new WetTurtle(400, 217, -1, 130, 130));
			background.add(new WetTurtle(200, 217, -1, 130, 130));
		}
		
		/**
		 * This method creates the different obstacles
		 * 
		 */
		private void createObstacles() {
			background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
			background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			background.add(new Obstacle("file:src/resources/car1Left.png", 100, 597, -1, 50, 50));
			background.add(new Obstacle("file:src/resources/car1Left.png", 250, 597, -1, 50, 50));
			background.add(new Obstacle("file:src/resources/car1Left.png", 400, 597, -1, 50, 50));
			background.add(new Obstacle("file:src/resources/car1Left.png", 550, 597, -1, 50, 50));
			background.add(new Obstacle("file:src/resources/truck2Right.png", 0, 540, 1, 200, 200));
			background.add(new Obstacle("file:src/resources/truck2Right.png", 500, 540, 1, 200, 200));
			background.add(new Obstacle("file:src/resources/car1Left.png", 500, 490, -5, 50, 50));
		}
		
		/**
		 * This method creates the ends of the level
		 * 
		 */
		private void createEnds(){
			background.add(new End(13,96));
			background.add(new End(141,96));
			background.add(new End(141 + 141-13,96));
			background.add(new End(141 + 141-13+141-13+1,96));
			background.add(new End(141 + 141-13+141-13+141-13+3,96));
		}
		
}
