package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


// rmic pterodactyle.rmi.Implementation

public class Serveur {

	public static void main(String[] args) throws RemoteException {

		LocateRegistry.createRegistry(1095);
		String cwd = System.getProperty("user.dir");
		System.setProperty("java.rmi.server.codebase", "file://" + cwd + "/");

		ServicesRmiImpl app = new ServicesRmiImpl();
		try {
			Naming.rebind("app", app);
			System.out.println("serveur lancé");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
