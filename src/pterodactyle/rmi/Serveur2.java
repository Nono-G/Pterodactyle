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
import java.util.Scanner;

import pterodactyle.coeur2.CoeurBase;
import pterodactyle.coeur2._ServicesCoeur;

// rmic pterodactyle.rmi.ServicesRmiImpl

public class Serveur2 {
	
	private static String hostname = "127.0.0.1";

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// courant
		String cwd = System.getProperty("user.dir");
		System.out.println("PWD = " + cwd);

		// Crée 2 arraylist , une pour les zones d'échange instanciés et une
		// autre pour les acteurs instanciés

		System.setProperty("java.rmi.server.hostname", hostname); 
		System.setProperty("java.rmi.server.codebase", "file:/" + cwd + "/bin");
		System.out.println("codebase = " + System.getProperty("java.rmi.server.codebase"));

		System.setProperty("java.security.policy", "file:/" + cwd + "/bin/policy_file");
		System.out.println("policy = " + System.getProperty("java.security.policy"));

		_ServicesCoeur skeleton = (_ServicesCoeur) new CoeurBase();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("app", skeleton); // publie notre instance


		/*
		 * String cwd = System.getProperty("user.dir");
		 * 
		 * System.setProperty("java.rmi.server.hostname", "193.48.34.19");
		 * System.setProperty("java.rmi.server.codebase", "file://" + cwd +
		 * "/"); System.setProperty("java.security.policy", "file://" + cwd +
		 * "/bin/policy");
		 * 
		 * CoeurBase app = new CoeurBase("silvemax", "12345");
		 * LocateRegistry.createRegistry(1099); try { System.out.println(
		 * "Lancement serveur"); Naming.rebind("App", app); System.out.println(
		 * "serveur lancé"); } catch (RemoteException | MalformedURLException e)
		 * { e.printStackTrace(); }
		 */

	}
}
