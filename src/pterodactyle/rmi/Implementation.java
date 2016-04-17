package pterodactyle.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pterodactyle.utilisateur.Utilisateur;

public class Implementation extends UnicastRemoteObject implements Application  {

	private static final long serialVersionUID = 1L;

	protected Implementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Utilisateur getUSer(String nom, String prenom) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
