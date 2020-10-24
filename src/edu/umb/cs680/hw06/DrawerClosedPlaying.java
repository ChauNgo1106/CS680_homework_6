package edu.umb.cs680.hw06;

import java.util.Objects;

public class DrawerClosedPlaying implements State {

	private static DVDPlayer player = DVDPlayer.getInstance();

	private DrawerClosedPlaying() {
	}

	// Singleton
	private static DrawerClosedPlaying instance = null;

	public static DrawerClosedPlaying getInstance() {
		try {
			return Objects.requireNonNull(instance);
		} catch (NullPointerException ex) {
			instance = new DrawerClosedPlaying();
			return instance;
		}
	}

	//I will print the current state of Drawer, then events/actions and finally it will print the changing state
	@Override
	public String openCloseButtonPushed() {
		System.out.println("Drawer is closed and CD is playing");
		System.out.print("Press: ");
		player.open();
		System.out.println("Drawer is open and stop playing CD");
		player.stop();
		player.changeState(DrawerOpen.getInstance());

		String message = "Drawer is closed and CD is playing" + "\n" + "Press: Open" + "\n"
				+ "Drawer is open and stop playing CD";
		return message;
	}

	@Override
	public String playButtonPushed() {
		System.out.println("Drawer is closed and CD is playing");
		System.out.println("Press play button and nothing happen");

		String message = "Drawer is closed and CD is playing" + "\n" + "Press play button and nothing happen";
		return message;
	}

	@Override
	public String stopButtonPushed() {
		System.out.println("Drawer is closed and CD is playing!");
		System.out.print("Press: ");
		player.stop();
		System.out.print("CD will stop playing and drawer is: ");
		player.open();
		player.changeState(DrawerOpen.getInstance());
		
		String message = "Drawer is closed and CD is playing" + "\n" + "Press: Stop" + "\n" + "CD will stop playing and drawer is: Open";
		return message;

	}

}
