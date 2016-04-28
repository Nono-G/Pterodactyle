package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class ApplicationUtilisateur extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationUtilisateur frame = new ApplicationUtilisateur();
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
	public ApplicationUtilisateur() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
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
		panelPresentation.setBackground(new Color(11, 29, 62));
		panelPresentation.setBounds(10, 11, 201, 107);
		contentPane.add(panelPresentation);
		panelPresentation.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(135, 206, 250));
		lblNewLabel_1.setIcon(new ImageIcon(ApplicationAdministrateur.class.getResource("/pterodactyle/application/ressourcesImages/SizedFunkySkeletoAppn.png")));
		lblNewLabel_1.setBounds(5, 5, 191, 96);
		panelPresentation.add(lblNewLabel_1);
		
		JLabel lbloginUtilisateur = new JLabel("Login d'un utilisateur");
		lbloginUtilisateur.setBounds(221, 101, 170, 24);
		contentPane.add(lbloginUtilisateur);
		lbloginUtilisateur.setForeground(new Color(11, 29, 62));
		lbloginUtilisateur.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		
		JLabel lblSmileySkeletonNetwork = new JLabel("Funky Skeleton ");
		lblSmileySkeletonNetwork.setForeground(new Color(11, 29, 62));
		lblSmileySkeletonNetwork.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblSmileySkeletonNetwork.setBounds(221, 24, 261, 34);
		contentPane.add(lblSmileySkeletonNetwork);
		
		JLabel lblMuseumNetwork = new JLabel("Museum Network");
		lblMuseumNetwork.setForeground(new Color(11, 29, 62));
		lblMuseumNetwork.setFont(new Font("Bodoni MT Black", Font.BOLD, 20));
		lblMuseumNetwork.setBounds(221, 56, 261, 34);
		contentPane.add(lblMuseumNetwork);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 129, 830, 411);
		panel.setBackground(new Color(244, 244, 243));
		contentPane.add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		
		JPanel onglet1=new JPanel();
		onglet1.setBackground(new Color(244, 244, 243));
		JPanel onglet2 = new JPanel();
		onglet2.setBackground(new Color(244, 244, 243));

		
		JLabel lblForum = new JLabel("Filtrer par tags :");
		lblForum.setBounds(10, 11, 96, 21);
		lblForum.setForeground(new Color(11, 29, 62));
		lblForum.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		tabbedPane.add("Forum ",onglet1);
		
		JTextField textField = new JTextField();
		textField.setBounds(102, 11, 108, 21);
		textField.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Endroit où on rajoute les tag");
		lblNewLabel.setForeground(new Color(11,29,62));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 42, 200, 21);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnOk.setBounds(220, 10, 69, 23);
		btnOk.setBackground(new Color(11,29,62));
		btnOk.setForeground(new Color(255, 255, 255));
		
		onglet1.setLayout(null);
		onglet1.add(lblForum);
		onglet1.add(textField);
		onglet1.add(lblNewLabel);
		onglet1.add(btnOk);
		
		JPanel panel_test = new JPanel();
		panel_test.setBorder(new LineBorder(new Color(11,29,62), 3, true));
		panel_test.setBackground(new Color(244, 244, 243));
		panel_test.setBounds(10, 68, 815, 315);
		onglet1.add(panel_test);
		tabbedPane.add("Cloud ",onglet2);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_test = new GroupLayout(panel_test);
		gl_panel_test.setHorizontalGroup(
			gl_panel_test.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
		);
		gl_panel_test.setVerticalGroup(
			gl_panel_test.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 700, 200);
		panel_1.setBackground(new Color(211,210,250));
		scrollPane.setViewportView(panel_1);
		
		JList list = new JList();
		list.setBorder(null);
		list.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		list.setBackground(new Color(211,210,250));
		list.setForeground(new Color(11, 29, 62));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"30", "40", "50", "60", "70", "80", "82", "52", "52", "56", "85", "6+", "zlf", "zefn", "zfzjglkgjlzjg", "zglkjzekgjjzgmlkjzgkj", "zgzkgjhkjheglkjzhg", "zejkghzlkjeghlkzgeh", "zegjzjegkzjehglkzjehgl", "zegjlezjgmzjegmkzje", "zg,nbzkg:z", "z,gbkzgbj*zg", "zljgjzhgkjzhgkljhgkjzh", "zjkgkjhgzklzghzgkjgz", "kzjghkljzhkjzghkjzhg", "zjhkzjghkzgjlzkjhgkjha", "azjgkjhzgkjhzlkgjhkzmjheg", "zejhgjzhegkljhz"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(list)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel_test.setLayout(gl_panel_test);
		lblForum.setBounds(10, 11, 96, 21);
		JLabel lblCloud = new JLabel("Cloud");
		onglet1.add(lblForum);
		onglet2.add(lblCloud);
		tabbedPane.add("Forum ",onglet1);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setBounds(793, 31, 32, 32);
		onglet1.add(btnRefresh);
		btnRefresh.setBackground(new Color(11,29,62));
		btnRefresh.setIcon(new ImageIcon(ApplicationUtilisateur.class.getResource("/pterodactyle/application/ressourcesImages/logorafraichir.png")));
		
		JButton btnNewPost = new JButton("Nouveau post !");
		btnNewPost.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnNewPost.setForeground(Color.WHITE);
		btnNewPost.setBackground(new Color(11, 29, 62));
		btnNewPost.setBounds(614, 41, 171, 23);
		onglet1.add(btnNewPost);
		tabbedPane.add("Cloud ",onglet2);
		btnNewPost.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					NouveauPost np = new NouveauPost();
					np.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		JLabel lblAnnuaire = new JLabel("Annuaire");
		lblAnnuaire.setForeground(new Color(11, 29, 62));
		lblAnnuaire.setFont(new Font("Book Antiqua", Font.BOLD, 17));
		lblAnnuaire.setBounds(698, 11, 95, 24);
		contentPane.add(lblAnnuaire);
		
		textField_1 = new JTextField();
		textField_1.setBounds(630, 103, 210, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRechercheParLogin = new JLabel("Recherche par login :");
		lblRechercheParLogin.setForeground(new Color(11, 29, 62));
		lblRechercheParLogin.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		lblRechercheParLogin.setBounds(676, 78, 139, 24);
		contentPane.add(lblRechercheParLogin);
		
		JButton btnGo = new JButton("Go !");
		btnGo.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(new Color(11, 29, 62));
		btnGo.setBounds(708, 44, 58, 23);
		contentPane.add(btnGo);
		
	}
}