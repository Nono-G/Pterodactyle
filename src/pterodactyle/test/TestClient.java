package pterodactyle.test;

import java.rmi.RemoteException;

import pterodactyle.coeur._ServicesCoeur;
import pterodactyle.rmi.Client;

public class TestClient {

	public static void main(String[] args) throws RemoteException {
		Client client = new Client("rmi://127.0.0.1/app");
		_ServicesCoeur app = client.recupererApp();

	}
}
