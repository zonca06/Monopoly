package edu.ncsu.monopoly.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import edu.ncsu.monopoly.*;

public class GUICell extends JPanel {

	private Cell cell;
	private JLabel lblInfo;
	private JLabel[] lblPlayers = new JLabel[GameMaster.MAX_PLAYER];
	
    public GUICell(Cell cell) {
        this.cell = cell;
        setLayout(new OverlayLayout(this));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        JPanel pnlPlayer = new JPanel();
        pnlPlayer.setLayout(new GridLayout(2, 4));
        pnlPlayer.setOpaque(false);
        createPlayerLabels(pnlPlayer);
        add(pnlPlayer);
        setPreferredSize(new Dimension(100,100));
        addCellInfo();
        this.doLayout();
	}
	
	private void addCellInfo() {
        lblInfo = new JLabel();
		displayInfo();
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new GridLayout(1, 1));
        pnlInfo.add(lblInfo);
        add(pnlInfo);
    }
	
	public void addPlayer(int index) {
		Player player = GameMaster.instance().getPlayer(index);
		lblPlayers[index].setText(player.getName().substring(0, 1));
		lblPlayers[index].setOpaque(true);
	}

    private void createPlayerLabels(JPanel pnlPlayer) {
		for (int i = 0; i < GameMaster.MAX_PLAYER; i++) {
			lblPlayers[i] = new JLabel();
			if(i<ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().size()){
			lblPlayers[i].setBackground(definirColorFicha(i));
            pnlPlayer.doLayout();
			}
			pnlPlayer.add(lblPlayers[i]);
		}
		
	}
    
   private Color definirColorFicha(int indice){
	   String color = ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().get(indice).getColorFicha();
	
	   
	   if (color.equals("Blanco")) return Color.WHITE;
	   if (color.equals("Rojo")) return Color.RED;
	   if (color.equals("Verde")) return Color.GREEN;
	   if (color.equals("Amarillo")) return Color.YELLOW;
	   if (color.equals("Azul")) return Color.BLUE;
	   if (color.equals("Negro")) return Color.BLACK;
	   if (color.equals("Violeta")) return Color.MAGENTA;
	   if (color.equals("Naranja")) return Color.ORANGE;
	   return Color.GREEN;
	   
	   
   }  

	public void displayInfo() {
		lblInfo.setText(InfoFormatter.cellInfo(cell));
		lblInfo.setToolTipText(InfoFormatter.cellInfo(cell));
        this.invalidate();
		this.repaint();
	}

	public Cell getCell() {
		return cell;
	}
	
	public void removePlayer(int index) {
		lblPlayers[index].setText("");
		lblPlayers[index].setOpaque(false);
        this.repaint();
	}
}
