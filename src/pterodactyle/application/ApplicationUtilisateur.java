package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.border.LineBorder;

import pterodactyle.coeur._ServicesCoeur;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.AdministrateurException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.MouseAdapter;


public class ApplicationUtilisateur extends JFrame {

	private JPanel contentPane;
	private _ServicesCoeur app;
	private static String loginCourant;
	private static String motDePasseCourant;
	private Map<String, Post> posts;
	private Map<String, Fichier> fichiers;
	private List<String> tagsFiltre;
	private JTextField txtFiltrerParTagCloud;
	private JTextField textFieldTagCreation;
	private JButton btnRefreshCloud;
	private JButton btnResfreshAdmin;

	
	public ApplicationUtilisateur(_ServicesCoeur app, String loginCourant, String motDePasseCourant){
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		this.posts = new HashMap<String, Post>();
		this.fichiers = new HashMap<String, Fichier>();
		this.tagsFiltre = new ArrayList<String>();
		new File("FunkySkeletonTelechargements").mkdir();
		initialisation();
	}


	/**
	 * Create the frame.
	 * @return 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialisation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setResizable(false);
		setSize(500,500);
		setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		setTitle("Bienvenue");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPresentation = new JPanel();
		panelPresentation.setBackground(new Color(11, 29, 62));
		panelPresentation.setBounds(10, 11, 201, 107);
		contentPane.add(panelPresentation);
		panelPresentation.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(135, 206, 250));
		lblNewLabel_1.setIcon(new ImageIcon(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/SizedFunkySkeletoAppn.png")));
		lblNewLabel_1.setBounds(5, 5, 191, 96);
		panelPresentation.add(lblNewLabel_1);
		
		JLabel lbloginUtilisateur = new JLabel("Login utilisateur : "+loginCourant);
		lbloginUtilisateur.setBounds(221, 101, 170, 24);
		contentPane.add(lbloginUtilisateur);
		lbloginUtilisateur.setForeground(new Color(11, 29, 62));
		lbloginUtilisateur.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		
		JLabel lblSmileySkeletonNetwork = new JLabel("Funky Skeleton ");
		lblSmileySkeletonNetwork.setForeground(new Color(11, 29, 62));
		lblSmileySkeletonNetwork.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblSmileySkeletonNetwork.setBounds(221, 24, 261, 34);
		contentPane.add(lblSmileySkeletonNetwork);
		
		JLabel lblMuseumNetwork = new JLabel("Museum Network");
		lblMuseumNetwork.setForeground(new Color(11, 29, 62));
		lblMuseumNetwork.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblMuseumNetwork.setBounds(221, 56, 261, 34);
		contentPane.add(lblMuseumNetwork);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 129, 830, 411);
		panel.setBackground(new Color(244, 244, 243));
		contentPane.add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		
		JPanel onglet1=new JPanel();
		onglet1.setBackground(new Color(244, 244, 243));
		JPanel onglet2 = new JPanel();
		onglet2.setBackground(new Color(244, 244, 243));
		JPanel onglet3 = new JPanel();
		onglet3.setBackground(new Color(244, 244, 243));

		
		JLabel lblForum = new JLabel("Filtrer par tags :");
		lblForum.setBounds(10, 11, 96, 21);
		lblForum.setForeground(new Color(11, 29, 62));
		lblForum.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		tabbedPane.add("Forum ",onglet1);
		
		JTextField textField = new JTextField();
		textField.setBounds(102, 11, 108, 21);
		textField.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ajouter un tag");
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 42, 200, 21);
		

		
		JPanel panel_test = new JPanel();
		panel_test.setBorder(new LineBorder(new Color(11,29,62), 3, true));
		panel_test.setBackground(new Color(244, 244, 243));
		panel_test.setBounds(10, 68, 815, 315);
		onglet1.add(panel_test);
		tabbedPane.add("Cloud ",onglet2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_test = new GroupLayout(panel_test);
		gl_panel_test.setHorizontalGroup(
			gl_panel_test.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
		);
		gl_panel_test.setVerticalGroup(
			gl_panel_test.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 700, 200);
		panel_1.setBackground(new Color(211,210,250));
		scrollPane.setViewportView(panel_1);
		
		JList<PaireTitreUrl> list = new JList<PaireTitreUrl>();

		final JList<PaireTitreUrl> listPourClick = list;
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2){
					//listPourClick.getSelectedValue();
					PaireTitreUrl titre = listPourClick.getModel().getElementAt(listPourClick.locationToIndex(e.getPoint()));
					EditionPost ep = new EditionPost((Post)posts.get(titre.url), app, loginCourant, motDePasseCourant);
					ep.setVisible(true);
				}
			}

		});
		list.setBorder(null);
		list.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		list.setBackground(new Color(211,210,250));
		list.setForeground(new Color(11, 29, 62));
		list.setModel(new AbstractListModel<PaireTitreUrl>() {
			
			PaireTitreUrl[] values =  refreshPosts();

			public int getSize() {
				return values.length;
			}
			public PaireTitreUrl getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tag = textField.getText();
				lblNewLabel.setText("Trier sur le tag : "+tag);
				PaireTitreUrl[] data = new PaireTitreUrl[posts.size()];
				int i = 0;
				for(String s : posts.keySet()){
					_Echangeable ech =  posts.get(s);
					Set<Tag> tags = (($EchangeableAvecTag)ech).getTags();
					boolean containt = false;
					for(Tag t : tags){
						if(tag.equals(t.toString())){
							data[i] = new PaireTitreUrl(((Post)ech).getTitre(), ech.getUrl());
							i++;
							}
					}
				}	
				{list.setListData(data);}
				
			}
		});
		
		
		btnOk.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnOk.setBounds(220, 10, 69, 23);
		btnOk.setBackground(new Color(11,29,62));
		btnOk.setForeground(new Color(255, 255, 255));
		
		onglet1.setLayout(null);
		onglet1.add(lblForum);
		onglet1.add(textField);
		onglet1.add(lblNewLabel);
		onglet1.add(btnOk);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(list)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel_test.setLayout(gl_panel_test);
		lblForum.setBounds(10, 11, 96, 21);
		onglet1.add(lblForum);
		tabbedPane.add("Forum ",onglet1);
		

		JButton btnRefresh = new JButton("");
		btnRefresh.setBounds(793, 31, 32, 32);
		onglet1.add(btnRefresh);
		btnRefresh.setBackground(new Color(11,29,62));
		btnRefresh.setIcon(new ImageIcon(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/logorafraichir.png")));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh();
			}
		});
		
		JButton btnNewPost = new JButton("Nouveau post !");
		btnNewPost.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnNewPost.setForeground(Color.WHITE);
		btnNewPost.setBackground(new Color(11, 29, 62));
		btnNewPost.setBounds(614, 41, 171, 23);
		onglet1.add(btnNewPost);
		
		JButton btnSuppPostUser = new JButton("Supprimer un post !");
		btnSuppPostUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSuppPostUser.setForeground(Color.WHITE);
		btnSuppPostUser.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnSuppPostUser.setBackground(new Color(11, 29, 62));
		btnSuppPostUser.setBounds(399, 41, 200, 23);
		onglet1.add(btnSuppPostUser);
		tabbedPane.add("Cloud ",onglet2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 45, 805, 327);
		panel_2.setForeground(new Color(11,29,62));
		panel_2.setBorder(new LineBorder(new Color(11,29,62), 3, true));
		panel_2.setBackground(new Color(244,244,243));
		
		JLabel label_1 = new JLabel("Filtrer par tags :");
		label_1.setBounds(10, 11, 96, 21);
		label_1.setForeground(new Color(11, 29, 62));
		label_1.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		
		txtFiltrerParTagCloud = new JTextField();
		txtFiltrerParTagCloud.setBounds(102, 10, 108, 21);
		txtFiltrerParTagCloud.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		txtFiltrerParTagCloud.setColumns(10);
		
		JButton btnOkFiltrerParTagCloud = new JButton("OK");
		btnOkFiltrerParTagCloud.setBounds(220, 9, 69, 25);
		btnOkFiltrerParTagCloud.setForeground(Color.WHITE);
		btnOkFiltrerParTagCloud.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnOkFiltrerParTagCloud.setBackground(new Color(11, 29, 62));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
		);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(11,29,62));
		panel_3.setBackground(new Color(211,210,250));
		scrollPane_1.setViewportView(panel_3);
		
		JList<String> listFichiers = new JList<String>();
		listFichiers.setBackground(new Color(211,210,250));
		listFichiers.setForeground(new Color(11,29,62));
		listFichiers.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		listFichiers.setModel(new AbstractListModel<String>() {
			
			String[] values =  refreshFichiers();

			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(listFichiers, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addComponent(listFichiers, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		onglet2.setLayout(null);
		onglet2.add(label_1);
		onglet2.add(txtFiltrerParTagCloud);
		onglet2.add(btnOkFiltrerParTagCloud);
		onglet2.add(panel_2);
		
		JButton btnUploadFichier = new JButton("Nouveau fichier !");
		btnUploadFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadFichier uf = new UploadFichier(app,loginCourant,motDePasseCourant);
				uf.setVisible(true);
			}
		});
		btnUploadFichier.setForeground(Color.WHITE);
		btnUploadFichier.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnUploadFichier.setBackground(new Color(11, 29, 62));
		btnUploadFichier.setBounds(366, 9, 185, 25);
		onglet2.add(btnUploadFichier);
		
		JButton btnDownloadFichier = new JButton("T\u00E9l\u00E9charger");
		btnDownloadFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listFichiers.getSelectedIndex() != -1){
					String url = listFichiers.getSelectedValue();
					long temps = System.currentTimeMillis();
					download(("FunkySkeletonTelechargements/"+url), url, 10000, app);
					temps = System.currentTimeMillis() - temps;
					ConfirmationTelech conf = new ConfirmationTelech((int)temps/1000, url);
					conf.setVisible(true);
				}
			}
		});
		btnDownloadFichier.setForeground(Color.WHITE);
		btnDownloadFichier.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnDownloadFichier.setBackground(new Color(11, 29, 62));
		btnDownloadFichier.setBounds(561, 9, 132, 25);
		onglet2.add(btnDownloadFichier);
		
		btnRefreshCloud = new JButton("");
		btnRefreshCloud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnRefreshCloud.setIcon(new ImageIcon(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/logorafraichir.png")));
		btnRefreshCloud.setBackground(new Color(11, 29, 62));
		btnRefreshCloud.setBounds(783, 10, 32, 32);
		onglet2.add(btnRefreshCloud);
		btnNewPost.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					NouveauPost np = new NouveauPost(app,loginCourant,motDePasseCourant);
					np.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		JLabel lblAnnuaire = new JLabel("Annuaire");
		lblAnnuaire.setForeground(new Color(11, 29, 62));
		lblAnnuaire.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblAnnuaire.setBounds(755, 62, 95, 24);
		contentPane.add(lblAnnuaire);
		
		JButton btnGo = new JButton("Go !");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnnuaireIHM annuaire = new AnnuaireIHM(app, loginCourant, motDePasseCourant);
				annuaire.setVisible(true);
			}
		});
		btnGo.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(new Color(11, 29, 62));
		btnGo.setBounds(762, 102, 58, 23);
		contentPane.add(btnGo);
		tabbedPane.add("Administrer ",onglet3);
		
		JLabel lblCreerUserAdmin = new JLabel("Créer un utilisateur :");
		lblCreerUserAdmin.setForeground(new Color(11,29,62));
		lblCreerUserAdmin.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblCrerUnTag = new JLabel("Créer un tag :");
		lblCrerUnTag.setForeground(new Color(11, 29, 62));
		lblCrerUnTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblSupprimerUnTag = new JLabel("Supprimer un tag :");
		lblSupprimerUnTag.setForeground(new Color(11, 29, 62));
		lblSupprimerUnTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnFormulaireCreerProfil = new JButton("Formulaire");
		btnFormulaireCreerProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FormulaireCreationProfil fcp = new FormulaireCreationProfil(app,loginCourant,motDePasseCourant);
					fcp.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnFormulaireCreerProfil.setForeground(new Color(255, 255, 255));
		btnFormulaireCreerProfil.setBackground(new Color(11,29,62));
		btnFormulaireCreerProfil.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		textFieldTagCreation = new JTextField();
		textFieldTagCreation.setForeground(new Color(11,29,62));
		textFieldTagCreation.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textFieldTagCreation.setColumns(10);
		
		JButton btnCreerUnTag = new JButton("OK");
		btnCreerUnTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tag = textFieldTagCreation.getText();
				try {
					app.creerTag(tag, loginCourant, motDePasseCourant);
					btnResfreshAdmin.doClick();
				} catch (RemoteException | AdministrateurException | ExceptionEchangeableTagExistant e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCreerUnTag.setForeground(Color.WHITE);
		btnCreerUnTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnCreerUnTag.setBackground(new Color(11,29,62));
		
		JComboBox comboBox = new JComboBox();
		Set<Tag> tags;
		String[] tagsArray;
		System.out.println(loginCourant);
		System.out.println(motDePasseCourant);
		try {
			tags = app.getTagsDroitCreation(loginCourant, motDePasseCourant);
			tagsArray = new String[tags.size()];
			int i = 0;
			for(Tag t : tags){
				tagsArray[i] = t.toString();
				i++;
			}
			comboBox.setModel(new DefaultComboBoxModel(tagsArray));
		} catch (RemoteException e1) {

		}
		
		
		
		comboBox.setBackground(new Color(244,244,243));
		comboBox.setForeground(new Color(11,29,62));
		comboBox.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnSuppTagOk = new JButton("OK");
		btnSuppTagOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tagSelect = (String) comboBox.getSelectedItem();
				try {
					app.supprimerTag(tagSelect, loginCourant, motDePasseCourant);
					btnRefresh.doClick();
				} catch (RemoteException | AdministrateurException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSuppTagOk.setForeground(Color.WHITE);
		btnSuppTagOk.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnSuppTagOk.setBackground(new Color(11,29,62));
		
		btnResfreshAdmin = new JButton("");
		btnResfreshAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnResfreshAdmin.setIcon(new ImageIcon(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/logorafraichir.png")));
		btnResfreshAdmin.setBackground(new Color(11, 29, 62));
		GroupLayout gl_onglet3 = new GroupLayout(onglet3);
		gl_onglet3.setHorizontalGroup(
			gl_onglet3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_onglet3.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_onglet3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_onglet3.createSequentialGroup()
							.addComponent(lblCrerUnTag, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTagCreation, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCreerUnTag, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_onglet3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_onglet3.createSequentialGroup()
								.addComponent(lblSupprimerUnTag, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox, 0, 135, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnSuppTagOk, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_onglet3.createSequentialGroup()
								.addComponent(lblCreerUserAdmin, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnFormulaireCreerProfil, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addGap(76))))
					.addGap(380)
					.addComponent(btnResfreshAdmin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_onglet3.setVerticalGroup(
			gl_onglet3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_onglet3.createSequentialGroup()
					.addGroup(gl_onglet3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_onglet3.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_onglet3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCreerUserAdmin, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFormulaireCreerProfil))
							.addGap(114)
							.addGroup(gl_onglet3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCrerUnTag, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldTagCreation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCreerUnTag, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(115)
							.addGroup(gl_onglet3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSupprimerUnTag, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSuppTagOk, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_onglet3.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnResfreshAdmin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))

		);
		onglet3.setLayout(gl_onglet3);
		
	}
	
	protected PaireTitreUrl[] Arrayto(List<PaireTitreUrl> data2 ){
		PaireTitreUrl[] data = new PaireTitreUrl[data2.size()];
		int i = 0;
		for(PaireTitreUrl p : data2){
			data[i] = p;
		}
		return data;		
	}
	
	protected PaireTitreUrl[] refreshPosts(){
		Set<Post> posts = null;
		int i = 0;
		try {
			posts = app.getPosts(loginCourant, motDePasseCourant);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PaireTitreUrl[] titresPosts = new PaireTitreUrl[posts.size()];
		
		for(Post p : posts){
			this.posts.put(p.getUrl(), p);
			titresPosts[i] = new PaireTitreUrl(p.getTitre(), p.getUrl());
			i++;
		}
		return titresPosts;
	}

	protected String[] refreshFichiers(){
		Set<Fichier> fichiersloc = null;
		int i = 0;
		try {
			fichiersloc = app.getFichiers(loginCourant, motDePasseCourant);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] nomsFichiers = new String[fichiersloc.size()];
		
		for(Fichier f : fichiersloc){
			this.fichiers.put(f.getUrl(), f);
			nomsFichiers[i] = f.getUrl();
			i++;
		}
		return nomsFichiers;
	}
	
	private static void upload(String urlLocal, String urlServeur, int tailleBuffer, _ServicesCoeur c) throws ExceptionEchangeableMauvaisType{
		long i=0;
		File local = new File(urlLocal);
		try(FileInputStream fis = new FileInputStream(local)){
			Object[] data = new Object[2];
			byte[] buffer = new byte[tailleBuffer];
			i = (local.length()/tailleBuffer)+1;
			while(i != 0){
				data[0] = fis.read(buffer);
				data[1] = buffer;
				c.ecrireTranche(data, urlServeur, loginCourant, motDePasseCourant);
				i--;
				System.out.println(""+data[0]);
			}
		}catch(IOException e){e.printStackTrace();}
	}
	
	private void refresh(){
		dispose();
		ApplicationUtilisateur fr = new ApplicationUtilisateur(app,loginCourant,motDePasseCourant);
		fr.setVisible(true);
	}
	
	private static void download(String urlLocal, String urlServeur, int tailleBuffer, _ServicesCoeur c){
		File local = new File(urlLocal);
		try(FileOutputStream fos = new FileOutputStream(local)){
			Object[] data;
			byte[] buffer;
			int n=0;
			while(true){
				try{
					try {
						data = c.trancheFichier(urlServeur, n, tailleBuffer, loginCourant, motDePasseCourant);
						buffer = (byte[]) data[1];
						fos.write(buffer, 0, (int)data[0]);
						n++;
					}catch(ExceptionEchangeableMauvaisType e) {e.printStackTrace();}
				}catch(ExceptionEchangeableFichierFini e){break;}
			}
		}catch(IOException e){System.out.println("Fichier local erreur");e.printStackTrace();};
	}
}



class PaireTitreUrl{
	
	String titre;
	String url;
	
	public PaireTitreUrl (String titre, String url){
		this.titre = titre;
		this.url = url;
	}
	
	public String toString() {return titre;}
	public String getTitre() {return this.titre;}
	public String getUrl() {return this.url;}
}