package pterodactyle.test;

import java.io.*;
import java.rmi.*;

import pterodactyle.coeur2.*;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.echangeable.ExceptionEchangeablePasDeTag;
import pterodactyle.utilisateur.*;

public class TestFichierCoeur {

	public static void main (String[] args){
	try{
		CoeurBase c = new CoeurBase("Petry", "abc");
		c.creerTag("dauphins", "Petry", "abc");
		c.creerFichier("t.avi", null, "dauphins", "Petry", "abc");
		upload("testlocal/t.avi", "t.avi", 10000000, c);
		
	}catch(Exception e){e.printStackTrace();}
	
	
	}
	
	private static void tr (String t){
		System.out.println(t);
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
				c.ecrireTranche(data, urlServeur, "Petry", "abc");
				i--;
				System.out.println(""+data[0]);
			}
		}catch(IOException e){e.printStackTrace();}
	}
}
