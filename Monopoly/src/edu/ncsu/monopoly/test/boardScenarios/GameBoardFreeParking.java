
package edu.ncsu.monopoly.test.boardScenarios;

import edu.ncsu.monopoly.FreeParkingCell;
import edu.ncsu.monopoly.GameBoard;
import edu.ncsu.monopoly.GoToJailCell;
import edu.ncsu.monopoly.JailCell;

public class GameBoardFreeParking extends GameBoard {
	public GameBoardFreeParking() {
		super();
		JailCell jail = new JailCell();
		FreeParkingCell freeParking = new FreeParkingCell();
		GoToJailCell goToJail = new GoToJailCell();
		addCell(jail);
		addCell(freeParking);
		addCell(goToJail);

	}
}
