/**
 * 
 */
package pterodactyle.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Fanny
 *
 */
public class Repondant extends UnicastRemoteObject implements Interrogeable {
	private String num;
	/**
	 * @throws RemoteException
	 */
	public Repondant() throws RemoteException {
		super();
	}


	/* (non-Javadoc)
	 * @see pterodactyle.server.rmi.Interrogeable#question()
	 */
	@Override
	public String question() throws RemoteException {
		return "réponse de :"+this;
	}

	/* (non-Javadoc)
	 * @see pterodactyle.server.rmi.Interrogeable#nom()
	 */
	@Override
	public String nom() throws RemoteException {
		return toString();
	}
	
	/**
	 * @return: le numéro du répondant
	 */
	public String toString(){
		return "Répondant :" +num;
	}
}

}
