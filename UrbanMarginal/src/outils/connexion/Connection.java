package outils.connexion;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread {
	
	//D�claration de propri�t�s 
	
	private Object leRecepteur ;
	private ObjectOutputStream In ;
	private ObjectOutputStream Out ;
	
	
	
	// Consttructeur de la classe Connection
	public Connection (Socket socket , Object leRecepteur){
		
		//valorisation de la propri�t� leRecpeteur dans le constructeur
		this.leRecepteur=leRecepteur ;
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
