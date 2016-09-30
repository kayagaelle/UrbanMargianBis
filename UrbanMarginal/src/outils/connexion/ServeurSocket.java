package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket extends Thread {

	private Object leRecepteur ;
	private ServerSocket serverSocket ;
	
	
	
	
		// Constructeur
		public ServeurSocket (Object leRecepteur , int port)  {
			this.leRecepteur=leRecepteur ;
			try {
				// instance de la classe ServerSocket
				serverSocket=  new ServerSocket (port);
			} catch (IOException e) {
				System.out.println("Erreur grave de création socket serveur : "+e);
				System.exit(0);
			}
			// appelle de la méthode start de la classe mère donc : 
		    super.start();
		    
		    
		}
		
		public void run(){
			Socket socket  ;			
			while (true) {
				try {
					System.out.println("Le serveur attend");
					socket = this.serverSocket.accept();
					System.out.println("Un client s'est connecté");
					 new Connection (socket , this.leRecepteur);
					
				} catch (IOException e) {
					System.out.println("Le sokcet/client à un problème : "+e);
					System.exit(0);
				}
			}
		}
			
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
