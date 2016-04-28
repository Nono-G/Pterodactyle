package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import pterodactyle.coeur2._ServicesCoeur;

public class Client2 {

	String url;
	_ServicesCoeur r;

	public Client2(String url) throws RemoteException {
		this.url = url;
		try {
			this.r = (_ServicesCoeur) Naming.lookup(this.url);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public _ServicesCoeur recupererApp(){return r;}
	
	public String recupererUrl(){return this.url;}

}
