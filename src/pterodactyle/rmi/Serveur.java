package pterodactyle.rmi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import pterodactyle.coeur2.CoeurBase;

// rmic pterodactyle.rmi.ServicesRmiImpl

public class Serveur {

	public static void main(String[] args) throws IOException {

		LocateRegistry.createRegistry(1099);
		String cwd = System.getProperty("user.dir");

		System.setProperty("java.rmi.server.codebase", "file://" + cwd + "/");
		System.setProperty("java.rmi.server.hostname", "");
		System.setProperty("java.security.policy", "file://" + cwd + "/bin/policy");
		String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":1099/app";
		//String url = "rmi://192.168.1.89/app";
		System.out.println("Enregistrement de l'objet avec l'url : " + url);

		CoeurBase app = new CoeurBase("silvemax", "12345");
		try {
			System.out.println("Lancement serveur");
			Naming.rebind("app", app);
			System.out.println("serveur lancé");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
