package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Connection extends Thread {
	
	//Déclaration de propriétés 
	
	private Object leRecepteur ;
	private ObjectInputStream in ;
	private ObjectOutputStream out ;
	public boolean inOk = true;
	public Object reception;
	
	
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
			
			while (inOk == true){
				
					try {
						reception = in.readObject() ;
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
						System.out.println("La récupération n'est pas au format objet : "+e);
						System.exit(0);
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog (null , "l'ordinateur distant s'est déconnecté");
						inOk = false ;
						try {
							in.close();
						} catch (IOException e1) {
							
							e1.printStackTrace();
							System.out.println("canal fermé: "+e1);
						}
					}
				} 
			}

			
		

		
		
		
		
		
		
		
		
		
	



	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

