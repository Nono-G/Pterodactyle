package pterodactyle.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.echangeable.ExceptionEchangeablePasDeTag;
import pterodactyle.echangeable.ExceptionEchangeableTagExistant;
import pterodactyle.utilisateur.AdministrateurException;

public class TestRmiEtCoeur {

	public static void main(String[] args) throws RemoteException {
		String url = "rmi://192.168.137.228/app";	
		LocateRegistry.getRegistry("192.168.137.228", 1099);
		try {
			_ServicesCoeur r = (_ServicesCoeur) Naming.lookup(url);
			try {
				r.creerTag("dauphins", "silvemax", "12345");
			} catch (AdministrateurException | ExceptionEchangeableTagExistant e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.creerFichier("t.avi", null, "dauphins", "silvemax", "12345");
			try {
				upload("testlocal/t.avi", "t.avi", 10000000, r);
			} catch (ExceptionEchangeableMauvaisType e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionEchangeablePasDeTag e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("coucou");

	}
	
	private static void upload(String urlLocal, String urlServeur, int tailleBuffer, _ServicesCoeur c) throws ExceptionEchangeableMauvaisType{
		long i=0;
		File local = new File(urlLocal);
		try(FileInputStream fis = new FileInputStream(local)){
			Object[] data = new Object[2];
			byte[] buffer = new byte[tailleBuffer];
			i = (local.length()/tailleBuffer)+1;
			while(i != 0){
				data[0] = fis.read(buffer);
				data[1] = buffer;
				c.ecrireTranche(data, urlServeur, "silvemax", "12345");
				i--;
				System.out.println(""+data[0]);
			}
		}catch(IOException e){e.printStackTrace();}

	}
}
