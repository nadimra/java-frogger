package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sprites.Timer;

class Timer_Test {

	@Test
	void checkSecondsZero() {
		Timer timer = new Timer();
		int initialSeconds = timer.getSeconds();
		assertEquals(initialSeconds,0);
	}
	
	@Test
	void checkIncrementationCorrection() {
		Timer timer = new Timer();
		timer.incrementSeconds();
		int newSeconds = timer.getSeconds();
		assertEquals(newSeconds,1);
	}
	
	@Test
	void checkResetCorrection() {
		Timer timer = new Timer();
		timer.incrementSeconds();
		timer.incrementSeconds();
		timer.incrementSeconds();
		timer.resetTimer();
		assertEquals(timer.getSeconds(),0);
	}

	
}
