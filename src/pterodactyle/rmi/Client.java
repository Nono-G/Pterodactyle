package pterodactyle.rmi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import pterodactyle.coeur2._ServicesCoeur;


public class Client {

	public static void main(String[] args) throws NotBoundException, IOException {
		String url = "rmi://127.0.0.1/app";		
		_ServicesCoeur r = (_ServicesCoeur) Naming.lookup(url);
		String test = r.test();
		System.out.println(test);
	}

}
