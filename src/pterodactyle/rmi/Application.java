package pterodactyle.rmi;

import java.rmi.*;

import pterodactyle.utilisateur.Utilisateur;

public interface Application extends Remote{
	
	public Utilisateur getUSer(String nom, String prenom) throws RemoteException;

}
