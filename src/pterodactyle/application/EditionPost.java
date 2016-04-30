package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.ExceptionEchangeableInexistant;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.echangeable.Post;
import pterodactyle.echangeable._Echangeable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditionPost extends JFrame {

	private JPanel contentPane;

	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;
	private Map<String, _Echangeable> echangeables;
	private Post post;

	/**
	 * Launch the application.
	 */
	public EditionPost(Post post, _ServicesCoeur app, String loginCourant, String motDePasseCourant){
		setResizable(false);
		this.loginCourant= loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app =app;
		this.post = post;
		this.echangeables = new HashMap<String, _Echangeable>();
		initialisation();
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialisation()  {
		setTitle("Post");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditionPost.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(11,29,62));
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea textAreaReponse = new JTextArea();
		textAreaReponse.setForeground(new Color(11,29,62));
		textAreaReponse.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textAreaReponse.setBackground(new Color(211,210,250));
		
		JTextPane txtpnJJJ = new JTextPane();
		txtpnJJJ.setBackground(new Color(211,210,250));
		txtpnJJJ.setForeground(new Color(11,29,62));
		txtpnJJJ.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		txtpnJJJ.setEditable(false);
		txtpnJJJ.setText(post.affichage2());
		
		JLabel labelTitre = new JLabel("Titre :");
		labelTitre.setForeground(new Color(11,29,62));
		labelTitre.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel(post.getTitre());//ICI LE TITRE DU POST S'AFFICHE EN HAUT
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRepondrePost = new JButton("Répondre");
		btnRepondrePost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contenu = textAreaReponse.getText();
				if(contenu.length() != 0){
					try {
						app.repondrePost(post.getUrl(), contenu, loginCourant, motDePasseCourant);
						post = (Post)app.getEchangeable(post.getUrl(), loginCourant, motDePasseCourant);
						txtpnJJJ.setText(post.affichage2());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ExceptionEchangeableMauvaisType e1) {
						//Exception impossible
						e1.printStackTrace();
					} catch (ExceptionEchangeableInexistant e1) {
						//Exception impossible
						e1.printStackTrace();
					}
				}
			}
		});
		btnRepondrePost.setBackground(new Color(11,29,62));
		btnRepondrePost.setForeground(new Color(255,255,255));
		btnRepondrePost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JComboBox comboAddTag = new JComboBox();
		comboAddTag.setModel(new DefaultComboBoxModel(new String[] {"test", "test", "test", "test", "test", "test", "tytu"}));
		comboAddTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		comboAddTag.setForeground(new Color(11,29,62));
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un tag au post ?");
		lblNewLabel_1.setForeground(new Color(11,29,62));
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnAddTagPost = new JButton("OK");
		btnAddTagPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddTagPost.setForeground(Color.WHITE);
		btnAddTagPost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnAddTagPost.setBackground(new Color(11, 29, 62));
		
		JLabel labelAuteur = new JLabel("Auteur :");
		labelAuteur.setForeground(new Color(11, 29, 62));
		labelAuteur.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel labelDate = new JLabel("Date :");
		labelDate.setForeground(new Color(11, 29, 62));
		labelDate.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel labelTags = new JLabel("Tags :");
		labelTags.setForeground(new Color(11, 29, 62));
		labelTags.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblMasqueauteur = new JLabel(post.getAuteur().toString()); //ICI l'AUTEUR DU POST S'AFFICHE EN HAUT
		lblMasqueauteur.setForeground(new Color(11, 29, 62));
		lblMasqueauteur.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblMasquedate = new JLabel(post.getDateCreation().toString()); //ICI LA DATE DE CREATION DU POST S'AFFICHE EN HAUT
		lblMasquedate.setForeground(new Color(11, 29, 62));
		lblMasquedate.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblMasquetags = new JLabel(post.voirTags()); //ICI LES TAGS DU POST S'AFFICHE EN HAUT
		lblMasquetags.setForeground(new Color(11, 29, 62));
		lblMasquetags.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblSupprimerUnPost = new JLabel("Supprimer un tag du post ?");
		lblSupprimerUnPost.setForeground(new Color(11, 29, 62));
		lblSupprimerUnPost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JComboBox comboBoxSuppressionTag = new JComboBox();
		comboBoxSuppressionTag.setModel(new DefaultComboBoxModel(new String[] {"test", "tag", "tag"}));
		comboBoxSuppressionTag.setForeground(new Color(11, 29, 62));
		comboBoxSuppressionTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnSuppressionTag = new JButton("OK");
		btnSuppressionTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuppressionTag.setForeground(Color.WHITE);
		btnSuppressionTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnSuppressionTag.setBackground(new Color(11, 29, 62));
		
		JButton btnAnnulerEdition = new JButton("Annuler");
		btnAnnulerEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					ApplicationUtilisateur ap = new ApplicationUtilisateur(app,loginCourant,motDePasseCourant);
					ap.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAnnulerEdition.setForeground(Color.WHITE);
		btnAnnulerEdition.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnAnnulerEdition.setBackground(new Color(11, 29, 62));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelTitre)
										.addGap(47))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelAuteur, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelDate, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(labelTags)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRepondrePost)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMasqueauteur, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
										.addComponent(lblMasquedate, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblMasquetags, GroupLayout.PREFERRED_SIZE, 867, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(122)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(comboAddTag, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
													.addGap(34)
													.addComponent(btnAddTagPost, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
											.addGap(39)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(comboBoxSuppressionTag, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
													.addGap(35)
													.addComponent(btnSuppressionTag, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblSupprimerUnPost, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
											.addGap(262)))
									.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAnnulerEdition, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTitre)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelAuteur, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMasqueauteur, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMasquedate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTags, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMasquetags, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblSupprimerUnPost, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRepondrePost)
								.addComponent(btnAnnulerEdition, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddTagPost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboAddTag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxSuppressionTag, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSuppressionTag, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(49))))
		);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(textAreaReponse, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(textAreaReponse, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(txtpnJJJ, GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(txtpnJJJ, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
