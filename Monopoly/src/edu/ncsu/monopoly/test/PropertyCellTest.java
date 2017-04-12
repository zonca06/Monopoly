package edu.ncsu.monopoly.test;




import javax.naming.NoInitialContextException;

import edu.ncsu.monopoly.Cell;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.PropertyCell;
import edu.ncsu.monopoly.SimpleGameBoard;
import junit.framework.TestCase;

public class PropertyCellTest extends TestCase {

	GameMaster gameMaster;
	
	protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new SimpleGameBoard());
		gameMaster.setNumberOfPlayers(2);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
	}
	
	public void testPlayerAction() {
		PropertyCell cell =
			(PropertyCell) gameMaster.getGameBoard().queryCell("Blue 3");
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Blue 3");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		gameMaster.switchTurn();
		gameMaster.movePlayer(1, cellIndex);
		cell.playAction();
		assertEquals(
				1500 - cell.getRent(Cell.NoInflationParameter),
				gameMaster.getPlayer(1).getMoney());
		assertEquals(
				1380 + cell.getRent(Cell.NoInflationParameter),
				gameMaster.getPlayer(0).getMoney());
	}
}
