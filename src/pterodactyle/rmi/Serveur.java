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

import pterodactyle.coeur.CoeurBase;
import pterodactyle.coeur._ServicesCoeur;
import pterodactyle.echangeable.ExceptionEchangeableTagExistant;
import pterodactyle.utilisateur.AdministrateurException;

// rmic pterodactyle.rmi.ServicesRmiImpl

public class Serveur {
	
	private static String hostname = "127.0.0.1";

	public static void main(String[] args) throws IOException, AdministrateurException, ExceptionEchangeableTagExistant {


		String cwd = System.getProperty("user.dir");
		System.out.println("PWD = " + cwd);


		System.setProperty("java.rmi.server.hostname", hostname); 
		System.setProperty("java.rmi.server.codebase", "file:/" + cwd + "/bin");
		System.out.println("codebase = " + System.getProperty("java.rmi.server.codebase"));

		System.setProperty("java.security.policy", "file:/" + cwd + "/bin/policy_file");
		System.out.println("policy = " + System.getProperty("java.security.policy"));

		_ServicesCoeur skeleton = (_ServicesCoeur) new CoeurBase("admin","admin");
		skeleton.creerTag("compta", "admin", "admin");
		skeleton.creerTag("eco", "admin", "admin");
		skeleton.creerTag("ihm", "admin", "admin");
		LocateRegistry.createRegistry(1099);
		Naming.rebind("app", skeleton);

	}
}
