package pterodactyle.application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class AnnuaireIHM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnnuaireIHM frame = new AnnuaireIHM();
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
	public AnnuaireIHM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnnuaireIHM.class.getResource("/pterodactyle/application/ressourcesImages/logoSizeFunkySkeleton.png")));
		setTitle("Annuaire");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244,244,243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(11,29,62), 3, true));
		
		JButton btnNewButton = new JButton("Voir profil");
		btnNewButton.setBackground(new Color(11,29,62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		
		JLabel lblTitreAnnuaire = new JLabel("Annuaire");
		lblTitreAnnuaire.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING)
						.addComponent(lblTitreAnnuaire, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitreAnnuaire)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
		);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 205));
		scrollPane.setViewportView(panel);
		
		JList list = new JList();
		list.setBackground(new Color(211,210,250));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Login user "};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(list, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
}
