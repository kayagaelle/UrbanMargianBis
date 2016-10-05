package controleur;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;


import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;



public class Controle implements Global {
	
	private EntreeJeu  frmEntreeJeu ;
	private Jeu leJeu ;
	private Arene frmArene ;
	private ChoixJoueur frmChoixJoueur ; 
	private Connection connection ;
	
	public static void main(String[] args) {
		new Controle ();
		
	}
	// Constructeur 
	public Controle (){
		this.frmEntreeJeu = new EntreeJeu(this); // 
		frmEntreeJeu.setVisible(true);
		
	}
	
	public void evenementModele (Object unJeu , String ordre ,Object info){
		if( unJeu instanceof JeuServeur ){
			evenementJeuServeur(ordre , info);
		}
	}
	
	private void evenementJeuServeur(String ordre, Object info) {
		if (ordre =="ajout Mur"){
			
			frmArene.ajoutMur((JLabel)info);
		}
		
	}
	public void receptionInfo (Connection connection , Object info){
		
		this.leJeu.reception(connection ,info);
	}
	
	public void setConnection(Connection connection){
		this.connection = connection ;
		if(leJeu instanceof JeuServeur){
			leJeu.setConnection(connection);
		}
	}
	
	public void evenementVue (JFrame uneFrame ,Object info ) { // methode qui recoit en param uneframe de type Jframe et info de type objet 
		if (uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
		if (uneFrame instanceof ChoixJoueur){
			evenementChoixJoueur(info);
		}
		}
	
	private void evenementChoixJoueur(Object info){
		//System.out.println("envoi..."+info);
		((modele.JeuClient)this.leJeu).envoi(info);
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
	}
	private void evenementEntreeJeu(Object info) {
		
		//System.out.println((String)info);
		if ((String)info == "serveur"){
			
			new ServeurSocket (this , PORT);
			leJeu = new JeuServeur (this);
			frmEntreeJeu.dispose();
			frmArene = new Arene ();
			((modele.JeuServeur)this.leJeu).constructionMurs ();
		
			frmArene.setVisible(true);
			

			
		}else {
			
	     (new ClientSocket ((String)info , PORT , this)).isConnexionOk(); // ((String) info) : on a caster info en string
	        leJeu = new JeuClient(this) ; 
	        leJeu.setConnection(connection);
	        frmArene = new Arene ();
	        frmEntreeJeu.dispose();
	        frmChoixJoueur = new ChoixJoueur(this);
			frmChoixJoueur.setVisible(true);
	     
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
