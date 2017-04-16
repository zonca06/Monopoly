package edu.ncsu.monopoly.test;



import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.JailCard;
import edu.ncsu.monopoly.MoneyCard;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardCCGainMoney;
import junit.framework.TestCase;

public class CardsTest extends TestCase {
    Card ccCard, chanceCard, jailCard;
    
    GameMaster gameMaster;

    // En este metodo prepara el tablero y le agrega cartas que pueden salir.
    /* Separo este metodo para cada uno de los metodos de prueba para que no se crucen las pruebas
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
        //se agrega jailCard
        jailCard = new JailCard(1);
        gameMaster.getGameBoard().addCard(ccCard);
    }
    */
    public void testCardTypeCCCardWinMoney() {
    	// Preparo el tablero
    	gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        
        //Agrego la carta a la partida
        //ccCard equivale al casillero ComunityChest, Existen dos en el tablero
        ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        gameMaster.getGameBoard().addCard(ccCard);
        
        
      //Comparo para ver si son el mismo tipo
        Card card = gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
    }
    
    public void testCardTypeCCCardLoseMoney() {
    	// Preparo el tablero
    	gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        
        //Agrego la carta a la partida
        //ccCard equivale al casillero ComunityChest, Existen dos en el tablero
        ccCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CC);
        gameMaster.getGameBoard().addCard(ccCard);
        
        //Simulo la sacada de carta
        Card card = gameMaster.drawCCCard();
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
    }
    
    public void testCardTypeCHCardWinMoney() {
    	// Preparo el tablero
    	gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        
        //agrego la carta a la partida
        //chanceCard equivale al casillero Chance, existen dos en el tablero
        chanceCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(chanceCard);
        
        //simulo la sacada de carta
        Card card = gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
    
    public void testCardTypeCHCardLoseMoney() {
    	// Preparo el tablero
    	gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        
        //agrego la carta a la partida
        //chanceCard equivale al casillero Chance, existen dos en el tablero
        chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(chanceCard);
        
        //Comparo para ver si son el mismo tipo
        Card card = gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
    public void testCardTypeJailCardInCHCard(){
    	// Preparo el tablero
    	gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        
        //Creo la carta
        jailCard = new JailCard(Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(jailCard);
        
      //Comparo para ver si son el mismo tipo
        Card card = gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CHANCE, jailCard.getCardType());
    }
    
    public void testCardTypeJailCardInCCCard(){
    	// Preparo el tablero
    	gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        
        //agrego la carta a la partida
        jailCard = new JailCard(Card.TYPE_CC);
        gameMaster.getGameBoard().addCard(jailCard);
        
      //Comparo para ver si son el mismo tipo
        Card card = gameMaster.drawChanceCard();
        assertEquals(Card.TYPE_CC, jailCard.getCardType());
    }
    
    
}
