package modele;

import controleur.Global;
import outils.connexion.Connection;

import java.util.ArrayList;
import java.util.Hashtable;
public class Attaque extends Thread implements Global  {

	private JeuServeur jeuServeur ;
	private Joueur attaquant ;
	private ArrayList<Mur> lesMurs;
	private Hashtable<Connection, Joueur> lesJoueurs;
	
	
	// Constructor
	public Attaque (Joueur attaquant ,JeuServeur jeuServeur ,  ArrayList<Mur> lesMurs,
			Hashtable<Connection, Joueur> lesJoueurs) {
		this.attaquant = attaquant;
		this.jeuServeur = jeuServeur;
		this.lesMurs = lesMurs;
		this.lesJoueurs = lesJoueurs;
		super.start();
	
		
		
		
	}	
	
	public void run (){
		
		attaquant.affiche(MARCHE, 1);
		Boule laboule ;
		laboule = attaquant.getBoule();
		int orientation = attaquant.getOrientation() ; 
		laboule.label.getjLabel().setVisible(true);
		Joueur victime = null ;
		
		do {
			
			if (orientation == GAUCHE ){
				
				laboule.setPosX(laboule.getPosX() - LEPAS);
			}
			else {
				
				laboule.setPosX(laboule.getPosX() + LEPAS);
				
			}
			
			laboule.label.getjLabel().setBounds(laboule.getPosX(), laboule.getPosY(), L_BOULE, H_BOULE);
			this.pause(10,00);
			jeuServeur.envoi(laboule.getLabel());
			victime = toucheJoueur();
			
		}while(laboule.getPosX() > 0 && laboule.getPosX() < L_ARENE && toucheMur() == false && victime == null );
			
		jeuServeur.envoi(HURT);
			if(victime != null && victime.estMort() == false){
				
				victime.perteVie();
				attaquant.gainVie();
				
				for(int i=1; i < NBETATSBLESSE; i++){
					victime.affiche(BLESSE, i);
					this.pause(120,00);
				}
				
				if(victime.estMort()){
					jeuServeur.envoi(DEATH);
					for(int i = 1; i < NBETATSMORT; i++){
						victime.affiche(MORT, i);
						jeuServeur.envoi(DEATH);
						this.pause(200,0);
						
					}
				}else
				{
				victime.affiche(MARCHE, 1);
				}
				
				attaquant.affiche(MARCHE, 1);
			}
			
			laboule.getLabel().getjLabel().setVisible(false);
			jeuServeur.envoi(laboule.getLabel());
		}
		
		
		
		public void pause(long milli , int nano){
			try {
				Thread.sleep(milli,nano);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private boolean toucheMur(){
			for(Mur unMur : lesMurs){
				if(attaquant.getBoule().toucheObjet(unMur)){
					return true;
				}
			}
			return false;
		}
		
		public Joueur toucheJoueur(){
			for(Joueur unJoueur : lesJoueurs.values()){
				if(attaquant.getBoule().toucheObjet(unJoueur)){
					return unJoueur;
				}
			}
			return null;
		}
}
