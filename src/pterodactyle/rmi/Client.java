package pterodactyle.rmi;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pterodactyle.coeur2._ServicesCoeur;


public class Client {


	public static void main(String[] args) throws NotBoundException, IOException {
		String url = "rmi://192.168.137.148/app";	
		//String url = "";
		
		System.setProperty("java.rmi.server.hostname", "192.168.137.148");
		Registry registry = LocateRegistry.getRegistry(1099);
		_ServicesCoeur r = (_ServicesCoeur) registry.lookup(url);
		System.out.println("coucou");
		String test = r.test();
		System.out.println(test);
	}

}
