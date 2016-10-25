package modele;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.io.Serializable;
import controleur.Global;
import outils.connexion.Connection;

import java.util.ArrayList;
import java.util.Hashtable;

public class Boule extends Objet implements Global  {
	
	
	private JeuServeur jeuServeur;


	public Boule(JeuServeur jeuServeur){
		
		this.jeuServeur = jeuServeur;
		super.label = new Label (Label.nbLabel++, new JLabel ());
		//super.label.setNbLabel(Label.getNbLabel()+1) ;
		super.label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		super.label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
		super.label.getjLabel().setBounds(0, 0, L_BOULE, H_BOULE);
		super.label.getjLabel().setIcon(new ImageIcon(BOULE));
		jeuServeur.nouveauLabelJeu(super.label);
		super.label.getjLabel().setVisible(false);
		
		
	}

	public void tireBoule(Joueur attaquant, ArrayList<Mur>lesMurs, Hashtable<Connection, Joueur> lesJoueurs){
		if(attaquant.getOrientation() == GAUCHE){
			attaquant.getBoule().setPosX(attaquant.getPosX()-L_BOULE-1);
		}else{
			attaquant.getBoule().setPosX(attaquant.getPosX()+L_PERSO+1);
		}
		attaquant.getBoule().setPosY(attaquant.getPosY()+(H_PERSO/2));
		new Attaque(attaquant, jeuServeur, lesMurs, lesJoueurs);
	}	
	

}
