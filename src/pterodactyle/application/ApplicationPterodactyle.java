
package pterodactyle.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.echangeable.ExceptionEchangeablePasDeTag;
import pterodactyle.echangeable.ExceptionEchangeableTagExistant;
import pterodactyle.rmi.Client2;
import pterodactyle.utilisateur.AdministrateurException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JPasswordField;

public class ApplicationPterodactyle {

	private JFrame frameConnection;
	private JTextField textFieldLogin;
	private boolean estConnecte = false;
	private String loginCourant;
	private String motDePasseCourant;
	private JPasswordField passwordFieldMdp;
	private static _ServicesCoeur app;

	/**
	 * Launch the application.
	 * @throws RemoteException 
	 * @throws ExceptionEchangeablePasDeTag 
	 * @throws ExceptionEchangeableMauvaisType 
	 * @throws ExceptionEchangeableTagExistant 
	 * @throws AdministrateurException 
	 */
	public static void main(String[] args) throws RemoteException, ExceptionEchangeableMauvaisType, ExceptionEchangeablePasDeTag, AdministrateurException, ExceptionEchangeableTagExistant {
		Client2 client = new Client2("127.0.0.1");
		app = client.recupererApp();
		app.creerTag("compta", "admin", "admin");
		app.creerTag("economie", "admin", "admin");
		app.creerPost("p1", "toto", "compta", "admin", "admin");
		//System.out.println(app.test());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationPterodactyle window = new ApplicationPterodactyle();
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
	public ApplicationPterodactyle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConnection = new JFrame();
		frameConnection.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		frameConnection.setForeground(new Color(11, 29, 62));
		frameConnection.setTitle("Connection");
		frameConnection.setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationPterodactyle.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		frameConnection.getContentPane().setBackground(new Color(244, 244, 243));
		frameConnection.setBounds(100, 100, 345, 317);
		frameConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConnection.getContentPane().setLayout(null);

		textFieldLogin = new JTextField();
		textFieldLogin.setForeground(new Color(11,29,62));
		textFieldLogin.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		textFieldLogin.setBounds(86, 75, 150, 20);
		frameConnection.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		passwordFieldMdp = new JPasswordField();
		passwordFieldMdp.setForeground(new Color(11,29,62));
		passwordFieldMdp.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		passwordFieldMdp.setBounds(86, 137, 150, 20);
		frameConnection.getContentPane().add(passwordFieldMdp);

		JLabel lblLogin = new JLabel("Entrez votre login :");
		lblLogin.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblLogin.setBounds(86, 44, 128, 20);
		lblLogin.setForeground(new Color(11, 29, 62));
		frameConnection.getContentPane().add(lblLogin);

		JLabel lblMdp = new JLabel("Entrez votre mot de passe :");
		lblMdp.setForeground(new Color(11, 29, 62));
		lblMdp.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblMdp.setBounds(86, 106, 185, 20);
		frameConnection.getContentPane().add(lblMdp);

		JButton btnConnection = new JButton("Se connecter");
		btnConnection.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				char[] password = passwordFieldMdp.getPassword();
				String mdp = new String(password);
					try {
						estConnecte = app.seConnecter(login, mdp);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(estConnecte == true){
						loginCourant = login;
						motDePasseCourant = mdp;
						System.out.println("Correct");
						
						frameConnection.dispose();
						ApplicationUtilisateur acc = new ApplicationUtilisateur(app, mdp, mdp);
						acc.setVisible(true);
					}else{
						textFieldLogin.setBackground(new Color(255, 0, 0));
						passwordFieldMdp.setBackground(new Color(255, 0, 0));
						System.out.println("Incorrect");
					}
			}
		});

		btnConnection.setForeground(new Color(255, 255, 255));
		btnConnection.setBackground(new Color(11, 29, 62));
		btnConnection.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		btnConnection.setBounds(86, 187, 150, 34);
		// btnConnection.setBorder(new RoundedBorder(10));

		frameConnection.getContentPane().add(btnConnection);
		
		
	}
}

