package pterodactyle.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class applicationPterodactyle {

	private JFrame frameConnection;
	private JTextField textFieldLogin;
	private JTextField txtFieldMdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frameConnection.getContentPane().setBackground(new Color(244,244,243));
		frameConnection.setBounds(100, 100, 389, 391);
		frameConnection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConnection.getContentPane().setLayout(null);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(114, 100, 150, 20);
		frameConnection.getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Entrez votre login :");
		lblLogin.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblLogin.setBounds(114, 69, 128, 20);
		lblLogin.setForeground(new Color(11,29,62));
		frameConnection.getContentPane().add(lblLogin);
		
		txtFieldMdp = new JTextField();
		txtFieldMdp.setColumns(10);
		txtFieldMdp.setBounds(114, 166, 150, 20);
		frameConnection.getContentPane().add(txtFieldMdp);
		
		JLabel lblMdp = new JLabel("Entrez votre mot de passe :");
		lblMdp.setForeground(new Color(11,29,62));
		lblMdp.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblMdp.setBounds(114, 135, 185, 20);
		frameConnection.getContentPane().add(lblMdp);
		
		JButton btnConnection = new JButton("Se connecter");
		btnConnection.setForeground(new Color(255, 255, 255));
		btnConnection.setBackground(new Color(11,29,62));
		btnConnection.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		btnConnection.setBounds(127, 228, 122, 34);
		//btnConnection.setBorder(new RoundedBorder(10));

		frameConnection.getContentPane().add(btnConnection);
	}
}
