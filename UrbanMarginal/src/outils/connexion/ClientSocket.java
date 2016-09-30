package outils.connexion;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientSocket {

	private boolean connexionOk ;
	
	public ClientSocket( String ip , int port , Object leRecepteur  ){
		
		
		connexionOk = false ;
		Socket socket ; 
		try {
			socket = new Socket (ip , port );
			System.out.println("La connexion au serveur a réussi");
			this.connexionOk = true ;
			new Connection (socket , leRecepteur);
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null ,  "Le serveur n'est pas disponible");
			
		} catch (IOException e) {
		
			e.printStackTrace();
			JOptionPane.showMessageDialog(null ,  "Problème entrée/sortie (ex : IP incorrecte)");
		}
		
		
		
		
		
	}

	/**
	 * @return the connexionOk
	 */
	public boolean isConnexionOk() {
		return connexionOk;
	}
	
	public void setConnexionOk (boolean connexionOk){
		this.connexionOk = connexionOk ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
