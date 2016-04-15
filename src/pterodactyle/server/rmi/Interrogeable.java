/**
 * 
 */
package pterodactyle.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Fanny
 *
 */
public interface Interrogeable extends Remote {
	public String question() throws RemoteException;
	public String nom() throws RemoteException;
}
