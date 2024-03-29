package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import pterodactyle.coeur._ServicesCoeur;
import pterodactyle.echangeable.ExceptionEchangeablePasDeTag;
import pterodactyle.echangeable.Post;
import pterodactyle.echangeable.Tag;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import java.awt.Toolkit;

public class NouveauPost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel_2;
	private _ServicesCoeur app;
	private String loginCourant;
	private String motDePasseCourant;
	private List<String> tagEnAjout;



	public NouveauPost(_ServicesCoeur app, String loginCourant, String motDePasseCourant) {
		setResizable(false);
		this.loginCourant = loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app = app;
		tagEnAjout = new ArrayList<String>(3);
		initialisation();
	}

	/**
	 * Create the frame.
	 */
	public void initialisation() {
		setTitle("Ajout d'un post");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NouveauPost.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setBackground(new Color(244,244,243));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(11,29,62));
		btnAnnuler.setForeground(new Color(255,255,255));
		btnAnnuler.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		JLabel lblTitreDeVotre = new JLabel("Titre de votre post :");
		lblTitreDeVotre.setForeground(new Color(11,29,62));
		lblTitreDeVotre.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblTagPost = new JLabel("Ajoutez des tags :");
		lblTagPost.setForeground(new Color(11, 29, 62));
		lblTagPost.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(11,29,62));
		comboBox.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(refreshTagsEcriture()));
		
		JList<String> listTagAjoutes = new JList<String>();
		AbstractListModel<String> almListTagsAjoutes = new AbstractListModel<String>() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
			//public void addElement(String s){
			//	this.values.add(s);
			//}
		};
		listTagAjoutes.setModel(almListTagsAjoutes);
		listTagAjoutes.setBackground(new Color(211,210,250));
		
		JButton btnAddTagPost = new JButton("OK");
		btnAddTagPost.setIcon(null);
		btnAddTagPost.setForeground(Color.WHITE);
		btnAddTagPost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnAddTagPost.setBackground(new Color(11, 29, 62));
		final JComboBox ComboBoxInBtnAddTagPost = comboBox;
		final JList<String> jListInBtnAddTagPost = listTagAjoutes;
		//final AbstractListModel almInBtnAddTagPost = almListTagsAjoutes;
		btnAddTagPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ajout = ComboBoxInBtnAddTagPost.getSelectedItem().toString();
				if( ! tagEnAjout.contains(ajout))tagEnAjout.add(ajout);
				jListInBtnAddTagPost.setListData(refreshTagAjoute());
			}
		});
		
		JLabel lblListTagPres = new JLabel("Liste des tags ajoutés :");
		lblListTagPres.setForeground(new Color(11, 29, 62));
		lblListTagPres.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(11,29,62));
		btnAjouter.setForeground(new Color(255,255,255));
		btnAjouter.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = textField.getText();
				if( titre.length() != 0 && tagEnAjout.size()!=0){
					String url = System.currentTimeMillis()+titre;
					try {
						app.creerPost(url, titre, tagEnAjout.get(0), loginCourant, motDePasseCourant);
						int i = 1;
						while( i < tagEnAjout.size()){
							try{
							app.ajouterTagSurEchangeable(url, tagEnAjout.get(i), loginCourant, motDePasseCourant);
							}catch(RemoteException re){//TODO
								re.printStackTrace();
							}catch(Exception exep){exep.printStackTrace();/*Néant. Exception impossible compte tenu des verification précédentes*/}
							i++;
						}
					} catch (RemoteException | ExceptionEchangeablePasDeTag e1) {e1.printStackTrace();}
					dispose();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitreDeVotre, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTagPost, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAddTagPost)))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(lblListTagPres, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnAnnuler)
							.addPreferredGap(ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
							.addComponent(btnAjouter, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitreDeVotre, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTagPost, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListTagPres, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddTagPost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAnnuler)
						.addComponent(btnAjouter))
					.addGap(9))
		);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(listTagAjoutes, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(listTagAjoutes, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		btnAnnuler.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});	
	}
	
	protected String[] refreshTagsEcriture(){
		Set<Tag> tags = null;
		int i = 0;
		try {
			tags = app.getTagsDroitCreation(loginCourant, motDePasseCourant);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] nomsTags = new String[tags.size()];
		
		for(Tag p : tags){
			nomsTags[i] = p.toString();
			i++;
		}
		return nomsTags;
	}
	
	protected String[] refreshTagAjoute(){
		String[] nomsTags = new String[tagEnAjout.size()];
		int i=0;
		for(String t: tagEnAjout){
			nomsTags[i] = t;
			i++;
		}
		return nomsTags;
	}
}

