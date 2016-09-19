package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection extends Thread {
	
	//Déclaration de propriétés 
	
	private Object leRecepteur ;
	private ObjectInputStream in ;
	private ObjectOutputStream out ;
	public boolean inOk = true;
	
	
	// Consttructeur de la classe Connection
	public Connection (Socket socket , Object leRecepteur){
		
		//valorisation de la propriété leRecpeteur dans le constructeur
		this.leRecepteur=leRecepteur ;
		
		try {
			out = new ObjectOutputStream (socket.getOutputStream()) ;
		} catch (IOException e) {
			System.out.println("Erreur de socket  : "+e);
			System.exit(0);
		}
		
		try {
			in = new ObjectInputStream (socket.getInputStream()) ;
		} catch (IOException e) {
			System.out.println("Erreur de socket  : "+e);
			System.exit(0);
		}
		super.start();
		
		}
	
		public void run (boolean inOk ){
			
		}
		
		
		
		
		
		
		
		
	



	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

