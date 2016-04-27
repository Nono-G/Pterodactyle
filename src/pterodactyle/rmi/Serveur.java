package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import pterodactyle.coeur.Utilisateurs;
import pterodactyle.coeur2.CoeurBase;


// rmic pterodactyle.rmi.ServicesRmiImpl

public class Serveur {

	public static void main(String[] args) throws RemoteException {
		
		Utilisateurs.admin();
		System.out.println(Utilisateurs.getUtilisateur("silvemax", "12345").toString());

		LocateRegistry.createRegistry(1099);
		String cwd = System.getProperty("user.dir");
		System.setProperty("java.rmi.server.codebase", "file://" + cwd + "/");

		CoeurBase app = new CoeurBase();
		try {
			Naming.rebind("app", app);
			System.out.println("serveur lancé");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
