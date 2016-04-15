package pterodactyle.editeur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class pterodactyleInterface {

	private JFrame framePtrodactyle;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pterodactyleInterface window = new pterodactyleInterface();
					window.framePtrodactyle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pterodactyleInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePtrodactyle = new JFrame();
		framePtrodactyle.setIconImage(Toolkit.getDefaultToolkit().getImage(pterodactyleInterface.class.getResource("/pterodactyle/editeur/Ptero.jpg")));
		framePtrodactyle.getContentPane().setFont(new Font("Book Antiqua", Font.ITALIC, 14));
		framePtrodactyle.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		framePtrodactyle.getContentPane().setBackground(Color.WHITE);
		framePtrodactyle.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Éditeur Ptérodactyle");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setIcon((Icon) new ImageIcon("Ptero.jpg").getImage());
		lblNewLabel.setBounds(10, 11, 565, 167);
		framePtrodactyle.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(175, 204, 86, 20);
		framePtrodactyle.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDeVotre = new JLabel(" Nom de votre client:");
		lblNomDeVotre.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 14));
		lblNomDeVotre.setBounds(30, 203, 138, 20);
		framePtrodactyle.getContentPane().add(lblNomDeVotre);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 235, 528, 127);
		framePtrodactyle.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxSelectionnerToutesLes = new JCheckBox("Toutes les options");
		chckbxSelectionnerToutesLes.setBounds(6, 45, 199, 23);
		panel.add(chckbxSelectionnerToutesLes);
		chckbxSelectionnerToutesLes.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		chckbxSelectionnerToutesLes.setBackground(Color.WHITE);
		
		JCheckBox checkBox2 = new JCheckBox("Échange de fichiers");
		checkBox2.setBounds(6, 71, 253, 23);
		panel.add(checkBox2);
		checkBox2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		checkBox2.setBackground(Color.WHITE);
		
		JCheckBox chckbxSelectionnerLoptionMessagerie = new JCheckBox("Messagerie interne");
		chckbxSelectionnerLoptionMessagerie.setBounds(6, 97, 253, 23);
		panel.add(chckbxSelectionnerLoptionMessagerie);
		chckbxSelectionnerLoptionMessagerie.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		chckbxSelectionnerLoptionMessagerie.setBackground(Color.WHITE);
		
		JCheckBox checkBox3 = new JCheckBox("Prise de rendez-vous");
		checkBox3.setBounds(261, 45, 159, 23);
		panel.add(checkBox3);
		checkBox3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		checkBox3.setBackground(Color.WHITE);
		
		JCheckBox chckbxSelectionnerLoptionForum = new JCheckBox("Forum");
		chckbxSelectionnerLoptionForum.setBounds(261, 71, 178, 23);
		panel.add(chckbxSelectionnerLoptionForum);
		chckbxSelectionnerLoptionForum.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		chckbxSelectionnerLoptionForum.setBackground(Color.WHITE);
		
		JCheckBox checkBox5 = new JCheckBox("Annuaire");
		checkBox5.setBounds(261, 97, 159, 23);
		panel.add(checkBox5);
		checkBox5.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		checkBox5.setBackground(Color.WHITE);
		
		JLabel lblOptions = new JLabel("Options générales");
		lblOptions.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 14));
		lblOptions.setBounds(10, 11, 137, 27);
		panel.add(lblOptions);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 390, 528, 121);
		framePtrodactyle.getContentPane().add(panel_1);
		
		JLabel labellzjfl = new JLabel("Options d'implémentation");
		labellzjfl.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 14));
		labellzjfl.setBounds(10, 11, 178, 27);
		panel_1.add(labellzjfl);
		
		JLabel lblImplmentationDunUtilisateur = new JLabel(" Implémentation d'un utilisateur");
		lblImplmentationDunUtilisateur.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblImplmentationDunUtilisateur.setBounds(10, 49, 188, 14);
		panel_1.add(lblImplmentationDunUtilisateur);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Défaut>", "Specific user implementation"}));
		comboBox.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		comboBox.setBounds(10, 74, 178, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SQL", "XML"}));
		comboBox_1.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		comboBox_1.setBounds(371, 74, 116, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblMoteur = new JLabel("Traitement des données");
		lblMoteur.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblMoteur.setBounds(371, 49, 188, 14);
		panel_1.add(lblMoteur);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Défaut>", "Mot de passe", "Session"}));
		comboBox_2.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		comboBox_2.setBounds(207, 74, 146, 20);
		panel_1.add(comboBox_2);
		
		JLabel lblSystmeDauthentification = new JLabel("Système d'authentification");
		lblSystmeDauthentification.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblSystmeDauthentification.setBounds(208, 49, 188, 14);
		panel_1.add(lblSystmeDauthentification);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnNewButton.setBounds(250, 560, 89, 23);
		framePtrodactyle.getContentPane().add(btnNewButton);
		framePtrodactyle.setBackground(Color.WHITE);
		framePtrodactyle.setTitle("Ptérodactyle");
		framePtrodactyle.setBounds(100, 100, 621, 633);
		framePtrodactyle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
