package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import pterodactyle.coeur._ServicesCoeur;
import pterodactyle.echangeable.Post;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Utilisateur;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AnnuaireIHM extends JFrame {

	private JPanel contentPane;
	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;
	private Map<String, Utilisateur> utilisateurs;
	private JTextField txtRechercheLogin;

	/**
	 * Launch the application.
	 */
	public AnnuaireIHM(_ServicesCoeur app, String loginCourant, String motDePasseCourant){
		setResizable(false);
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		this.utilisateurs = new HashMap<String, Utilisateur>();
		initialisation();
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialisation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnnuaireIHM.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setTitle("Annuaire");
		setBounds(100, 100, 577, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(11,29,62), 3, true));
		
		JButton btnNewButton = new JButton("Voir profil");
		btnNewButton.setBackground(new Color(11,29,62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblTitreAnnuaire = new JLabel("Annuaire");
		lblTitreAnnuaire.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		
		JButton btnOkSearch = new JButton("OK");
		btnOkSearch.setForeground(Color.WHITE);
		btnOkSearch.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnOkSearch.setBackground(new Color(11, 29, 62));
		
		JLabel lblNewLabel = new JLabel("Rechercher par login :");
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		txtRechercheLogin = new JTextField();
		txtRechercheLogin.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitreAnnuaire, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtRechercheLogin, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnOkSearch, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
									.addComponent(btnNewButton)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitreAnnuaire)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRechercheLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOkSearch, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 205));
		scrollPane.setViewportView(panel);
		
		JList<String> list = new JList<String>();
		list.setBackground(new Color(211,210,250));
		list.setModel(new AbstractListModel<String>() {
			String[] values = refreshUtilisateurs();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		/*list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2){
					//listPourClick.getSelectedValue();
					String titre = list.getModel().getElementAt(list.locationToIndex(e.getPoint()));
					System.out.println(titre);
					ProfilUser pu = new ProfilUser(app,loginCourant,loginCourant);
					pu.setVisible(true);
				}
			}

		});*/
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null){
					String titre = list.getSelectedValue();
					Utilisateur ut = utilisateurs.get(titre.split(" :")[0]);
					ProfilUser pu = new ProfilUser(app,ut, loginCourant, loginCourant);
					pu.setVisible(true);
				}

			}
		});
		
		list.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected String[] refreshUtilisateurs(){
		Map<String,Utilisateur> users = null;
		int i = 0;
		try {
			users = app.recupererToutLesUtilisateurs(loginCourant, motDePasseCourant);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] nomsUtilisateurs = new String[users.size()];

		for(String p : users.keySet()){
			Utilisateur u = users.get(p);
			this.utilisateurs.put(p, u);
			nomsUtilisateurs[i] = u.getLogin()+" : "+u.toString();
			i++;
		}
		
		return nomsUtilisateurs;
	}
}
