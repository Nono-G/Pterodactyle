package pterodactyle.test;

import java.io.*;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;

public class TestFich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utilisateur u = new Utilisateur("Nono", "Goudian", "goudn", "capre");
		
		Fichier f = new Fichier("t.png", u);
		
		//Copy
		
		try( FileOutputStream fos = new FileOutputStream(new File("sauv/t.png-copy"))){
			byte[] buffer;
			int n=0;
			while(true){
				try{
					buffer = f.obtenirTranche(n);
					fos.write(buffer);
					n++;
				}catch(ExceptionEchangeableFichierFini e){break;}
			}
		}catch(IOException e){e.printStackTrace();}
		
	}

}
