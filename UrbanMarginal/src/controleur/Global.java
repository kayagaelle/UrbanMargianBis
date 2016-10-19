package controleur;

public interface Global {


	  int PORT = 6666; 
	String SEPARATOR = "/" ;
	 String CHEMIN = "media"+ SEPARATOR ;
	String  CHEMINFONDS = CHEMIN+"fonds"+SEPARATOR;
	String  FONDCHOIX = CHEMINFONDS + "fondchoix.jpg"	;
	
	int GAUCHE = 0;     // direction
	int DROITE = 1;     // direction 
	int HAUT = 2; 
	int BAS = 3; 
 	String CHEMINPERSOS = CHEMIN+"personnages"+SEPARATOR; 
	String PERSO = CHEMINPERSOS +"perso";
	String EXTIMAGE=".gif";
	String MARCHE = "marche";
	String BLESSE="blesse";
	String MORT ="mort";
	int TIR = 4 ; 
	int ACTION = 2 ; 
	int NBPERSOS = 3;     //nb perosnnages
	int H_PERSO = 44;    // taille hauteur personnage
	int L_PERSO = 39 ;   // "" largeur ""
	String SEPARE = "~";
	int PSEUDO = 0;
	int H_ARENE = 600;
	int L_ARENE =800;
	int H_CHAT = 200;
	int H_SAISIE =25;
	int MARGE =5;
	String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	int NBMURS = 20 ;
	String CHEMINMURS = CHEMIN+"murs"+SEPARATOR;
	String MUR = CHEMINMURS+"mur.gif"; // image du mur
	int H_MUR = 35;
	int L_MUR = 34 ;
	int H_MESSAGE = 8;
	int CHAT=1;
	int NBETATSMARCHE =4;
	int LEPAS = 10 ; 
	
	
	
	
	
}
