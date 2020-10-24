package edu.umb.cs680.hw06;

public class mainClass_DVDPlayer {

	public static void main(String[] args) {
		//close, and not playing
		DVDPlayer player1 = DVDPlayer.getInstance();
		//open drawer
		player1.openCloseButtonPushed();
		//player1.insertCD();
		//player1.rejectCD();
		//close drawer and playing
		player1.playButtonPushed();
		//stop playing and open drawer
		player1.stopButtonPushed();
		//nothing happen 
		player1.stopButtonPushed();
		//nothing happen
		player1.stopButtonPushed();
		//close drawer but CD will not play yet
		player1.openCloseButtonPushed();
		//nothing happen
		player1.stopButtonPushed();
	}

}
