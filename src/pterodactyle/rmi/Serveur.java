package pterodactyle.rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import pterodactyle.coeur.Utilisateurs;
import pterodactyle.coeur2.CoeurBase;


// rmic pterodactyle.rmi.ServicesRmiImpl

public class Serveur {

	public static void main(String[] args) throws RemoteException, UnknownHostException {
		
		Utilisateurs.admin();
		System.out.println(Utilisateurs.getUtilisateur("silvemax", "12345").toString());

		LocateRegistry.createRegistry(1099);
		String cwd = System.getProperty("user.dir");
		System.setProperty("java.rmi.server.codebase", "file://" + cwd + "/");
		
		//String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/app";
		String url = "rmi://130.190.65.31/app";
	    System.out.println("Enregistrement de l'objet avec l'url : " + url);
	    

		CoeurBase app = new CoeurBase();
		try {
			Naming.rebind(url, app);
			System.out.println("serveur lancé");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
