package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private Controle controle ;
	
	private JTextField txtIP;

	
	

	
	
	private void btnStart_clic(){ 
		controle.evenementVue(this, "serveur");

	}
	
	
	private void btnConnect_clic(){
		controle.evenementVue(this,txtIP.getText());
	}
	private void btnExit_clic(){
		System.exit(0);
	}
	/**
	 * Create the frame.
	 * @param controle 
	 */
	public EntreeJeu(Controle controle) {
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblS = new JLabel("Start a server");
		lblS.setBounds(27, 38, 94, 14);
		contentPane.add(lblS);
		
		JLabel lblConnectAnExisting = new JLabel("Connect an existing server :");
		lblConnectAnExisting.setBounds(27, 82, 194, 14);
		contentPane.add(lblConnectAnExisting);
		
		JLabel lblIpServer = new JLabel(" IP Server :");
		lblIpServer.setBounds(27, 122, 94, 14);
		contentPane.add(lblIpServer);
		
	
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(130, 117, 89, 22);
		contentPane.add(textArea);
		
		JButton btnStart = new JButton("Start"); // titre ecrit sur le bouton
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnStart_clic();
			}
		});
		
		btnStart.setBounds(229, 34, 89, 23);
		contentPane.add(btnStart);
		
		
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_clic();
			}
		});
		btnConnect.setBounds(229, 118, 89, 23);
		contentPane.add(btnConnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit_clic();
			}
		});
		btnExit.setBounds(229, 163, 89, 23);
		contentPane.add(btnExit);
		
		txtIP = new JTextField();
		txtIP.setText("127.0.0.1");
		txtIP.setBounds(131, 119, 86, 20);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		this.controle=controle;
	}
}