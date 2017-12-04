
package com.shubham.brainrush;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Shubham Agrawal
 *
 */
public class Sound {

//	private Long currentFrame;
	private Clip clip;
	private AudioInputStream audioInputStream;
	private String soundFile, musicFile;

	// method to play beep sound
	/**
	 * @throws URISyntaxException 
	 * 
	 */
	public void sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, URISyntaxException {

		soundFile = "Beep.wav";
		play(soundFile);

	}

	// method to play background music
	/**
	 * @throws URISyntaxException 
	 * 
	 */
	public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException, URISyntaxException {

		musicFile = "Music.wav";
		play(musicFile);

	}

	/**
	 * @param soundFile 
	 * @param string
	 */
	private void play(String soundFile) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		// create AudioInputStream object
		audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource( soundFile ));

		// create clip reference
		clip = AudioSystem.getClip();

		// open audioInputStream to the clip
		clip.open(audioInputStream);

		//clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();

	}

}