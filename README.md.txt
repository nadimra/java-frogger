Run the 'Main' class in the Model package to play the game.

[Classes: LogFactory, ObstacleFactory, TurtleFactory]
I have used the creational factory design pattern for the creation of logs, turtles, and obstacles. 
This takes out the responsibility of instantiation of a class to the factory class instead. 
I have also used the flyweight structural design pattern on these factories to consume less memory (as these objects are created multiple times).
 
[Classes: HighscoreManagerSingleton]
The highscore manager was made into a singleton since it only needs to be created once. You don’t need multiple instances of this object.

[Package: Command]
The implementation of this design pattern has made it easy to set the user input and it can let the user configure how their buttons are mapped if it is a feature to be implemented in the future. 
It is used to encapsulate all information needed to perform an action or trigger.

[Package Layout: MVC Pattern]
I have moved all the FXML GUI files into a view package, the controller classes for these screens in the controller package, and the data classes in other model packages. 
This architectural pattern has made the development process faster. 
The use of FXML also separates design from functionality. Being able to separate the components makes it easier to re-use and test.

[Class: LevelCreator]
I created a level creator which can read text files, convert the text into lanes, and build levels from the lanes. 
Separating the levels from the code allows creators to create levels without needing to know the code. 
By separating the level into lanes, it removes the need to calculate the fixed pixel positions of the object, making it much easier to create functional levels.

[Package: tests]
I have conducted several JUnit tests on several classes. 
By using regression testing with these test cases, it allows me to identify if new changes to the code has caused errors in other areas.

[Class: Ambulance]
I have added an ambulance obstacle to the game to add an interesting dynamic. 
If the player collides with the object, then the lose a life. An ambulance can ‘offload’ lives, and if a user collects these lives, they regain a lost life. 

[All Classes]
I have followed the ‘Single Responsibility’ SOLID principle. Originally, some classes had multiple tasks. 
In particular, the ‘Main’ class had a extreme case of ‘The Blob’ antipattern. It was managing the GUI, level creation, game over functionality, etc. 
Splitting the functionality into separate classes (Level Creator, GameOverController etc). 
The ‘Main’ app is now only responsible for showing the GUI, and the MainGameController manages the game.This supports the reuse of code. 

[Classes: Obstacle, Truck]
For all instances of inheritance being used, I have used Liskov’s substitution principle. 
This can particularly be seen in when the Truck class inherits from the Truck class. 
Originally, I coded it so that the Obstacle class contained the setDirection() method, however, given that some obstacles might not have a direction, this method was moved to the Truck class, where the truck will have a direction. 
