package model;
import java.util.Comparator;

import javafx.beans.property.IntegerProperty;

public class HighscoreComparator implements Comparator<Highscore> {
	public int compare(Highscore score1, Highscore score2) {

		IntegerProperty scoreOne = score1.getScore();
		IntegerProperty scoreTwo = score2.getScore();

		if (scoreOne.getValue() > scoreTwo.getValue()){
			return -1;
		}else if (scoreOne.getValue() < scoreTwo.getValue()){
			return 1;
		}else{
			return 0;
		}
	}
}

