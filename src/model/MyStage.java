package model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * This class extends from the World class and controls the music
 * @author Nadim Rahman
 *
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
		
	}
	
	/** 
	 * This method plays the music
	 * 
	 */
	public void playMusic() {
		String musicFile = "src/resources/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * This method stops the music
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
