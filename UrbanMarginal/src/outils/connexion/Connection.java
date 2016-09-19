package outils.connexion;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread {
	
	//Déclaration de propriétés 
	
	private Object leRecepteur ;
	private ObjectOutputStream In ;
	private ObjectOutputStream Out ;
	
	
	
	// Consttructeur de la classe Connection
	public Connection (Socket socket , Object leRecepteur){
		
		//valorisation de la propriété leRecpeteur dans le constructeur
		this.leRecepteur=leRecepteur ;
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
