package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import pterodactyle.coeur2._ServicesCoeur;


public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://127.0.1.1/app";
		_ServicesCoeur r = (_ServicesCoeur) Naming.lookup(url);
		String test = r.test();
		System.out.println(test);
	}

}
