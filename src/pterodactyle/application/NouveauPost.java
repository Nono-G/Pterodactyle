package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import pterodactyle.coeur2._ServicesCoeur;
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
		this.loginCourant = loginCourant;
		this.motDePasseCourant = motDePasseCourant;
		this.app = app;
		initialisation();
		tagEnAjout = new ArrayList<String>(3);
	}
	/**
	 * Create the frame.
	 */
	public void initialisation() {
		setTitle("Ajout d'un post");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NouveauPost.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setBackground(new Color(244,244,243));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(11,29,62));
		btnAnnuler.setForeground(new Color(255,255,255));
		btnAnnuler.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(11,29,62));
		btnAjouter.setForeground(new Color(255,255,255));
		btnAjouter.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblTitreDeVotre = new JLabel("Titre de votre post :");
		lblTitreDeVotre.setForeground(new Color(11,29,62));
		lblTitreDeVotre.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblTagPost = new JLabel("Ajoutez des tags :");
		lblTagPost.setForeground(new Color(11, 29, 62));
		lblTagPost.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(11,29,62));
		comboBox.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(refreshTagsEcriture()));
		
		JList<String> listTagAjoutes = new JList<String>();
		AbstractListModel<String> almListTagsAjoutes = new AbstractListModel<String>() {
			String[] values = new String[] {"toto"};
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
				String[] nouveau = new String[] {"tit", "de", "Lomont"};
				tagEnAjout.add(ComboBoxInBtnAddTagPost.getSelectedItem().toString());
				jListInBtnAddTagPost.setListData(nouveau);
			}
		});
		
		JLabel lblListTagPres = new JLabel("Liste des tags ajoutés :");
		lblListTagPres.setForeground(new Color(11, 29, 62));
		lblListTagPres.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
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
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(lblListTagPres, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnAjouter)
							.addGap(244)
							.addComponent(btnAnnuler)))
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
							.addGap(2)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddTagPost, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAjouter)
						.addComponent(btnAnnuler))
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
					ApplicationUtilisateur ap = new ApplicationUtilisateur(app,loginCourant,motDePasseCourant);
					ap.setVisible(true);
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
}
