package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
* This class provides the structure for a highscore
* 
* @author Nadim Rahman
* 
*/
public class Highscore {

	    private IntegerProperty score;
	    private StringProperty name;
	    
	    /** 
	     * Initialises highscore
	     * @param name
	     * @param score
	     */
	    public Highscore(String name, int score) {	    	
	        this.score = new SimpleIntegerProperty(score);
	        this.name = new SimpleStringProperty(name);
	    }

	    public IntegerProperty getScore() {
	        return score;
	    }
	    
	    public StringProperty getName() {
	        return name;
	    }

}

