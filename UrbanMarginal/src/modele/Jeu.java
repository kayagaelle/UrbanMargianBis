package modele;

import controleur.Controle;
import outils.connexion.Connection;

public abstract class Jeu {

	
	protected Controle controle ; 
	
	abstract public  void setConnection (Connection connection ); // a verifier si c'est bien un void 
	abstract public void reception (Connection connection , Object info);
	abstract public void deconnection (Connection connection);
	
	public void envoi (Connection connection, Object info) {
		  connection.envoi(info);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
