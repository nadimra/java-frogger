package sprites;

/**
 * This class manages a timer
 * @author Nadim Rahman
 *
 */
public class Timer {
	
    long lastTime; 
	long now;
	int seconds;
	
	public Timer() {
        seconds = 0;
        lastTime = 0;
	}
	
	/**
	 * Increment seconds when a second has passed
	 */
    public void incrementSeconds() {
    	seconds++;
    }
	
    public long getLastTime() {
    	return lastTime;
    }
    
    /**
     * @param now the time the object has lived for
     * @return lastTime
     */
    public long setLastTime(long now) {
    	return lastTime = now;
    }
    
    /**
     * Reset the timer when game restarts
     */
    public void resetTimer() {
    	seconds = 0;
    }
    
    public int getSeconds() {
    	return seconds;
    }
}
