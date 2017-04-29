package edu.ncsu.monopoly;


public class TaxiCard extends Card {
    
   // private String destination;
    private int type;
    private int valorSeleccionado;

    public TaxiCard(int valorSeleccionado, int cardType) {
        this.valorSeleccionado=valorSeleccionado;
        this.type = cardType;
    }

    public int getValorSeleccionado() {
		return valorSeleccionado;
	}

	public void setValorSeleccionado(int valorSeleccionado) {
		this.valorSeleccionado = valorSeleccionado;
	}

	public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
       // Cell currentPosition = currentPlayer.getPosition();
        //int newCell = GameMaster.instance().getGameBoard().queryCellIndex(destination);
        //int currentCell = GameMaster.instance().getGameBoard().queryCellIndex(currentPosition.getName());
        //int diceValue = 0;
        //if(currentCell > newCell) {
          //  diceValue = (GameMaster.instance().getGameBoard().getCellNumber() + 
            //        (newCell - currentCell));
        //}
       // else if(currentCell < newCell) {
         //   diceValue = newCell - currentCell;
       // }
        //System.out.println(diceValue);
        GameMaster.instance().movePlayer(currentPlayer, valorSeleccionado);
    }

    public int getCardType() {
        return type;
    }

    public String getLabel() {
        return "Posiciones movidas " + valorSeleccionado;
    }

}
