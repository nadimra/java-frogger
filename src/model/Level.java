package model;

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
			

			/*background.add(new Log("file:src/resources/log3.png", 150, 0, 700, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 220, 700, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 440, 700, 0.75));
			
			background.add(new Log("file:src/resources/log3.png", 150, 0, 650, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 220, 650, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 440, 650, 0.75));
			
			background.add(new Log("file:src/resources/log3.png", 150, 0, 600, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 220, 600, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 440, 600, 0.75));
			
			background.add(new Log("file:src/resources/log3.png", 150, 0, 550, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 220, 550, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 440, 550, 0.75));
			
			background.add(new Log("file:src/resources/log3.png", 150, 0, 500, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 220, 500, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 440, 500, 0.75));
			*/
			
			// imagelink, imagexsize, imageysize, xpos, ypos, speed
			//background.add(new Log("file:src/resources/log3.png", 150, 35, 0, 150 + 8, 0.75));
			//background.add(new Log("file:src/resources/log3.png", 150, 35, 220, 150 + 8, 0.75));
			//background.add(new Log("file:src/resources/log3.png", 150, 35, 440, 150 +8, 0.75));
			
			
			//background.add(LogFactory.getLog("LogBig", 0, 150, 0.75));
			
			/*
			background.add(new Log("file:src/resources/log3.png", 150, 35, 0, 250 + 8, -2));
			background.add(new Log("file:src/resources/log3.png", 150, 35, 400, 250 + 8, -2));
			
			background.add(new Log("file:src/resources/log3.png", 150, 35, 50, 300 + 8, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 35, 270, 300 + 8, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 35, 490, 300 + 8, 0.75));
			
			background.add(new Log("file:src/resources/log3.png", 150, 35, 50, 400 + 8, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 35, 270, 400 + 8, 0.75));
			background.add(new Log("file:src/resources/log3.png", 150, 35, 490, 400 + 8, 0.75));
			*/
		}
		
		/**
		 * This method creates the different animals enemy objects
		 * 
		 */
		private void createAnimals() {
			background.add(new Turtle(500, 350, -1, 130, 50));
			background.add(new Turtle(300, 350, -1, 130, 50));
			background.add(new WetTurtle(700, 200, -1, 130, 50));
			background.add(new WetTurtle(400, 200, -1, 130, 50));
			background.add(new WetTurtle(200, 200, -1, 130, 50));
		}
		
		/**
		 * This method creates the different obstacles
		 * 
		 */
		private void createObstacles() {
			background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 0, 650 + 8, 1, 120, 35));
			background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 300, 650 + 8, 1, 120, 35));
			background.add(new Obstacle("file:src/resources/truck1"+"Right.png", 600, 650 + 8, 1, 120, 35));
			//background.add(new Obstacle("file:src/resources/car1Left.png", 100, 597, -1, 50, 50));
			//background.add(new Obstacle("file:src/resources/car1Left.png", 250, 597, -1, 50, 50));
			//background.add(new Obstacle("file:src/resources/car1Left.png", 400, 597, -1, 50, 50));
			//background.add(new Obstacle("file:src/resources/car1Left.png", 550, 597, -1, 50, 50));
			//background.add(new Obstacle("file:src/resources/truck2Right.png", 0, 540, 1, 200, 200));
			//background.add(new Obstacle("file:src/resources/truck2Right.png", 500, 540, 1, 200, 200));
			//background.add(new Obstacle("file:src/resources/car1Left.png", 500, 500, -5, 50, 50));
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
