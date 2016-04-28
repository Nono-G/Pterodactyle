package pterodactyle.application;

import java.awt.EventQueue;

public class testUsuer {
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

	public testUsuer() {
		// TODO Auto-generated constructor stub
	}

}
