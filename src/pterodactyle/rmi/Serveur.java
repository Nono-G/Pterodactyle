package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


// rmic pterodactyle.rmi.Implementation

public class Serveur {

	public static void main(String[] args) throws RemoteException {
		// Positionner le chemin de recherche des classes RMI sur le répertoire
		// courant
		LocateRegistry.createRegistry(1098);
		String cwd = System.getProperty("user.dir");
		System.out.println("PWD = " + cwd);
		System.setProperty("java.rmi.server.codebase", "file://" + cwd + "/");
		System.out.println("codebase = " + System.getProperty("java.rmi.server.codebase"));

		// Compteur héritant de UnicastRemoteObject (automatiquement visible)
		ServicesRmiImpl app = new ServicesRmiImpl();
		try {
			Naming.rebind("app", app);
			System.out.println("serveur lancé");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
