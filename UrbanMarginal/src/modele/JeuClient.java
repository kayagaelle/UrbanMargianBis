package modele;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuClient extends Jeu{

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	 
	
	public JeuClient (Controle controle){
		super.controle = this.controle ;
	}
	
	
	

	
}
