package edu.ncsu.monopoly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class Serializar {

	private static  Serializar serializador;
	
	public static Serializar instance() {
		if(serializador == null) {
			serializador = new Serializar();
		}
		return serializador;
	}
	
	private Serializar(){}
	
	public void guardar(){
		
		try{
	        
		      //archivo local
           
            
            
    //        java.net.URL url = getClass().getResource("datosSerializados.ser");
      //      System.out.println(url.getPath());
         //   FileOutputStream fileOut = new FileOutputStream(url.getPath()); 


        // archivo de propiedades desde donde está el jar
        
        File jarPath=new File(GameMaster.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String rutaArchivoSerializado=jarPath.getParentFile().getAbsolutePath();
        FileOutputStream fileOut = new FileOutputStream(rutaArchivoSerializado+"/datosSerializados.ser");
			
	         
	         
	                 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	                 out.writeObject(ManejadorComienzoPartida.instance().getListaDePerfilesPersistidos());
	                 out.close();
	                 fileOut.close();
	                
	         
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
		
	}
	public ArrayList<Perfil> obtenerUsuarios(){
		 try {
			 
			   //archivo local
//			 java.net.URL url = getClass().getResource("datosSerializados.ser");
//	            System.out.println(url.getPath());
//			 
//			 
//	            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//	            FileInputStream fileIn = new FileInputStream(url.getPath());
//	            String urlArchivo=url.getPath();


	        // archivo de propiedades desde donde está el jar
	        
	       File jarPath=new File(GameMaster.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	       String rutaArchivoSerializado=jarPath.getParentFile().getAbsolutePath();
	       FileInputStream fileIn = new FileInputStream(rutaArchivoSerializado+"/datosSerializados.ser");
	          String urlArchivo=rutaArchivoSerializado+"/datosSerializados.ser";	 
		 
		
	            
	            
	            
	          
	            
	          //verifico si hay algo en el archivo 
	            BufferedReader br = new BufferedReader(new FileReader(urlArchivo));     
	            if (br.readLine() != null) {
	                
	            
			 
	         
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         ArrayList<Perfil> listaDePerfilesPersistidos  = (ArrayList<Perfil>) in.readObject();
	         in.close();
	         fileIn.close();
	         
          return listaDePerfilesPersistidos;
	      }else{
	    	  //si no hay nada retorno una lista vacía
	    	  return new ArrayList<Perfil>();
	      }
	            
	            
	            
	      }catch(IOException i) {
	         i.printStackTrace();
	         return new ArrayList<Perfil>();
	      }catch(ClassNotFoundException c) {
	         System.out.println("No se encontraron los usuarios");
	         c.printStackTrace();
	         return new ArrayList<Perfil>();
	      }catch(Exception ex){
	    	  
	    	  return new ArrayList<Perfil>();
	      }

		
	}
	
}
