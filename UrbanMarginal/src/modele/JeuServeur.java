package modele;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuServeur extends Jeu{

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
	
	
	
	
	
	public JeuServeur (Controle controle){
		super.controle = this.controle ;
		
	}

}
