package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pterodactyle.coeur._ServicesCoeur;

public class Client {

	private String adresseIPServeur;
	private _ServicesCoeur stub;
	String url;
	_ServicesCoeur r;

	public Client(String ip) throws RemoteException {
		this.adresseIPServeur = ip;
		String cwd = System.getProperty("user.dir");
		System.out.println("PWD = " + cwd);

		System.setProperty("java.security.policy", "file:/" + cwd + "/policy_file");
		System.out.println("policy = " + System.getProperty("java.security.policy"));

		// Connexion au serveur
		try {
			Registry registry = LocateRegistry.getRegistry(adresseIPServeur, 1099);
			System.out.println(registry);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			this.r = (_ServicesCoeur) Naming.lookup("rmi://" + adresseIPServeur + "/app");
			System.out.println(this.r);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public _ServicesCoeur recupererApp() {
		return r;
	}

	public String recupererUrl() {
		return this.url;
	}

}
