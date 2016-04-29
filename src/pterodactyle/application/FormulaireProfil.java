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
		lblNewLabel.setBackground(new Color(244,244,243));
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		
		JLabel label = new JLabel("Login :");
		label.setForeground(new Color(11, 29, 62));
		label.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		label.setBackground(new Color(244, 244, 243));
		
		JLabel label_1 = new JLabel("Login :");
		label_1.setForeground(new Color(11, 29, 62));
		label_1.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		label_1.setBackground(new Color(244, 244, 243));
		
		JLabel label_2 = new JLabel("Login :");
		label_2.setForeground(new Color(11, 29, 62));
		label_2.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		label_2.setBackground(new Color(244, 244, 243));
		
		textFieldCreationLogin = new JTextField();
		textFieldCreationLogin.setForeground(new Color(11,29,62));
		textFieldCreationLogin.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationLogin.setColumns(10);
		
		textFieldCreationMdp = new JTextField();
		textFieldCreationMdp.setForeground(new Color(11,29,62));
		textFieldCreationMdp.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldCreationMdp.setColumns(10);
		
		textField = new JTextField();
		textField.setForeground(new Color(11, 29, 62));
		textField.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(11, 29, 62));
		textField_1.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textField_1.setColumns(10);
		
		JButton btnAnnulerCreationProfil = new JButton("Annuler");
		btnAnnulerCreationProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCreationLogin, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCreationMdp, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAnnulerCreationProfil))
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(btnValiderCreationProfil, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCreationMdp, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValiderCreationProfil, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnnulerCreationProfil))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
