package pterodactyle.application;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ConfirmationTelech extends JFrame{
	
	int temps;
	String nomFichier;
	
	public ConfirmationTelech(int temps, String nomFichier) {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.ORANGE);
		setBackground(Color.ORANGE);
		setResizable(false);
		this.temps=temps;
		this.nomFichier = nomFichier;
		initialisation();
	}	
		
		public void initialisation() {
			setTitle("T\u00E9l\u00E9chargement termin\u00E9");
			
			JLabel lblLabelmessageconfirmation = new JLabel("Votre téléchargement du fichier "+nomFichier+" depuis le serveur est fini en "+temps+"secondes");
			getContentPane().add(lblLabelmessageconfirmation, BorderLayout.NORTH);
			
			JButton btnBtnok = new JButton("btnOk");
			btnBtnok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			getContentPane().add(btnBtnok, BorderLayout.SOUTH);
		}
	}

