package edu.ncsu.monopoly;

public class FreeParkingCell extends Cell {

	public FreeParkingCell() {
		setName("Free Parking");
	}

	public void playAction() {
		Player currentPlayer = GameMaster.instance().getCurrentPlayer();
		int rentToCharge = 32;
		currentPlayer.payRentToBank(rentToCharge);
		;
		return;
	}
}
