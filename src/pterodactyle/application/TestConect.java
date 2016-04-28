package pterodactyle.application;

import java.awt.EventQueue;
import java.rmi.RemoteException;

import pterodactyle.rmi.Client2;

public class TestConect {
	
	/**
	 * Launch the application.
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		Client2 client = new Client2("127.0.0.1");
		app = client.recupererApp();
		System.out.println(app.test());

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationPterodactyle window = new ApplicationPterodactyle();
					window.frameConnection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TestConect() {
		// TODO Auto-generated constructor stub
	}

}
