/**
 * 
 */
package pterodactyle.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/**
 * @author NaffyNafNaf
 *
 */
public class Serveur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String nom="";
		int nombre = 1, port=1099;
		Registry registry=null;
		if(args.length !=3){
			System.out.println("Server<nom générique des objets distants><nombre de noms> <port>");
			System.exit(1);
		}
		
		//instalation du Securtiy Manager
		try{
			if(System.getSecurityManager()==null){System.setSecurityManager(new SecurityManager());}
		}catch(Exception e){e.printStackTrace();}
	
	}
}
