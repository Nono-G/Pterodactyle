package pterodactyle.test;

import java.io.*;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;

public class TestFich {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utilisateur u = new Utilisateur("Nono", "Goudian", "goudn", "capre");
		
		Fichier f = new Fichier("t.iso", u);
		
		//Copy
		
		try( FileOutputStream fos = new FileOutputStream(new File("sauv/t.iso-copy"))){
			byte[] buffer;
			int n=0;
			while(true){
				try{
					Object[] donnees =f.obtenirTranche(n, 104857);
					buffer = (byte[]) donnees[1];
					fos.write(buffer, 0, (int)donnees[0]);
					/**/System.out.println("buff "+donnees[0]);
					n++;
				}catch(ExceptionEchangeableFichierFini e){break;}
			}
		}catch(IOException e){e.printStackTrace();}
		System.out.println("Fini");
		
	}

}
