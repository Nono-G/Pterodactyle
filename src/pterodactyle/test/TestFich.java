package pterodactyle.test;

import java.io.*;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;

public class TestFich {

	public static void main(String[] args) throws ExceptionEchangeablePasDeTag {
				
		Utilisateur u = new Utilisateur("Nono", "Goudian", "goudn", "capre", false);
		Tag t1 = new Tag("CHSCT2016");
		
		Fichier f = Fichier.nouveauFichier("t.avi", u, null, t1);
		
		//Copy
		
		try( FileOutputStream fos = new FileOutputStream(new File("sauv/t.avi-copy"))){
			byte[] buffer;
			int n=0;
			while(true){
				try{
					Object[] donnees =f.obtenirTranche(n, 104857);
					buffer = (byte[]) donnees[1];
					fos.write(buffer, 0, (int)donnees[0]);
					n++;
				}catch(ExceptionEchangeableFichierFini e){break;}
			}
		}catch(IOException e){e.printStackTrace();}
		
		
		System.out.println("Fini");
		
	}

}
