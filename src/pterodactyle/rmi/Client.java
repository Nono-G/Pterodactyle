package pterodactyle.rmi;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import pterodactyle.coeur2._ServicesCoeur;


public class Client {


	public static void main(String[] args) throws NotBoundException, IOException {
		String url = "rmi://192.168.137.228/app";		
		_ServicesCoeur r = (_ServicesCoeur) Naming.lookup(url);
		System.out.println("coucou");
		String test = r.test();
		System.out.println(test);
	}

}
