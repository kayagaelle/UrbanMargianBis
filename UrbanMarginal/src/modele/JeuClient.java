package modele;

import javax.swing.JPanel;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuClient extends Jeu{
	private Connection connection ;
	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection ;
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		if (info instanceof JPanel){
			controle.evenementModele(this, "ajout panels Mur", info);
		}
		if (info instanceof Label){
			controle.evenementModele(this, "ajout joueur", info);
		}
		if (info instanceof String){
			controle.evenementModele(this, "remplace chat", info);
		}
		
	}
	

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	 
	
	public JeuClient (Controle controle){
		super.controle = controle ;
	}
	
	public void envoi (Object info){
		super.envoi(connection,info);
	}
	

	
}
