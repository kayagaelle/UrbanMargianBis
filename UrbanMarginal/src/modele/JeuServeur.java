package modele;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global{

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		
		System.out.println(info);
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public JeuServeur (Controle controle){
		super.controle = controle ;
		
	}

}
