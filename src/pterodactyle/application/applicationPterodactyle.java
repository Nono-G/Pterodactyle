package pterodactyle.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import pterodactyle.coeur2._ServicesCoeur;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class applicationPterodactyle {

	private JFrame frameConnection;
	private JTextField textFieldLogin;
	private JTextField txtFieldMdp;
	private static _ServicesCoeur app;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String url = "rmi://127.0.0.1/app";	
		try {
			app = (_ServicesCoeur) Naming.lookup(url);
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicationPterodactyle window = new applicationPterodactyle();
					window.frameConnection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public applicationPterodactyle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConnection = new JFrame();
		frameConnection.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		frameConnection.setForeground(new Color(11,29,62));
		frameConnection.setTitle("Connection");
		frameConnection.setIconImage(Toolkit.getDefaultToolkit().getImage(applicationPterodactyle.class.getResource("/pterodactyle/application/output.png")));
		frameConnection.getContentPane().setBackground(new Color(244,244,243));
		frameConnection.setBounds(100, 100, 345, 317);
		frameConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConnection.getContentPane().setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(86, 75, 150, 20);
		frameConnection.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Entrez votre login :");
		lblLogin.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblLogin.setBounds(86, 44, 128, 20);
		lblLogin.setForeground(new Color(11,29,62));
		frameConnection.getContentPane().add(lblLogin);
		
		txtFieldMdp = new JTextField();
		txtFieldMdp.setColumns(10);
		txtFieldMdp.setBounds(86, 137, 150, 20);
		frameConnection.getContentPane().add(txtFieldMdp);
		
		JLabel lblMdp = new JLabel("Entrez votre mot de passe :");
		lblMdp.setForeground(new Color(11,29,62));
		lblMdp.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblMdp.setBounds(86, 106, 185, 20);
		frameConnection.getContentPane().add(lblMdp);
		
		JButton btnConnection = new JButton("Se connecter");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConnection.setForeground(new Color(255, 255, 255));
		btnConnection.setBackground(new Color(11,29,62));
		btnConnection.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		btnConnection.setBounds(86, 187, 150, 34);
		//btnConnection.setBorder(new RoundedBorder(10));


		frameConnection.getContentPane().add(btnConnection);
	}
}
