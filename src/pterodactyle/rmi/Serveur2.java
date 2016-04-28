package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import pterodactyle.coeur2.CoeurBase;

public class Serveur2 {

	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy", "file:///home/silvemax/git/Pterodactyle/bin/policy");
			LocateRegistry.createRegistry(1099);

			System.out.println("Mise en place du Security Manager ...");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			//System.setProperty("java.rmi.server.codebase", "file://home/silvemax/git/Pterodactyle/bin"); 
			
			CoeurBase app = new CoeurBase("silvemax", "12345");

			//String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/app";
			String url = "rmi://192.168.1.89/app";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, app);

			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
