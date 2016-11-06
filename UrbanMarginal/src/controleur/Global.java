package controleur;

public interface Global {


	int PORT = 6666; 
	String SEPARATOR = "/" ;
	String CHEMIN = "media"+ SEPARATOR ;
	String  CHEMINFONDS = CHEMIN+"fonds"+SEPARATOR;
	String  FONDCHOIX = CHEMINFONDS + "fondchoix.jpg"	;
	String FONDCHOIXARENE = CHEMINFONDS + "fondchoixarene.jpg";
	int GAUCHE = 0;     // direction
	int DROITE = 1;     // direction 
	int HAUT = 2; 
	int BAS = 3; 
	String CHEMINPERSOS = CHEMIN+"personnages"+SEPARATOR; 
	String PERSO = CHEMINPERSOS +"perso";
	String EXTIMAGE=".gif";
	String MARCHE = "marche";
	String BLESSE="touche";
	String MORT ="mort";
	int ARENE = 5;
	int TIR = 4 ; 
	int ACTION = 2 ; 
	int NBPERSOS = 3; //nb perosnnages
	int NBARENE = 4 ;
	int H_PERSO = 44;    // taille hauteur personnage
	int L_PERSO = 39 ;   // "" largeur ""
	String SEPARE = "~";
	int PSEUDO = 0;
	int H_ARENE = 600;
	int L_ARENE =800;
	int H_CHAT = 200;
	int H_SAISIE =25;
	int MARGE =5;
	String FONDARENE = CHEMINFONDS+"fondarene";
	String JPG = ".jpg";
	int NBMURS = 20 ;
	String CHEMINMURS = CHEMIN+"murs"+SEPARATOR;
	String MUR = CHEMINMURS+"mur.gif"; // image du mur
	String ARBRE = CHEMINMURS+"arbre.gif" ; // image du mur en forme d'arbre
	String PYRAMIDE = CHEMINMURS+"pyramide.gif" ; // image du mur en forme de pyramide
	String BON = CHEMINMURS+"bon.gif" ; // image du mur en forme de bonhomme de neige
	int H_MUR = 35;
	int L_MUR = 34 ;
	int H_MESSAGE = 8;
	int CHAT=1;
	int NBETATSMARCHE =4;
	int LEPAS = 10 ; 
	int L_BOULE = 17;
	int H_BOULE = 17 ;
	String CHEMINBOULES =CHEMIN + "boules" +SEPARATOR;
	String BOULE = CHEMINBOULES + "boule.gif";
	int NBETATSBLESSE =2;
	int NBETATSMORT = 2;
	int FIGHT = 0;
	int HURT = 1;
	int DEATH = 2;
	String CHEMINSONS = CHEMIN + "sons/";
	String  SONPRECEDENT = CHEMINSONS + "precedent.wav"; // sur le clic du bouton précédent
	String SONSUIVANT = CHEMINSONS + "suivant.wav"; // sur le clic du bouton suivant
	String  SONGO = CHEMINSONS + "go.wav" ;// sur le clic du bouton go
	String  SONWELCOME = CHEMINSONS + "welcome.wav"; // à l'entrée de la frame ChoixJoueur
	String SONAMBIANCE = CHEMINSONS + "mabeaute.wav" ;// son d'ambiance dans tout
	public static final String[]
			SON = {"fight.wav", "hurt.wav", "death.wav"} ;




}
