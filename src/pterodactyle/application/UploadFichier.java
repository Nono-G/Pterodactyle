package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.Post;
import pterodactyle.echangeable._Echangeable;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class UploadFichier extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomFichier;
	private JLabel lblChemin;
	private JTextField txtCheminAccesFichier;
	private JLabel lblAjouterUnTag;
	private JButton btnOkAddTagFichier;
	private JLabel lblListeDesTags;
	private JPanel panel_1;

	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;


	/**
	 * Launch the application.
	 */
	public UploadFichier( _ServicesCoeur app, String loginCourant, String motDePasseCourant){
		setResizable(false);
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		initialisation();
	}
	/**
	 * Create the frame.
	 */
	public void initialisation() {
		setBackground(new Color(244,244,243));
		setTitle("Nouveau Fichier");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UploadFichier.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 604, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNFichier = new JLabel("Nom du fichier :");
		lblNFichier.setForeground(new Color(11,29,62));
		lblNFichier.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		lblNFichier.setBounds(10, 11, 157, 23);
		contentPane.add(lblNFichier);
		
		txtNomFichier = new JTextField();
		txtNomFichier.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		txtNomFichier.setForeground(new Color(11,29,62));
		txtNomFichier.setBounds(177, 14, 401, 20);
		contentPane.add(txtNomFichier);
		txtNomFichier.setColumns(10);
		
		lblChemin = new JLabel("Chemin :");
		lblChemin.setForeground(new Color(11, 29, 62));
		lblChemin.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		lblChemin.setBounds(10, 63, 103, 23);
		contentPane.add(lblChemin);
		
		txtCheminAccesFichier = new JTextField();
		txtCheminAccesFichier.setForeground(new Color(11,29,62));
		txtCheminAccesFichier.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		txtCheminAccesFichier.setBounds(112, 66, 466, 20);
		contentPane.add(txtCheminAccesFichier);
		txtCheminAccesFichier.setColumns(10);
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCharger.setBackground(new Color(11,29,62));
		btnCharger.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnCharger.setForeground(new Color(255, 255, 255));
		btnCharger.setBounds(291, 97, 89, 23);
		contentPane.add(btnCharger);
		
		lblAjouterUnTag = new JLabel("Ajouter un tag :");
		lblAjouterUnTag.setForeground(new Color(11, 29, 62));
		lblAjouterUnTag.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		lblAjouterUnTag.setBounds(10, 136, 157, 23);
		contentPane.add(lblAjouterUnTag);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(11,29,62));
		comboBox.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		comboBox.setBackground(new Color(244,244,243));
		comboBox.setBounds(10, 182, 128, 20);
		contentPane.add(comboBox);
		
		btnOkAddTagFichier = new JButton("OK");
		btnOkAddTagFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOkAddTagFichier.setForeground(Color.WHITE);
		btnOkAddTagFichier.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnOkAddTagFichier.setBackground(new Color(11, 29, 62));
		btnOkAddTagFichier.setBounds(148, 181, 70, 23);
		contentPane.add(btnOkAddTagFichier);
		
		lblListeDesTags = new JLabel("Liste des tags ajoutés :");
		lblListeDesTags.setForeground(new Color(11, 29, 62));
		lblListeDesTags.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		lblListeDesTags.setBounds(281, 136, 222, 23);
		contentPane.add(lblListeDesTags);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244,244,243));
		panel.setBounds(281, 167, 258, 142);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
		);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JList list = new JList();
		list.setBackground(new Color(211,210,250));
		list.setForeground(new Color(11,29,62));
		list.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnAnnuler.setBackground(new Color(11, 29, 62));
		btnAnnuler.setBounds(10, 328, 89, 23);
		contentPane.add(btnAnnuler);
		
		JButton btnUploadFich = new JButton("Upload");
		btnUploadFich.setForeground(Color.WHITE);
		btnUploadFich.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnUploadFich.setBackground(new Color(11, 29, 62));
		btnUploadFich.setBounds(489, 328, 89, 23);
		contentPane.add(btnUploadFich);
	}
}
