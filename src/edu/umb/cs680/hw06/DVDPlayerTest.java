package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DVDPlayerTest {

	// testing the singleton of DrawerOpen class.
	@Test
	public void check_the_singleton_of_drawer_open_class() {
		DrawerOpen drawer = DrawerOpen.getInstance();
		DrawerOpen drawer1 = DrawerOpen.getInstance();

		assertTrue(drawer instanceof DrawerOpen);
		assertTrue(drawer instanceof State);
		assertSame(drawer, drawer1);
	}

	// testing the singleton of DrawerClosedPlaying class.
	@Test
	public void check_the_singleton_of_drawer_close_not_playing_class() {
		DrawerClosedNotPlaying drawer = DrawerClosedNotPlaying.getInstance();
		DrawerClosedNotPlaying drawer1 = DrawerClosedNotPlaying.getInstance();

		assertTrue(drawer instanceof DrawerClosedNotPlaying);
		assertTrue(drawer instanceof State);
		assertSame(drawer, drawer1);
	}

	// testing the singleton of DrawerClosedNotPlaying class.
	@Test
	public void check_the_singleton_of_drawer_close_playing_class() {
		DrawerClosedPlaying drawer = DrawerClosedPlaying.getInstance();
		DrawerClosedPlaying drawer1 = DrawerClosedPlaying.getInstance();

		assertTrue(drawer instanceof DrawerClosedPlaying);
		assertTrue(drawer instanceof State);
		assertSame(drawer, drawer1);
	}

	// testing the singleton of DVDPlayer class.
	@Test
	public void check_the_singleton_of_DVDPlayer_class() {
		DVDPlayer player = DVDPlayer.getInstance();
		DVDPlayer player1 = DVDPlayer.getInstance();

		assertTrue(player instanceof DVDPlayer);
		assertTrue(player1 instanceof DVDPlayer);
		assertSame(player, player1);

		// I can check its hashcode when creating an instance
		assertEquals(player.hashCode() , player1.hashCode());
	}

	@Test
	public void checking_the_change_state_DrawerClosedNotPlaying_to_DrawerOpen() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.changeState(DrawerOpen.getInstance());

		DrawerOpen drawer = DrawerOpen.getInstance();
		assertEquals(player.playButtonPushed(), drawer.playButtonPushed());
		// do the reset of instance variable.
		player.resetInstance();
	}
	

	@Test
	public void checking_player1_open_close_then_play_and_stop_button_pushed() {
		DVDPlayer player1 = DVDPlayer.getInstance();
		String actual = "";
		String expected = "";

		// open drawer
		actual += player1.openCloseButtonPushed();
		expected += "Drawer is closed and CD is not playing" + "\n" + "Press: Open" + "\n" + "Drawer is open";
		assertEquals(expected, actual);
		// play
		actual += player1.playButtonPushed();
		expected += "Drawer is open" + "\n" + "Press: Play" + "\n" + "Drawer is close" + "\n" + "CD is: Play";

		// stop
		actual += player1.stopButtonPushed();
		expected += "Drawer is closed and CD is playing" + "\n" + "Press: Stop" + "\n"
				+ "CD will stop playing and drawer is: Open";

		// check at the end
		assertEquals(expected, actual);
		// reset instance variable of DVDPlayer
		player1.resetInstance();
	}

	@Test
	public void checking_player2_stop_then_play_and_open_close_button_pushed() {
		DVDPlayer player2 = DVDPlayer.getInstance();
		String actual = "";
		String expected = "";

		// stop
		actual += player2.stopButtonPushed();
		expected += "Drawer is closed and CD is not playing" + "\n" + "Press stop button and nothing happen";

		assertEquals(expected, actual);
		// play
		actual += player2.playButtonPushed();
		expected += "Drawer is closed and CD is not playing" + "\n" + "Press: Play" + "\n" + "CD is playing";

		// open
		actual += player2.openCloseButtonPushed();
		expected += "Drawer is closed and CD is playing" + "\n" + "Press: Open" + "\n"
				+ "Drawer is open and stop playing CD";

		// check at the end
		assertEquals(expected, actual);
		// reset instance variable of DVDPlayer
		player2.resetInstance();
	}

	@Test
	public void checking_player3_play_then_play_then_open_then_stop_and_open_close_button_pushed() {
		DVDPlayer player3 = DVDPlayer.getInstance();
		String actual = "";
		String expected = "";

		// play
		actual += player3.playButtonPushed();
		expected += "Drawer is closed and CD is not playing" + "\n" + "Press: Play" + "\n" + "CD is playing";

		assertEquals(expected, actual);
		// play
		actual += player3.playButtonPushed();
		expected += "Drawer is closed and CD is playing" + "\n" + "Press play button and nothing happen";

		// open
		actual += player3.openCloseButtonPushed();
		expected += "Drawer is closed and CD is playing" + "\n" + "Press: Open" + "\n"
				+ "Drawer is open and stop playing CD";
		// stop
		actual += player3.stopButtonPushed();
		expected += "Drawer is open" + "\n" + "Press stop button and nothing happen";

		// finally open/close button pushed
		actual += player3.openCloseButtonPushed();
		expected += "Drawer is open" + "\n" + "Press: Close" + "\n" + "Drawer is closed and CD is not playing";

		// check at the end
		assertEquals(expected, actual);
		// reset instance variable of DVDPlayer
		player3.resetInstance();
	}
	
}
