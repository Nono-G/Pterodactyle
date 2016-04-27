package pterodactyle.application;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class acceuil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public  void accueil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acceuil window = new acceuil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public acceuil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
