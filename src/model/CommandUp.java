package model;

public class CommandUp implements Command{
	Animal animal; 
	  
    // The constructor is passed the light it 
    // is going to control. 
    public CommandUp(Animal animal) 
    { 
       this.animal = animal; 
    } 
    
    public void execute() 
    { 
    } 
}
