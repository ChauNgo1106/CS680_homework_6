package edu.umb.cs680.hw06;

import java.util.Objects;

public class DrawerClosedNotPlaying implements State {

	private static DVDPlayer player = DVDPlayer.getInstance();

	private DrawerClosedNotPlaying() {
	}

	// Singleton
	private static DrawerClosedNotPlaying instance = null;

	public static DrawerClosedNotPlaying getInstance() {
		try {
			return Objects.requireNonNull(instance);
		} catch (NullPointerException ex) {
			instance = new DrawerClosedNotPlaying();
			return instance;
		}
	}
	//I will print the current state of Drawer, then events/actions and finally it will print the changing state
	@Override
	public String openCloseButtonPushed() {
		System.out.println("Drawer is closed and CD is not playing");
		System.out.print("Press: ");
		player.open();
		player.changeState(DrawerOpen.getInstance());
		System.out.println("Drawer is open");
		String message = "Drawer is closed and CD is not playing" + "\n" + "Press: Open" + "\n" + "Drawer is open";
		return message;

	}

	@Override
	public String playButtonPushed() {
		System.out.println("Drawer is closed and CD is not playing");
		System.out.print("Press: ");
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());
		System.out.println("Drawer is closed and CD is plying");
		String message = "Drawer is closed and CD is not playing" + "\n" + "Press: Play" + "\n" + "CD is playing";
		return message;
	}

	@Override
	public String stopButtonPushed() {
		System.out.println("Drawer is closed and CD is not playing");
		System.out.println("Press stop button and nothing happen");
		
		String message = "Drawer is closed and CD is not playing" + "\n" + "Press stop button and nothing happen";
		return message;
	}
}
