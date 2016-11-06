package modele;



import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Global;
import vue.ChoixArene;

public class Mur extends Objet implements Global{

		
	
	// Constructeur
	public Mur (){
		posX =(int) Math.round( Math.random() *(L_ARENE-L_MUR));
		posY =(int) Math.round( Math.random()*(H_ARENE-H_MUR));
		
		super.label= new Label(-1, new JLabel());
		
		super.label.getjLabel().setHorizontalAlignment(SwingConstants.CENTER);
		super.label.getjLabel().setVerticalAlignment(SwingConstants.CENTER);
		super.label.getjLabel().setBounds(posX, posY, L_MUR, H_MUR);
		
		
		if (ChoixArene.getNumArene() == 1 ){
			super.label.getjLabel().setIcon(new ImageIcon(MUR));
		}
		if (ChoixArene.getNumArene() == 2 ){
			super.label.getjLabel().setIcon(new ImageIcon(PYRAMIDE));
		}
		if (ChoixArene.getNumArene() == 3 ){
			super.label.getjLabel().setIcon(new ImageIcon(BON));
		}
		if (ChoixArene.getNumArene() == 4 ){
			super.label.getjLabel().setIcon(new ImageIcon(ARBRE));
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
