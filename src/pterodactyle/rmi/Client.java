package pterodactyle.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://127.0.1.1/app";
		ServicesRmi r = (ServicesRmi)Naming.lookup(url);
		String s = r.getUSer("maxime", "silvestre");
		System.out.println(s);

	}

}
