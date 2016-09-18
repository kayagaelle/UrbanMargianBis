package controleur;
import vue.EntreeJeu;
import java.util.*;

import javax.swing.JFrame;
public class Controle {
	private EntreeJeu  frmEntreeJeu ;
	
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
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
