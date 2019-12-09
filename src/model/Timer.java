package model;

public class Timer {
	
    long lastTime; 
	long now;
	int seconds;
	
	public Timer() {
        seconds = 0;
        lastTime = 0;
	}
	
    public void incrementSeconds() {
    	seconds++;
    }
	
    public long getLastTime() {
    	return lastTime;
    }
    
    public long setLastTime(long now) {
    	return lastTime = now;
    }
    
    public void resetTimer() {
    	seconds = 0;
    }
    
    public int getSeconds() {
    	return seconds;
    }
}
