package pterodactyle.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pterodactyle.coeur2._ServicesCoeur;


public class Client {
	
	private static String adresseIPServeur = "193.48.34.19";
	private static _ServicesCoeur stub;


	public static void main(String[] args) throws NotBoundException, IOException {
		
		String cwd = System.getProperty("user.dir");
		System.out.println("PWD = " + cwd);
		
		System.setProperty ("java.security.policy", "file:/"+cwd+"/policy_file");
		System.out.println("policy = " + System.getProperty ("java.security.policy"));

		//Connexion au serveur
		try {
			Registry registry = LocateRegistry.getRegistry(adresseIPServeur,1099);
			System.out.println(registry);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			stub = (_ServicesCoeur) Naming.lookup("rmi://"+adresseIPServeur+"/Together");
			System.out.println(stub);
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
		
		try {
			System.out.println(stub.test());
			System.out.println("Client connecté!");					// DEBUG
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
