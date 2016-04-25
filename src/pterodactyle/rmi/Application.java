package pterodactyle.rmi;

import java.rmi.*;


public interface Application extends Remote{
	
	public String getUSer(String nom, String prenom) throws RemoteException;

}
