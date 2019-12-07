package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Highscore {

	    private IntegerProperty score;
	    private StringProperty name;
	    
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

