package edu.umb.cs680.hw06;

import java.util.Objects;

public class DrawerOpen implements State {

	private static DVDPlayer player = DVDPlayer.getInstance();

	private DrawerOpen() {

	}

	// Singleton
	private static DrawerOpen instance = null;

	public static DrawerOpen getInstance() {
		try {
			return Objects.requireNonNull(instance);
		} catch (NullPointerException ex) {
			instance = new DrawerOpen();
			return instance;
		}
	}

	// I will print the current state of Drawer, then events/actions and finally it
	// will print the changing state
	@Override
	public String openCloseButtonPushed() {

		System.out.println("Drawer is open");
		System.out.print("Press: ");
		player.close();
		System.out.println("Drawer is closed and CD is not playing");
		player.changeState(DrawerClosedNotPlaying.getInstance());

		// concatenate message
		String message = "Drawer is open" + "\n" + "Press: Close" + "\n" + "Drawer is closed and CD is not playing";
		return message;
	}

	@Override
	public String playButtonPushed() {

		System.out.println("Drawer is open");
		System.out.print("Press: ");
		player.play();
		System.out.print("Drawer is ");
		player.close();
		System.out.print("CD is: ");
		player.play();

		player.changeState(DrawerClosedPlaying.getInstance());
		// concatenate message
		String message = "Drawer is open" + "\n" + "Press: Play" + "\n" + "Drawer is close" + "\n" + "CD is: Play";
		return message;
		// Objects.requireNonNull(player.getCD());

	}

	@Override
	public String stopButtonPushed() {
		System.out.println("Drawer is open");
		System.out.println("Press stop button and nothing happen");

		// concatenate message
		String message = "Drawer is open" + "\n" + "Press stop button and nothing happen";
		return message;

	}

}
