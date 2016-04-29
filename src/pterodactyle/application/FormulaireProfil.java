package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable._Echangeable;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class FormulaireProfil extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCreationLogin;
	private JTextField textFieldCreationMdp;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnValiderCreationProfil;
	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;
	private Map<String, _Echangeable> echangeables;

	/**
	 * Launch the application.
	 */
	public FormulaireProfil(_ServicesCoeur app, String loginCourant, String motDePasseCourant){
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		this.echangeables = new HashMap<String, _Echangeable>();
		initialisation();
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialisation() {
		setTitle("Créer un profil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormulaireProfil.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setBounds(15, 16, 90, 21);
		lblNewLabel.setBackground(new Color(244,244,243));
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(15, 57, 127, 23);
		lblMotDePasse.setForeground(new Color(11, 29, 62));
		lblMotDePasse.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblMotDePasse.setBackground(new Color(244, 244, 243));
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(15, 99, 90, 23);
		lblNom.setForeground(new Color(11, 29, 62));
		lblNom.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblNom.setBackground(new Color(244, 244, 243));
		
		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setBounds(15, 141, 90, 23);
		lblPrnom.setForeground(new Color(11, 29, 62));
		lblPrnom.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblPrnom.setBackground(new Color(244, 244, 243));
		
		textFieldCreationLogin = new JTextField();
		textFieldCreationLogin.setBounds(152, 17, 151, 22);
		textFieldCreationLogin.setForeground(new Color(11,29,62));
		textFieldCreationLogin.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationLogin.setColumns(10);
		
		textFieldCreationMdp = new JTextField();
		textFieldCreationMdp.setBounds(152, 59, 151, 22);
		textFieldCreationMdp.setForeground(new Color(11,29,62));
		textFieldCreationMdp.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationMdp.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(152, 101, 151, 22);
		textField.setForeground(new Color(11, 29, 62));
		textField.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 143, 151, 22);
		textField_1.setForeground(new Color(11, 29, 62));
		textField_1.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textField_1.setColumns(10);
		
		JButton btnAnnulerCreationProfil = new JButton("Annuler");
		btnAnnulerCreationProfil.setBounds(15, 203, 83, 25);
		btnAnnulerCreationProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnulerCreationProfil.setBackground(new Color(11,29,62));
		btnAnnulerCreationProfil.setForeground(new Color(255, 255, 255));
		btnAnnulerCreationProfil.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		btnValiderCreationProfil = new JButton("Valider");
		btnValiderCreationProfil.setBounds(341, 203, 83, 25);
		btnValiderCreationProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValiderCreationProfil.setForeground(Color.WHITE);
		btnValiderCreationProfil.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnValiderCreationProfil.setBackground(new Color(11, 29, 62));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(textFieldCreationLogin);
		contentPane.add(lblMotDePasse);
		contentPane.add(textFieldCreationMdp);
		contentPane.add(lblNom);
		contentPane.add(textField);
		contentPane.add(lblPrnom);
		contentPane.add(textField_1);
		contentPane.add(btnAnnulerCreationProfil);
		contentPane.add(btnValiderCreationProfil);
	}
}
