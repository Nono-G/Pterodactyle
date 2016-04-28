package pterodactyle.application;

import java.awt.EventQueue;

public class MainEdition {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditionPost frame = new EditionPost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainEdition() {
		// TODO Auto-generated constructor stub
	}

}
