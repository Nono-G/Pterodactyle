package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pterodactyle.coeur2._ServicesCoeur;
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

	/**
	 * Launch the application.
	 */
	public EditionPost(_ServicesCoeur app, String loginCourant, String motDePasseCourant){
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
	public void initialisation()  {
		setTitle("Post");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditionPost.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 496);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(11,29,62));
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEditPost = new JLabel("Post : ");
		lblEditPost.setForeground(new Color(11,29,62));
		lblEditPost.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("ICI TITRE POST");
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Répondre");
		btnNewButton.setBackground(new Color(11,29,62));
		btnNewButton.setForeground(new Color(255,255,255));
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JButton btnEditCancel = new JButton("Annuler");
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEditPost)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(521, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboAddTag, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)))
							.addComponent(btnAddTagPost)
							.addGap(64)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelSupp, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxSuppTag, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSupprTagPost)
										.addComponent(btnEditCancel))))))
					.addGap(45))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEditPost)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(labelSupp, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		scrollPane.setViewportView(panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		textArea.setForeground(new Color(11,29,62));
		textArea.setBackground(new Color(211,210,250));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
