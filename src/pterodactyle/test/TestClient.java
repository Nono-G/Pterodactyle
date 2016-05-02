package pterodactyle.test;

import java.rmi.RemoteException;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.rmi.Client2;

public class TestClient {

	public static void main(String[] args) throws RemoteException {
		Client2 client = new Client2("rmi://127.0.0.1/app");
		_ServicesCoeur app = client.recupererApp();

	}
}
