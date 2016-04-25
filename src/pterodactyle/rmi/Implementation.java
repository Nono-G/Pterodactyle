package pterodactyle.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Implementation extends UnicastRemoteObject implements Application  {

	private static final long serialVersionUID = 958097467225680669L;

	public Implementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUSer(String nom, String prenom) throws RemoteException {
		return nom+" "+prenom;
	}

}
