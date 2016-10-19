package modele;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;
import outils.connexion.Connection;

public class Joueur extends Objet implements Global {
	
	// propriété
	
	private String pseudo ;
	private int numPerso ;
	private Label message ;
	private JeuServeur jeuServeur ;
	private int vie ;
	private int orientation ;  // tournea droite = 1 et gauche= 0
	private int etape ;  // num de l'étape dans l'animation 
	
	
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	/**
	 * @return the message
	 */
	public Label getMessage() {
		return message;
	}

	//constructeur
	public Joueur(JeuServeur jeuServeur) {
		this.jeuServeur = jeuServeur;
		vie = 10 ;
		etape = 1;
		orientation = DROITE ; 
	}
	
	private void affiche(String etat , int etape){
		label.getjLabel().setBounds(posX, posY, L_PERSO, H_PERSO);
		label.getjLabel().setIcon(new ImageIcon(PERSO+numPerso+MARCHE+etape+'d'+DROITE+EXTIMAGE));
		message.getjLabel().setBounds(posX-10 , posY + H_PERSO , L_PERSO+20 , H_MESSAGE) ; 
		message.getjLabel().setText(pseudo+" : "+vie);
		this.jeuServeur.envoi(super.label);
		this.jeuServeur.envoi(message);
		
		
	}
	
	
	public void initPerso (String pseudo , int numPerso , Hashtable <Connection , Joueur >lesJoueurs  , ArrayList<Mur>lesMurs){
		this.pseudo = pseudo;
		this.numPerso = numPerso;
		label = new Label (Label.getNbLabel() , new JLabel ());
		Label.setNbLabel(Label.getNbLabel()+1) ;
		label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);	
		jeuServeur.nouveauLabelJeu(label);
		message = new Label (Label.getNbLabel() , new JLabel ());
		message.setNbLabel(Label.getNbLabel()+1) ;
		message.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		message.getjLabel().setFont(new Font ("Dialog",Font.PLAIN,8));
		jeuServeur.nouveauLabelJeu(message);
		premierePosition (lesJoueurs, lesMurs) ;
		affiche (MARCHE , etape);
		
		
		
	}

	private boolean toucheJoueur(Hashtable <Connection , Joueur >lesJoueurs ){
		// pour chaque objet 
		for (Joueur unJoueur : lesJoueurs.values()){
			if (!unJoueur.equals(this)){
				if (super.toucheObjet(unJoueur)){
				return true ;
			}
		}	
	}
	return false ;
	}
	
	private boolean toucheMur (ArrayList<Mur> lesMurs){
		for (Mur unMur : lesMurs ){
			if (super.toucheObjet(unMur)){
			return true ;
		    }
		}
	
	return false ;
	}	

	private void premierePosition (Hashtable <Connection , Joueur >lesJoueurs, ArrayList<Mur> lesMurs ){
		label.getjLabel().setBounds(0, 0, L_PERSO, H_PERSO);
		
		do {
			posX =(int) Math.round( Math.random() *(L_ARENE-L_PERSO));
			posY =(int) Math.round( Math.random()*(H_ARENE-H_PERSO-H_MESSAGE));
			
		}while (toucheJoueur(lesJoueurs) || toucheMur(lesMurs));
		
	}
	
	
	
	
	
	
	
	
}
