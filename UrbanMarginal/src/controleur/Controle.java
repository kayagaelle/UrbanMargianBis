package controleur;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;


import java.util.*;

import javax.swing.JFrame;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;



public class Controle {
	
	private EntreeJeu  frmEntreeJeu ;
	private Jeu leJeu ;
	private Arene frmArene ;
	private ChoixJoueur frmChoixJoueur ; 
	
	
	public static void main(String[] args) {
		new Controle ();
		
	}
	// Constructeur 
	public Controle (){
		this.frmEntreeJeu = new EntreeJeu(this); // 
		frmEntreeJeu.setVisible(true);
		
	}
	
	public void evenementVue (JFrame uneFrame ,Object info ) { // methode qui recoit en param uneframe de type Jframe et info de type objet 
		if (uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
	}
	private void evenementEntreeJeu(Object info) {
		
		System.out.print((String)info);
		if ((String)info == "serveur"){
			
			new ServeurSocket (this , 6666);
			leJeu = new JeuServeur (this);
			frmEntreeJeu.dispose();
			frmArene = new Arene ();
			frmArene.setVisible(true);
			
			
			
		}else {
			
	     (new ClientSocket ((String)info , 6666 , this)).isConnexionOk(); // ((String) info) : on a caster info en string
	        leJeu = new JeuClient(this) ; 
	        frmArene = new Arene ();
	        frmEntreeJeu.dispose();
	        frmChoixJoueur = new ChoixJoueur ();
			frmChoixJoueur.setVisible(true);
	     
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
