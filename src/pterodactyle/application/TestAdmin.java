package pterodactyle.application;

import java.awt.EventQueue;

public class TestAdmin {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationAdministrateur frame = new ApplicationAdministrateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TestAdmin() {
		// TODO Auto-generated constructor stub
	}

}
