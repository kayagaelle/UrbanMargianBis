package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global{
		
	
	
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	private Hashtable <Connection , Joueur> lesJoueurs = new Hashtable <Connection, Joueur>() ;
	private ArrayList  <Joueur> lesJoueursDansLordre  = new ArrayList <Joueur> ();
	private String laPhrase ; 
	
	
	public void nouveauLabelJeu (Label label){
		controle.evenementModele(this, "ajout joueur", label.getjLabel());
	}
	
	
	@Override
	public void setConnection(Connection connection) {
		lesJoueurs.put(connection , new Joueur( this));
	
			
	}

	/* (non-Javadoc)
	 * @see modele.Jeu#envoi(outils.connexion.Connection, java.lang.Object)
	 */
	
	public void envoi(Object info) {
		
		
		
		for (Connection connection: lesJoueurs.keySet()){
		super.envoi(connection ,info);
		
		}
	}

		

	@Override
	public void reception(Connection connection, Object info) {
		//System.out.println(info);  pour verifier qu'on prend bien le pseudo
		String []infos  = ((String) info).split(SEPARE);
		switch (Integer.parseInt(infos [0])){
			  
		case PSEUDO : 
			controle.evenementModele(this , "envoi panels Mur" , connection);
			for (Joueur unJoueur : lesJoueursDansLordre) {
				super.envoi(connection,unJoueur.getLabel() );
				super.envoi(connection, unJoueur.getMessage());
			}
			lesJoueurs.get(connection).initPerso(infos[1],Integer.parseInt(infos[2]) , lesJoueurs , lesMurs);
			this.lesJoueursDansLordre.add(this.lesJoueurs.get(connection));
			laPhrase = "***"+lesJoueurs.get(connection).getPseudo()+"***" ;  
			controle.evenementModele(this , "ajout phrase" , laPhrase);
			break ;
		
		case CHAT : 
			 laPhrase = lesJoueurs.get(connection).getPseudo()+">"+infos[1] ;
			controle.evenementModele(this , "ajout phrase" , laPhrase);
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
