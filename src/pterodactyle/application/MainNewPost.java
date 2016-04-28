package pterodactyle.application;

import java.awt.EventQueue;

public class MainNewPost {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauPost frame = new NouveauPost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainNewPost() {
		// TODO Auto-generated constructor stub
	}

}
