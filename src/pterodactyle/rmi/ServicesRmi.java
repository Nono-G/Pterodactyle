package pterodactyle.rmi;

import java.rmi.*;


public interface ServicesRmi extends Remote{
	
	public String getUSer(String nom, String prenom) throws RemoteException;

}
