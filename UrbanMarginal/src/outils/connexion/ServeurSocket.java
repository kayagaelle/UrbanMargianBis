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
				System.out.println("Erreur grave de cr�ation socket serveur : "+e);
				System.exit(0);
			}
			// appelle de la m�thode start de la classe m�re donc : 
		    super.start();
		    
		    
		}
		
		public void run(){
			Socket socket  ;			
			while (true) {
				try {
					System.out.println("Le serveur attend");
					socket = this.serverSocket.accept();
					System.out.println("Un client s'est connect�");
					 new Connection (socket , this.leRecepteur);
					
				} catch (IOException e) {
					System.out.println("Le sokcet/client � un probl�me : "+e);
					System.exit(0);
				}
			}
		}
			
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
