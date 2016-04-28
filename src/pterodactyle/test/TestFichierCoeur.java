package pterodactyle.test;

import java.io.*;
import java.rmi.*;

import pterodactyle.coeur2.*;
import pterodactyle.echangeable.ExceptionEchangeableFichierFini;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.echangeable.ExceptionEchangeablePasDeTag;
import pterodactyle.utilisateur.*;

public class TestFichierCoeur {

	public static void main (String[] args){
	try{
		CoeurBase c = new CoeurBase("Petry", "abc");
		c.creerTag("dauphins", "Petry", "abc");
		c.creerFichier("do", null, "dauphins", "Petry", "abc");
		upload("testlocal/down", "do", 15, c);
		
		c.sauvegarder("sauv/dumpCoeur", "Petry", "abc");
		c=null;
		
		CoeurBase d = new CoeurBase("sauv/dumpCoeur");
		download("testlocal/down2", "do", 5, d);
		
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
	
	private static void download(String urlLocal, String urlServeur, int tailleBuffer, _ServicesCoeur c){
		File local = new File(urlLocal);
		try(FileOutputStream fos = new FileOutputStream(local)){
			Object[] data;
			byte[] buffer;
			int n=0;
			while(true){
				try{
					try {
						data = c.trancheFichier(urlServeur, n, tailleBuffer, "Petry", "abc");
						buffer = (byte[]) data[1];
						fos.write(buffer, 0, (int)data[0]);
						n++;
					}catch(ExceptionEchangeableMauvaisType e) {e.printStackTrace();}
				}catch(ExceptionEchangeableFichierFini e){break;}
			}
		}catch(IOException e){System.out.println("Fichier local erreur");e.printStackTrace();};
	}
}
