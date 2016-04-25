package pterodactyle.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServicesRmiImpl extends UnicastRemoteObject implements  ServicesRmi  {

	private static final long serialVersionUID = 958097467225680669L;

	public ServicesRmiImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUSer(String nom, String prenom) throws RemoteException {
		
		return nom+" "+prenom;
	}
	
	public boolean verification(String login,String mdp){
		return true;
	}

}
