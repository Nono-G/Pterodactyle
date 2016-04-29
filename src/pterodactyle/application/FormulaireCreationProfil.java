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

public class FormulaireCreationProfil extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCreationLogin;
	private JTextField textFieldCreationMdp;
	private JTextField textFieldCreationNom;
	private JTextField textFieldCreationPrenom;
	private JButton btnValiderCreationProfil;
	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;

	/**
	 * Launch the application.
	 */
	public FormulaireCreationProfil(_ServicesCoeur app, String loginCourant, String motDePasseCourant){
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		initialisation();
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialisation() {
		setTitle("Créer un profil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormulaireCreationProfil.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setBackground(new Color(244,244,243));
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setForeground(new Color(11, 29, 62));
		lblMotDePasse.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblMotDePasse.setBackground(new Color(244, 244, 243));
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(11, 29, 62));
		lblNom.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblNom.setBackground(new Color(244, 244, 243));
		
		JLabel lblPrnom = new JLabel("Prénom :");
		lblPrnom.setForeground(new Color(11, 29, 62));
		lblPrnom.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblPrnom.setBackground(new Color(244, 244, 243));
		
		textFieldCreationLogin = new JTextField();
		textFieldCreationLogin.setForeground(new Color(11,29,62));
		textFieldCreationLogin.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationLogin.setColumns(10);
		
		textFieldCreationMdp = new JTextField();
		textFieldCreationMdp.setForeground(new Color(11,29,62));
		textFieldCreationMdp.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationMdp.setColumns(10);
		
		textFieldCreationNom = new JTextField();
		textFieldCreationNom.setForeground(new Color(11, 29, 62));
		textFieldCreationNom.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationNom.setColumns(10);
		
		textFieldCreationPrenom = new JTextField();
		textFieldCreationPrenom.setForeground(new Color(11, 29, 62));
		textFieldCreationPrenom.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationPrenom.setColumns(10);
		
		JButton btnAnnulerCreationProfil = new JButton("Annuler");
		btnAnnulerCreationProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAnnulerCreationProfil.setBackground(new Color(11,29,62));
		btnAnnulerCreationProfil.setForeground(new Color(255, 255, 255));
		btnAnnulerCreationProfil.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		btnValiderCreationProfil = new JButton("Valider");
		btnValiderCreationProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValiderCreationProfil.setForeground(Color.WHITE);
		btnValiderCreationProfil.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnValiderCreationProfil.setBackground(new Color(11, 29, 62));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrnom, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAnnulerCreationProfil))
							.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnValiderCreationProfil, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCreationPrenom, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldCreationNom, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(lblMotDePasse, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textFieldCreationMdp, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
								.addComponent(textFieldCreationLogin, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldCreationLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCreationMdp, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCreationNom, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrnom, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCreationPrenom, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValiderCreationProfil, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnnulerCreationProfil))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}