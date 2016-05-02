package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.Tag;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Utilisateur;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProfilUser extends JFrame {

	private JPanel contentPane;
	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private Utilisateur utilisateurCourant;
	private Map<String, Utilisateur> utilisateurs;

	/**
	 * Launch the application.
	 */
	public ProfilUser(_ServicesCoeur app,Utilisateur utilisateur, String loginCourant, String motDePasseCourant){
		setResizable(false);
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		this.utilisateurs=new HashMap<String,Utilisateur>();
		this.utilisateurCourant = utilisateur;
		System.out.println(utilisateur.getLogin());
		initialisation();
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialisation() {
		setTitle("Profil ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProfilUser.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 620, 457);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(11,29,62));
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLogin = new JLabel("Login de l'utilisateur");
		lblLogin.setForeground(new Color(11,29,62));
		lblLogin.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		
		JLabel lblNomUser = new JLabel("Nom de l'utilisateur");
		lblNomUser.setForeground(new Color(11, 29, 62));
		lblNomUser.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblPrenomUser = new JLabel("Prénom de l'utilisateur");
		lblPrenomUser.setForeground(new Color(11, 29, 62));
		lblPrenomUser.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(11,29,62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnSuppUserAdmin = new JButton("Supprimer l'utilisateur");
		btnSuppUserAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuppUserAdmin.setForeground(Color.WHITE);
		btnSuppUserAdmin.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnSuppUserAdmin.setBackground(new Color(11, 29, 62));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(11,29,62), 3, true));
		
		JLabel lblListeDroitsAssocies = new JLabel("Liste des droits associés");
		lblListeDroitsAssocies.setForeground(new Color(11, 29, 62));
		lblListeDroitsAssocies.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblAddDroit = new JLabel("Ajouter un droit :");
		lblAddDroit.setForeground(new Color(11, 29, 62));
		lblAddDroit.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JComboBox comboBoxTagPourDroit = new JComboBox();
		comboBoxTagPourDroit.setForeground(new Color(11,29,62));
		comboBoxTagPourDroit.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		try {
			Set<Tag> tags = app.getTagsDroitCreation(loginCourant, motDePasseCourant);
			String[] res = new String[tags.size()];
			int i =0;
			for(Tag t : tags){
				res[i] = t.toString();
				i++;
			}
			comboBoxTagPourDroit.setModel(new DefaultComboBoxModel(res));
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		
		JComboBox comboBoxListeDroits = new JComboBox();
		comboBoxListeDroits.setModel(new DefaultComboBoxModel(new String[] {"lecture", "modification", "creation", "suppression", "partage"}));
		comboBoxListeDroits.setForeground(new Color(11, 29, 62));
		comboBoxListeDroits.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnOkAddDroit = new JButton("OK");
		btnOkAddDroit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tag = (String) comboBoxTagPourDroit.getSelectedItem();				
				String droit = (String) comboBoxListeDroits.getSelectedItem();
				
				if(droit.equals("lecture")){try {
					app.partageDroits(utilisateurCourant.getLogin(), tag, 0, loginCourant, motDePasseCourant);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(droit.equals("modification")){try {
					app.partageDroits(utilisateurCourant.getLogin(), tag, 0, loginCourant, motDePasseCourant);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(droit.equals("partage")){try {
					app.partageDroits(utilisateurCourant.getLogin(), tag, 0, loginCourant, motDePasseCourant);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(droit.equals("creation")){try {
					app.partageDroits(utilisateurCourant.getLogin(), tag, 0, loginCourant, motDePasseCourant);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				if(droit.equals("suppression")){try {
					app.partageDroits(utilisateurCourant.getLogin(), tag, 0, loginCourant, motDePasseCourant);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			}
		});
		btnOkAddDroit.setForeground(Color.WHITE);
		btnOkAddDroit.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnOkAddDroit.setBackground(new Color(11, 29, 62));
		
		JLabel labelSuppDroits = new JLabel("Supprimer un droit selectionné dans la liste :");
		labelSuppDroits.setForeground(new Color(11, 29, 62));
		labelSuppDroits.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnOKSuppDroitsUser = new JButton("OK");
		btnOKSuppDroitsUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOKSuppDroitsUser.setForeground(Color.WHITE);
		btnOKSuppDroitsUser.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnOKSuppDroitsUser.setBackground(new Color(11, 29, 62));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelSuppDroits, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomUser, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrenomUser, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddDroit, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxTagPourDroit, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBoxListeDroits, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnOkAddDroit, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnOKSuppDroitsUser, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblListeDroitsAssocies, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(56))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSuppUserAdmin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
									.addGap(29))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(176)
							.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListeDroitsAssocies, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomUser, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrenomUser, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblAddDroit, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxTagPourDroit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxListeDroits, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOkAddDroit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(labelSuppDroits, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOKSuppDroitsUser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSuppUserAdmin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(11,29,62));
		panel.setBackground(new Color(211,210,250));
		scrollPane.setViewportView(panel);
		
		JList list = new JList();
		list.setBackground(new Color(211,210,250));
		list.setForeground(new Color(11,29,62));
		list.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
