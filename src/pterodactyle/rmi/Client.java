package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import pterodactyle.utilisateur.Utilisateur;


public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://127.0.1.1/app";
		Remote r = Naming.lookup(url);
		Utilisateur utilisateur = ((ServicesRmi) r).utilisateurCourant("silvemax", "12345");
		System.out.println(utilisateur.getLogin());
	}

}
