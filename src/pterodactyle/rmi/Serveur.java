package pterodactyle.rmi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import pterodactyle.coeur2.CoeurBase;


// rmic pterodactyle.rmi.ServicesRmiImpl

public class Serveur {

	public static void main(String[] args) throws IOException {
		

		LocateRegistry.createRegistry(1099);
		String cwd = System.getProperty("user.dir");
		System.setProperty("java.rmi.server.codebase", "file://" + cwd + "/");
		System.setProperty("java.security.policy", "file://" + cwd + "/bin/policy");
		String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/app";
		//String url = "rmi://37.162.110.138/app";
	    System.out.println("Enregistrement de l'objet avec l'url : " + url);

		CoeurBase app = new CoeurBase("a","b");
		try {
			System.out.println("Lancement serveur");
			Naming.rebind(url, app);
			System.out.println("serveur lancé");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
