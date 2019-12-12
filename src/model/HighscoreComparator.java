package model;
import java.util.Comparator;

import javafx.beans.property.IntegerProperty;

/**
* This class is a comparator to compare 2 different highscores
* 
* @author Nadim Rahman
* 
*/
public class HighscoreComparator implements Comparator<Highscore> {
	public int compare(Highscore score1, Highscore score2) {

		IntegerProperty scoreOne = score1.getScore();
		IntegerProperty scoreTwo = score2.getScore();

		
		if (scoreOne.getValue() > scoreTwo.getValue()){
			return -1;
		}else if (scoreOne.getValue() < scoreTwo.getValue()){
			return 1;
		}else{
			// the scores are equal
			return 0;
		}
	}
}

