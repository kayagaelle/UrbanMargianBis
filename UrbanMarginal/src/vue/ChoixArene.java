package vue;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;
import controleur.Global;
import outils.son.Son;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ChoixArene extends JFrame implements Global{
    
	//proprietes 
	
		private JPanel contentPane;
	
		private static int numArene ;
		public static int getNumArene() {
			return numArene;
		}


		private JLabel lblArene ;
		private Controle controle ;
		private Son precedent ;
		private Son suivant ;
		private Son go ;
		private Son welcome ;
		// methodes 
		
	private void afficheArene(){
			lblArene.setIcon(new ImageIcon(FONDARENE+numArene+JPG));
			
		}
		
		
		
		private void souris_normale(){
			contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			
		}
		private void souris_doigt(){
			contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
		}
		
		private void lblPrecedent_clic() {
			precedent.play();
			numArene--;
			if(numArene <= 0){
				numArene = NBARENE;
			}
				afficheArene();
		}

		private void lblSuivant_clic() {
			suivant.play();
			if(numArene == 4){
				numArene = 0;
			}
				numArene++;
				afficheArene();
		}
			/*for (numPerso=0 ; numPerso <= NBPERSOS ; numPerso++ ){
				affichePerso();
			}*/
		
		private void lblGo_clic(){ 
	
				go.play();
				controle.evenementVue(this,numArene);
				
			}
			
		
		/**
		 * Create the frame.
		 */
		public ChoixArene(Controle controle) {
			setTitle("Choicx Arene");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 416, 313);
			contentPane = new JPanel();
		
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblPrecedent = new JLabel("");
			lblPrecedent.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblPrecedent_clic();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					souris_doigt();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					souris_normale();
				}
			});
			
			lblPrecedent.setBounds(57, 145, 52, 47);
			contentPane.add(lblPrecedent);
			
			JLabel lblSuivant = new JLabel("");
			lblSuivant.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblSuivant_clic();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					souris_doigt();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					souris_normale();
				}
			});
			lblSuivant.setBounds(289, 145, 46, 47);
			contentPane.add(lblSuivant);
			
			JLabel lblGo = new JLabel("");
			lblGo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblGo_clic();
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					souris_doigt();
				}
				@Override
				public void mouseExited(MouseEvent e) {
					souris_normale();
				}
			});
			lblGo.setBounds(316, 203, 52, 47);
			contentPane.add(lblGo);
			
			
			
			lblArene = new JLabel("");
			lblArene.setHorizontalAlignment(SwingConstants.CENTER);
			lblArene.setBounds(144, 113, 117, 119);
			contentPane.add(lblArene);
			
			JLabel lblFond = new JLabel("");
			lblFond.setBounds(0, 0, 400, 275);
			lblFond.setIcon(new ImageIcon(FONDCHOIXARENE));
				
			contentPane.add(lblFond);
			
		
			numArene = 1 ;
			afficheArene();
			this.controle =controle;
			this.precedent = new Son (SONPRECEDENT) ;
			this.suivant = new Son (SONSUIVANT) ;
			this.go  =new Son (SONGO);
			this.welcome = new Son (SONWELCOME) ;
			this.welcome.play();
			this.go =  new Son (SONGO);
		}
		
}
