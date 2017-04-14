package edu.ncsu.monopoly;

import java.util.ArrayList;

public class ManejadorComienzoPartida {
	private static  ManejadorComienzoPartida manPerf;
	private ArrayList<Perfil> listaDePerfilesNoSeleccionados;
	private ArrayList<Perfil> listaDePerfilesPersistidos;
	private ArrayList<Perfil> listaDePerfilesSeleccionados;

	
	public ArrayList<Perfil> getListaDePerfilesNoSeleccionados() {
		return listaDePerfilesNoSeleccionados;
	}
	public void setListaDePerfilesNoSeleccionados(ArrayList<Perfil> listaDePerfilesNoSeleccionados) {
		this.listaDePerfilesNoSeleccionados = listaDePerfilesNoSeleccionados;
	}
	public ArrayList<Perfil> getListaDePerfilesPersistidos() {
		return listaDePerfilesPersistidos;
	}
	public void setListaDePerfilesPersistidos(ArrayList<Perfil> listaDePerfilesPersistidos) {
		this.listaDePerfilesPersistidos = listaDePerfilesPersistidos;
	}
	public ArrayList<Perfil> getListaDePerfilesSeleccionados() {
		return listaDePerfilesSeleccionados;
	}
	public void setListaDePerfilesSeleccionados(ArrayList<Perfil> listaDePerfilesSeleccionados) {
		this.listaDePerfilesSeleccionados = listaDePerfilesSeleccionados;
	}
	
	
	public static ManejadorComienzoPartida instance() {
		if(manPerf == null) {
			manPerf = new ManejadorComienzoPartida();
		}
		return manPerf;
	}

	private ManejadorComienzoPartida() {		
		// cuando se haga la persistencia la lista de no seleccionados se
		//debera cargar con la de persistidos        this.listaDePerfilesNoSeleccionados = new ArrayList<Perfil>() ;
        this.listaDePerfilesPersistidos = new ArrayList<Perfil>() ;
        this.listaDePerfilesSeleccionados = new ArrayList<Perfil>() ;
	}
	
	
}
