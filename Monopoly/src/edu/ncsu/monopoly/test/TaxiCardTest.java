package edu.ncsu.monopoly.test;

import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.Cell;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.JailCard;
import edu.ncsu.monopoly.TaxiCard;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardCCJail;
import junit.framework.TestCase;

public class TaxiCardTest extends TestCase {
	GameMaster gameMaster;
	Card taxiCard1 = new TaxiCard(1, Card.TYPE_CC);
	Card taxiCard2 = new TaxiCard(2, Card.TYPE_CC);
	Card taxiCard3 = new TaxiCard(3, Card.TYPE_CC);
	Card taxiCard4 = new TaxiCard(4, Card.TYPE_CC);
	Card taxiCard5 = new TaxiCard(5, Card.TYPE_CC);
	Card taxiCard6 = new TaxiCard(6, Card.TYPE_CC);

	protected void setUp(Card card) {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCJail());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		gameMaster.getGameBoard().addCard(card);
	}

	public void testTaxiCard1Action() {
		this.setUp(taxiCard1);
		Card card = gameMaster.drawCCCard();
		assertEquals(taxiCard1, card);
		Cell cellOrig = gameMaster.getCurrentPlayer().getPosition();
		card.applyAction();
		Cell cellEnd = gameMaster.getCurrentPlayer().getPosition();
		assertFalse(cellOrig == cellEnd);
	}

	public void testTaxiCard2Action() {
		this.setUp(taxiCard2);
		Card card = gameMaster.drawCCCard();
		assertEquals(taxiCard2, card);
		Cell cellOrig = gameMaster.getCurrentPlayer().getPosition();
		card.applyAction();
		Cell cellEnd = gameMaster.getCurrentPlayer().getPosition();
		assertFalse(cellOrig == cellEnd);
	}

	public void testTaxiCard3Action() {
		this.setUp(taxiCard3);
		Card card = gameMaster.drawCCCard();
		assertEquals(taxiCard3, card);
		Cell cellOrig = gameMaster.getCurrentPlayer().getPosition();
		card.applyAction();
		Cell cellEnd = gameMaster.getCurrentPlayer().getPosition();
		assertFalse(cellOrig == cellEnd);
	}

	public void testTaxiCard4Action() {
		this.setUp(taxiCard4);
		Card card = gameMaster.drawCCCard();
		assertEquals(taxiCard4, card);
		Cell cellOrig = gameMaster.getCurrentPlayer().getPosition();
		card.applyAction();
		Cell cellEnd = gameMaster.getCurrentPlayer().getPosition();
		assertFalse(cellOrig == cellEnd);
	}

	public void testTaxiCard5Action() {
		this.setUp(taxiCard5);
		Card card = gameMaster.drawCCCard();
		assertEquals(taxiCard5, card);
		Cell cellOrig = gameMaster.getCurrentPlayer().getPosition();
		card.applyAction();
		Cell cellEnd = gameMaster.getCurrentPlayer().getPosition();
		assertFalse(cellOrig == cellEnd);
	}

}
