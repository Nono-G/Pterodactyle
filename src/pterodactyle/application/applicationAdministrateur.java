package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class applicationAdministrateur extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					applicationAdministrateur frame = new applicationAdministrateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public applicationAdministrateur() {
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
		panelPresentation.setBackground(new Color(244, 244, 243));
		panelPresentation.setBounds(10, 11, 247, 107);
		contentPane.add(panelPresentation);
		panelPresentation.setLayout(null);
		
		JLabel lblLogoNomAdmin = new JLabel("");
		lblLogoNomAdmin.setIcon(new ImageIcon(applicationAdministrateur.class.getResource("/pterodactyle/application/logo-uga.png")));
		lblLogoNomAdmin.setBounds(0, 0, 247, 64);
		panelPresentation.add(lblLogoNomAdmin);
		
		JLabel lbloginAdmin = new JLabel("Login d'un admin");
		lbloginAdmin.setForeground(new Color(11, 29, 62));
		lbloginAdmin.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		lbloginAdmin.setBounds(39, 75, 170, 24);
		panelPresentation.add(lbloginAdmin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 244, 243));
		panel.setBounds(10, 129, 830, 411);
		contentPane.add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel onglet1=new JPanel();
		onglet1.setBackground(new Color(244, 244, 243));
		JPanel onglet2 = new JPanel();
		onglet2.setBackground(new Color(244, 244, 243));
		JPanel onglet3 = new JPanel();
		onglet3.setBackground(new Color(244, 244, 243));
		
		JLabel lblForum = new JLabel("Forum");
		JLabel lblCloud = new JLabel("Cloud");
		JLabel lblAdmin = new JLabel("Administrer");
		onglet1.add(lblForum);
		onglet2.add(lblCloud);
		onglet3.add(lblAdmin);
		tabbedPane.add("Forum ",onglet1);
		tabbedPane.add("Cloud ",onglet2);
		tabbedPane.add("Administrer ",onglet3);
		
	}
}
