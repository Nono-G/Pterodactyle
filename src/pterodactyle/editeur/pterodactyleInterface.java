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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pterodactyleInterface {

	private JFrame framePtrodactyle;
	private JTextField textField;
	private static Editeur editeur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		editeur = new Editeur();
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
		framePtrodactyle.setIconImage(Toolkit.getDefaultToolkit().getImage(pterodactyleInterface.class.getResource("/pterodactyle/editeur/output.png")));
		framePtrodactyle.getContentPane().setFont(new Font("Book Antiqua", Font.ITALIC, 14));
		framePtrodactyle.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		framePtrodactyle.getContentPane().setBackground(Color.WHITE);
		framePtrodactyle.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Éditeur Ptérodactyle");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setIcon(new ImageIcon(pterodactyleInterface.class.getResource("/pterodactyle/editeur/Ptero.jpg")));
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 264, 528, 126);
		framePtrodactyle.getContentPane().add(panel_1);
		
		//Les implementations
		JLabel labellzjfl = new JLabel("Options d'implémentation");
		labellzjfl.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 14));
		labellzjfl.setBounds(10, 11, 178, 27);
		panel_1.add(labellzjfl);
		
		JLabel lblImplmentationDunUtilisateur = new JLabel(" Implémentation d'un utilisateur");
		lblImplmentationDunUtilisateur.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblImplmentationDunUtilisateur.setBounds(10, 49, 188, 14);
		panel_1.add(lblImplmentationDunUtilisateur);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(editeur.implementation("utilisateur")));
		comboBox.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		comboBox.setBounds(10, 74, 178, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(editeur.implementation("coeur")));
		comboBox_1.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		comboBox_1.setBounds(371, 74, 116, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblMoteur = new JLabel("Traitement des données");
		lblMoteur.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblMoteur.setBounds(371, 49, 188, 14);
		panel_1.add(lblMoteur);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Defaut>","Login, MotDePasse", "Session"}));
		comboBox_2.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		comboBox_2.setBounds(207, 74, 146, 20);
		panel_1.add(comboBox_2);
		
		JLabel lblSystmeDauthentification = new JLabel("Système d'authentification");
		lblSystmeDauthentification.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblSystmeDauthentification.setBounds(208, 49, 188, 14);
		panel_1.add(lblSystmeDauthentification);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnNewButton.setBounds(250, 414, 89, 23);
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				editeur.creerS(textField.getText(), (String)comboBox_1.getSelectedItem() );
				System.out.println((String)comboBox.getSelectedItem());
				editeur.creerC(textField.getText(), (String)comboBox.getSelectedItem() );
				System.out.println((String)comboBox_1.getSelectedItem());
			}
			
		});
		
		
		
		framePtrodactyle.getContentPane().add(btnNewButton);
		framePtrodactyle.setBackground(Color.WHITE);
		framePtrodactyle.setTitle("Ptérodactyle");
		framePtrodactyle.setBounds(100, 100, 621, 490);
		framePtrodactyle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
