package p4_group_8_repo;
import java.util.Comparator;

public class HighscoreComparator implements Comparator<Highscore> {
	public int compare(Highscore score1, Highscore score2) {

		int scoreOne = score1.getScore();
		int scoreTwo = score2.getScore();

		if (scoreOne > scoreTwo){
			return -1;
		}else if (scoreOne < scoreTwo){
			return 1;
		}else{
			return 0;
		}
	}
}

