package pterodactyle.rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class server {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1010);
			Implementation app = new Implementation();
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, app);

			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
