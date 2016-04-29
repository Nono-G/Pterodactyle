package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.Post;
import pterodactyle.echangeable._Echangeable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(11,29,62));
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelTitre = new JLabel("Titre :");
		labelTitre.setForeground(new Color(11,29,62));
		labelTitre.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel(post.getTitre());//ICI LE TITRE DU POST S'AFFICHE EN HAUT
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Répondre");
		btnNewButton.setBackground(new Color(11,29,62));
		btnNewButton.setForeground(new Color(255,255,255));
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnEditCancel = new JButton("Annuler");
		btnEditCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnEditCancel.setBackground(new Color(11,29,62));
		btnEditCancel.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnEditCancel.setForeground(new Color(255,255,255));
		
		JComboBox comboAddTag = new JComboBox();
		comboAddTag.setModel(new DefaultComboBoxModel(new String[] {"test", "test", "test", "test", "test", "test", "tytu"}));
		comboAddTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		comboAddTag.setForeground(new Color(11,29,62));
		
		JComboBox comboBoxSuppTag = new JComboBox();
		comboBoxSuppTag.setModel(new DefaultComboBoxModel(new String[] {"test", "teste", "zffzfzf", "szfzf", "zfzfzzf"}));
		comboBoxSuppTag.setForeground(new Color(11, 29, 62));
		comboBoxSuppTag.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Ajouter un tag au post ?");
		lblNewLabel_1.setForeground(new Color(11,29,62));
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel labelSupp = new JLabel("Supprimer un tag du post ?");
		labelSupp.setForeground(new Color(11, 29, 62));
		labelSupp.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnAddTagPost = new JButton("OK");
		btnAddTagPost.setForeground(Color.WHITE);
		btnAddTagPost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnAddTagPost.setBackground(new Color(11, 29, 62));
		
		JButton btnSupprTagPost = new JButton("OK");
		btnSupprTagPost.setForeground(Color.WHITE);
		btnSupprTagPost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnSupprTagPost.setBackground(new Color(11, 29, 62));
		
		JLabel labelAuteur = new JLabel("Auteur :");
		labelAuteur.setForeground(new Color(11, 29, 62));
		labelAuteur.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel labelDate = new JLabel("Date :");
		labelDate.setForeground(new Color(11, 29, 62));
		labelDate.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel labelTags = new JLabel("Tags :");
		labelTags.setForeground(new Color(11, 29, 62));
		labelTags.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel lblMasqueauteur = new JLabel(post.getAuteur().toString()); //ICI l'AUTEUR DU POST S'AFFICHE EN HAUT
		lblMasqueauteur.setForeground(new Color(11, 29, 62));
		lblMasqueauteur.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel lblMasquedate = new JLabel(post.getDateCreation().toString()); //ICI LA DATE DE CREATION DU POST S'AFFICHE EN HAUT
		lblMasquedate.setForeground(new Color(11, 29, 62));
		lblMasquedate.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JLabel lblMasquetags = new JLabel(post.voirTags()); //ICI LES TAGS DU POST S'AFFICHE EN HAUT
		lblMasquetags.setForeground(new Color(11, 29, 62));
		lblMasquetags.setFont(new Font("Dialog", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(882, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(comboAddTag, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAddTagPost)
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBoxSuppTag, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSupprTagPost)
								.addComponent(btnEditCancel)))
						.addComponent(labelSupp, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(labelTags, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelAuteur, Alignment.LEADING)
						.addComponent(labelTitre, Alignment.LEADING)
						.addComponent(labelDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblMasquedate, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMasqueauteur, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMasquetags, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelTitre)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(labelAuteur, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMasqueauteur, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(68, Short.MAX_VALUE)
							.addComponent(lblMasquedate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMasquetags, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelTags, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(110)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(labelSupp, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddTagPost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxSuppTag, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSupprTagPost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboAddTag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnEditCancel))
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211,210,250));
		panel.setForeground(new Color(11,29,62));
		scrollPane.setColumnHeaderView(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		textArea.setForeground(new Color(11,29,62));
		textArea.setBackground(new Color(211,210,250));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(317, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
