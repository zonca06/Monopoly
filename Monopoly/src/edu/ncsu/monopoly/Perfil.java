package edu.ncsu.monopoly;

import javax.swing.ImageIcon;

public class Perfil implements java.io.Serializable {
// necesitamos seleccionar el color
	//subir una foto
	//nombre
	//partidos jugados
	//partidos ganados
	
	private String nombreDeUsuario;
	private String contraseña;
	private String colorFicha;
	int partidosJugados=0;	
	int partidosGanados=0;
	ImageIcon imagen;
	
		
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	public String getColorFicha() {
		return colorFicha;
	}
	public void setColorFicha(String colorFicha) {
		this.colorFicha = colorFicha;
	}
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getContraseña() {
		return contraseña;
	}
	
	public boolean equals(Object o){
		Perfil aux = (Perfil)o;
			return this.getNombreDeUsuario().equals(aux.getNombreDeUsuario());
		
	}
	public String toString(){
		
		return this.getNombreDeUsuario()+ " - PJ: "+this.getPartidosJugados()+ " - PG: "+ this.getPartidosGanados(); 	
	}


}
