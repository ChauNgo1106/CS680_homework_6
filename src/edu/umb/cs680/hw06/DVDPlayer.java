package edu.umb.cs680.hw06;

import java.util.Objects;
import java.util.Stack;

public class DVDPlayer {

	private State state;

	private DVDPlayer() {
		// at the beginning, the drawer will be closed and not playing as well
		this.state = DrawerClosedNotPlaying.getInstance();
	}

	// Singleton
	private static DVDPlayer instance = null;

	public static DVDPlayer getInstance() {
		try {
			return Objects.requireNonNull(instance);
		} catch (NullPointerException ex) {
			instance = new DVDPlayer();
			return instance;
		}
	}
	// everytime I want to start a new test, I have to reset my instance variable
	// back to null
	public void resetInstance() {
		this.instance = null;
	}

	public void changeState(State newState) {
		instance.state = newState;
	}

	public String openCloseButtonPushed() {
		return state.openCloseButtonPushed();
	}

	public String playButtonPushed() {
		return state.playButtonPushed();
	}

	public String stopButtonPushed() {
		return state.stopButtonPushed();
	}

	public void open() {
		System.out.println("Open");
	}

	public void close() {
		System.out.println("Close");
	}

	public void play() {
		System.out.println("Play");
	}

	public void stop() {
		System.out.println("Stop");
	}

}
