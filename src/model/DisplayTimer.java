package model;

import java.util.ArrayList;

public class DisplayTimer {
	MyStage background;
    static final int offset= 30;
    static final int maxScore = 800;
    static final int baseWidth = 300;
    static final int baseHeight = 25;

    long lastTime; 
	long now;
	int seconds;
	int amountTime;
	int amountDigits;
	private boolean timesUp;
 
    /**
     * This method initialises the score and sets the score display to 0
     */
    public DisplayTimer(MyStage background, int amountTime) {
        this.background = background;
        seconds = 0;
        lastTime = 0;
        this.amountTime = amountTime;
        amountDigits = calculateAmountDigits(amountTime);
        setNumber(amountTime);
    }
   
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
    
    public void incrementSeconds() {
    	seconds++;
    	setNumber(amountTime-seconds);
    }
    
    public void setNumber(int n) {
    	if(n<0) {
    		timesUp = true;
    	}
    	else {
	    	int shift = 0;
		    if(calculateAmountDigits(n)<amountDigits) {
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

    public long getLastTime() {
    	return lastTime;
    }
    
    public long setLastTime(long now) {
    	return lastTime = now;
    }
	
    public boolean getTimesUp() {
    	return timesUp;
    }
}
