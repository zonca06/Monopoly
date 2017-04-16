package edu.ncsu.monopoly.test;



import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.MoneyCard;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardCCGainMoney;
import junit.framework.TestCase;

public class CardsTest extends TestCase {
    Card ccCard, chanceCard;
    
    GameMaster gameMaster;

    // En este metodo prepara el tablero y le agrega cartas que pueden salir.
    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        //cada uno de los metodos de debajo agrega una carta al monton correspondiente
        //ccCard equivale al casillero ComunityChest, Existen dos en el tablero
        ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        //chanceCard equivale al casillero Chance, existen dos en el tablero
        chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(ccCard);
    }
    
    //En este metodo sobre la cartas que se agregaron previamente va sacando cartas y compara con las que se agregaron
    public void testCardType() {
        Card card = gameMaster.drawCCCard();
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
        card = gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
}
