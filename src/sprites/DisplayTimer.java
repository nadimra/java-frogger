package sprites;

import java.util.ArrayList;

import model.MyStage;

/**
 * This class displays the time on the screen
 * @author Nadim Rahman
 *
 */
public class DisplayTimer extends Timer{
	private MyStage background;
    static final int offset= 30;
    static final int maxScore = 800;
    static final int baseWidth = 300;
    static final int baseHeight = 25;

	private int amountTime;
	private int amountDigits;
	private boolean timesUp;
 
	/**
	 * Initialised the variables
	 * @param background
	 * @param amountTime to start with
	 */
    public DisplayTimer(MyStage background, int amountTime) {
    	super();
        this.background = background;
        this.amountTime = amountTime;
        amountDigits = calculateAmountDigits(amountTime);
        setNumber(amountTime);
    }
   
    /**
     * Calculates the number of digits to display on the screen
     * @param n the value to show on screen
     * @return
     */
    public int calculateAmountDigits(int n) {
    	int shift = 0;
    	while (n > 0) {
    		int d = n / 10;
    		int k = n - d * 10;
    		n = d;
    		shift+=1;
    	}
    	return shift;
    }
    
    /**
     * Increment seconds when a second has passed
     */
    @Override
    public void incrementSeconds() {
    	seconds++;
    	setNumber(getTimeLeft());
    }
    
    public int getTimeLeft() {
    	return amountTime-seconds;
    }
    
    /**
     * Display n on the screen
     * @param n
     */
    public void setNumber(int n) {
    	if(n<0) {
    		timesUp = true;
    	}
    	else {
	    	int shift = 0;
		    if(calculateAmountDigits(n)<amountDigits) {
		    	// Check if the timer has reduced by a tenth
		    	// Change the most significant digit to 0
		    	background.add(new Digit(0, 30, baseWidth-offset*calculateAmountDigits(n), baseHeight));
		    }
		    while (n > 0) {
		    	int d = n / 10;
		    	int k = n - d * 10;
		    	n = d;
		    	background.add(new Digit(k, 30, baseWidth-offset*shift, baseHeight));
		    	shift+=1;
		    }
	    }

    }
    
    public boolean getTimesUp() {
    	return timesUp;
    }
    
}
    

