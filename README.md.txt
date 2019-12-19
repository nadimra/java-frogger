highscoremanager singleton is called by gameovercontroller, highscoreinput and highscorecontroller
level manager called by main, called by animal to get ends, lane contains actors
basically everyone uses mystage
score created from maingame controller
all factories and ends created by lane


Menu screen is loaded, Help screen

Play game
Level intro - multiple levels
Pause game
Timer
Timer bonuses
Next level loaded
Lives
Ambulance
Highscore submit
Level creator

The menu screen is first launched. They can click options such as the help screen and also choose to play the game.
The first level is launched and a level intro screen pops up for 3 seconds.
The user can pause the game at any time by pressing escape, and then continue their game, or reset. Doing this will reset the time and score.
The user has 60 seconds to complete each level, as shown above. The user gets a timer bonus to their total score when they finish the level.
When the level is complete, the next level is instantly loaded.
The user has 3 lives, and the lives decrement if the player dies.
I've added an ambulance obstacle, which can cause the players death if they collide with it. The ambulance can also offload lives so the player can regain a life.
The user can submit their highscore if they reach the top 10 scores, which are stored in a text file. Their input will be validated.
Their score will then be updated and shown in the highscore list and text file.
A big feature is the level creator. The user can create a level in the text editor quite easily. 
Each lane can have an actor type, a certain amount of that actor, a travel speed, and spacing between the characters, along with the starting offset.

Another big feature is the level editor. You can create levels in the text editor easily. 
Each text file is split into lanes, which contain an actor type, a certain amount of that actor, a lane speed, a spacing between the characters and a starting offset

Used Flyweight, Singleton, Factory and Command design pattern. 
Each method is commented, and has 1 task. Code units are small and encapsulation has been used to protect data.
Used constant variables when necessary 

I've used many design patterns. Such as the Flyweight design pattern along with factories for the creation of level objects. I have also used the singleton and command design pattern.
The methods are commented and have 1 tasks. Code units are small and encapsulation has been used to protect data.
Inheritance has been used when an object can be generalized. For example, DisplayTimer extends most methods from the Timer class. But also has its own methods to be able to display the timer.
Classes have been sorted in the MVC pattern for faster development
Constants have been used so that the programmer can be consstant throughout.For example, if the window width changes, a simple change to the constant will update the relative positions of other objects.

One of my best features is the highscore impementation. If the user gets the top 10 score overall, they can submit their score and it is permanantly stored in the textfile.
