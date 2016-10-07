package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global{
		
	
	
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	private Hashtable <Connection , Joueur> lesJoueurs = new Hashtable <Connection, Joueur>() ;
	
	
	public void nouveauLabelJeu (Label label){
		controle.evenementModele(this, "ajout joueur", label.getjLabel());
	}
	
	
	@Override
	public void setConnection(Connection connection) {
		lesJoueurs.put(connection , new Joueur( this));
	
			
	}

	@Override
	public void reception(Connection connection, Object info) {
		//System.out.println(info);  pour verifier qu'on prend bien le pseudo
		String []infos  = ((String) info).split(SEPARE);
		switch (Integer.parseInt(infos [0])){
			  
		case PSEUDO : 
			controle.evenementModele(this , "envoi panels Mur" , connection);
			lesJoueurs.get(connection).initPerso(infos[1],Integer.parseInt(infos[2]) , lesJoueurs , lesMurs);
			
			
			break ;
		
		
		
		
		
		}
		
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}
	
	public void constructionMurs (){
		int i ;
		for (i=0 ; i <= NBMURS ; i++){
			lesMurs.add(new Mur());
			
			controle.evenementModele(this , "ajout Mur" ,lesMurs.get(i).getLabel().getjLabel()); // on recup le mur i puis on passe par Label pour getjLabel
		}
	}
	
	
	
	
	//Constructeur
	public JeuServeur (Controle controle){
		super.controle = controle ;
		 Label.setNbLabel(0);
		
	}

}
