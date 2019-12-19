package model;

import sprites.Digit;

/**
 * The object of this class displays the score to the GUI
 * 
 * @author Nadim Rahman
 * @version 1.0
 * @since 26-11-2019
 *
 */

public class Score {
    private MyStage background;
    static final int offset= 30;
    static final int maxScore = 800;
    static final int baseWidth = 560;
    static final int baseHeight = 25;
    private int points;
    private Digit[] digits;
    private boolean changeScore = false;
    
    
    /**
     * This method initialises the score and sets the score display to 0
     * @param background is the main window
     */
    public Score(MyStage background) {
        this.background = background;
        points =0;
		background.add(new Digit(0, 30, baseWidth, baseHeight));
    }
   
    /**
     * This method manages the scoring display and is updated after each change
     *@param n is the number to display
     */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, baseWidth - shift*offset, baseHeight));
    		  shift+=1;
    		}
    }
    
	public int getPoints() {
		return points;
	}
	
	/**
	 * This method updates the points.
	 * @param n is the amount of points to add to the total points.
	 * 
	 */
	public void updatePoints(int n) {
		points = getPoints() + n;
		setChangeScore(true);
	}
	
	public void setChangeScore(boolean set) {
		changeScore = set;
	}
	
	public boolean getChangeScore() {
		return changeScore;
	}
	
	/**
	 * This method is called to see if the score has been updated on the screen
	 * @return
	 */
	public boolean updateScore() {
		if(changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	
	
}