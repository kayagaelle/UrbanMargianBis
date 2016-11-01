package controleur;
import vue.Arene;
import vue.ChoixArene;
import vue.ChoixJoueur;
import vue.EntreeJeu;
 

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import modele.Label; 
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;



public class Controle implements Global {
	
	private EntreeJeu  frmEntreeJeu ;
	private Jeu leJeu ;
	private Arene frmArene ;
	private ChoixJoueur frmChoixJoueur ; 
	private ChoixArene frmChoixArene ;
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
		if (unJeu instanceof JeuClient){
			evenementJeuClient(ordre , info);
		}
	}
	
	private void evenementJeuClient (String ordre , Object info){
			
		if (ordre =="ajout panels Mur"){
			
			frmArene.ajoutPanelMurs((JPanel)info);
		}
		if (ordre =="ajout joueur"){
			
			frmArene.ajoutModifJoueur(((Label)info).getNumLabel(), ((Label)info).getjLabel()); 
		}
	if (ordre =="remplace chat"){
			
			frmArene.remplaceChat((String)info) ;
		}
	if (ordre =="son"){
		
		
		frmArene.JoueSon((Integer)info) ;
	}	
		
		
		
	}
	
	private void evenementJeuServeur(String ordre, Object info) {
		if (ordre =="ajout Mur"){
			
			frmArene.ajoutMur((JLabel)info);
		}
		if (ordre =="envoi panels Mur"){
			
			((modele.JeuServeur)this.leJeu).envoi((Connection)info ,  frmArene.getJpnMurs());
			
			}
		if (ordre =="ajout joueur"){
				
				frmArene.ajoutJoueur((JLabel)info) ;
				
				}
		if (ordre =="ajout phrase"){
			
			frmArene.ajoutChat((String)info) ;
			
			((modele.JeuServeur)this.leJeu).envoi( frmArene.getTxtChat());
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
	public void deconnection (Connection connection){
		leJeu.deconnection(connection);
		
	}
	
	public void evenementVue (JFrame uneFrame ,Object info ) { 
		if (uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
		if (uneFrame instanceof ChoixJoueur){
			evenementChoixJoueur(info);
		}
		if (uneFrame instanceof ChoixArene){
			evenementChoixArene(info);
		}
		if (uneFrame instanceof Arene){
			evenementArene(info);
			
		}
	
	}
	
	private void  evenementArene(Object info){
		((modele.JeuClient)this.leJeu).envoi(info);
		
		
	}
	private void  evenementChoixArene(Object info){
		((modele.JeuServeur)this.leJeu).envoi(info);
		frmArene = new Arene ("serveur",this);
		((modele.JeuServeur)this.leJeu).constructionMurs ();
		frmArene.setVisible(true);
		frmChoixArene.dispose();
		
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
			frmChoixArene = new ChoixArene (this);
			frmChoixArene.setVisible(true);
		
			

			
		}else {
			
	     (new ClientSocket ((String)info , PORT , this)).isConnexionOk(); // ((String) info) : on a caster info en string
	        leJeu = new JeuClient(this) ; 
	        leJeu.setConnection(connection);
	        frmArene = new Arene ("client",this);
	        frmEntreeJeu.dispose();
	        frmChoixJoueur = new ChoixJoueur(this);
			frmChoixJoueur.setVisible(true);
			
			
	     
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
