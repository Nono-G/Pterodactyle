package pterodactyle.application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ConfirmationTelech extends JFrame{
	
	int temps;
	String nomFichier;
	
	public ConfirmationTelech(int temps, String nomFichier) {
		getContentPane().setForeground(new Color(11,29,62));
		getContentPane().setFont(new Font("Book Antiqua", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmationTelech.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setFont(new Font("Book Antiqua", Font.BOLD, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(244,244,243));
		setBackground(new Color(244,244,243));
		setResizable(false);
		this.temps=temps;
		this.nomFichier = nomFichier;
		initialisation();
	}	
		
		public void initialisation() {
			setTitle("T\u00E9l\u00E9chargement termin\u00E9");
			getContentPane().setLayout(null);
			
			JLabel lblLabelmessageconfirmation = new JLabel("Votre téléchargement du fichier"+nomFichier+" ");
			lblLabelmessageconfirmation.setBounds(39, 70, 395, 32);
			lblLabelmessageconfirmation.setBackground(new Color(244,244,243));
			lblLabelmessageconfirmation.setForeground(new Color(11,29,62));
			lblLabelmessageconfirmation.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			getContentPane().add(lblLabelmessageconfirmation);
			
			JButton btnBtnok = new JButton("OK");
			btnBtnok.setForeground(new Color(255, 255, 255));
			btnBtnok.setFont(new Font("Book Antiqua", Font.BOLD, 13));
			btnBtnok.setBackground(new Color(11,29,62));
			btnBtnok.setBounds(151, 237, 143, 23);
			btnBtnok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			getContentPane().add(btnBtnok);
			
			JLabel lblNewLabel = new JLabel(" depuis le serveur est fini en "+temps+" secondes");
			lblNewLabel.setBackground(new Color(244,244,243));
			lblNewLabel.setForeground(new Color(11,29,62));
			lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
			lblNewLabel.setBounds(44, 120, 348, 32);
			getContentPane().add(lblNewLabel);
		}
	}

