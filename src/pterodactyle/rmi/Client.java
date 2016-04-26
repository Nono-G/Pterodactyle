package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://127.0.1.1/app";
		ServicesRmi r = (ServicesRmi)Naming.lookup(url);
		
		//r.creerUtilisateur("Silvestre", "Maxime", "silvemax", "toto", false, utilisateurCourant);
		//System.out.println(s);

	}

}
