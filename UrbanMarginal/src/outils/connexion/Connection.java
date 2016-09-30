package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Connection extends Thread {
	
	//D�claration de propri�t�s 
	
	private Object leRecepteur ;
	private ObjectInputStream in ;
	private ObjectOutputStream out ;
	public boolean inOk = true;

	
	
	// Consttructeur de la classe Connection
	public Connection (Socket socket , Object leRecepteur){
		
		//valorisation de la propri�t� leRecpeteur dans le constructeur
		this.leRecepteur=leRecepteur ;
		
		try {
			out = new ObjectOutputStream (socket.getOutputStream()) ;
		} catch (IOException e) {
			System.out.println("Erreur de socket  : "+e);
			System.exit(0);
		}
		
		try {
			in = new ObjectInputStream (socket.getInputStream()) ;
		} catch (IOException e) {
			System.out.println("Erreur de socket  : "+e);
			System.exit(0);
		}
		super.start();
		((controleur.Controle)this.leRecepteur).setConnection(this);
		
		}
	
	
		public void run (){
			 Object reception;
			boolean inOK=true ;
			while (inOk){
				
					try {
						
						
						reception = in.readObject() ;
						((controleur.Controle)this.leRecepteur).receptionInfo(this ,reception);
						
						
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
						System.out.println("La r�cup�ration n'est pas au format objet : "+e);
						System.exit(0);
						
					} catch (IOException e) {
							
						e.printStackTrace();
					JOptionPane.showMessageDialog (null , "l'ordinateur distant s'est d�connect�");
						inOk = false ;
						
						try {
							in.close();
						} catch (IOException e1) {
							
							e1.printStackTrace();
							System.out.println("canal ferm�: "+e);
						}
					}
					
				}
			
			}
		
		
			
			
			public void envoi (Object unObject){
				
				try {
					//System.out.println("connection"+unObject);
					out.writeObject(unObject);
					out.flush();
				} catch (IOException e) {
					
					e.printStackTrace();
					System.out.println("Erreur sur l'objet out"+e);
				}
			}

			

			
		

		
		
		
		
		
		
		
		
		
	



	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

