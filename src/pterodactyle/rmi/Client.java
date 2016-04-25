package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://127.0.1.1/app";
		Remote r = Naming.lookup(url);
		if (r instanceof ServicesRmiImpl) {
			String s = ((ServicesRmiImpl) r).getUSer("maxime", "silvestre");
			System.out.println(s);
		}

	}

}
