package pterodactyle.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public class TestDossier {

	public static void tr(String t){
		System.out.println(t);
	}
	
	
	public static void main(String[] args) {
		
		Utilisateur u = new Utilisateur("Nono", "Goudian", "goudn", "capre", false);
		Tag t1 = new Tag("CHSCT2016");
		Tag t2 = new Tag("SyndicInfo");
		
		Dossier d = new Dossier("ressources", u, null);
		d.ajouterTag(t1);
		d.ajouterTag(t2);
		System.out.println(d.voirTags());
		
		Fichier f = new Fichier("t.avi", u, d);
		d.ajouterDans(f);
		d.sauver();
		
		Dossier d2 = (Dossier)($Echangeable.charger("ressources"));
		Fichier f2 = (Fichier)d2.get(0);
		tr(f2.voirTags());
		
		
		//Copy
		
		try( FileOutputStream fos = new FileOutputStream(new File("sauv/t.avi-copy"))){
			byte[] buffer;
			int n=0;
			while(true){
				try{
					Object[] donnees =f2.obtenirTranche(n, 104857);
					buffer = (byte[]) donnees[1];
					fos.write(buffer, 0, (int)donnees[0]);
					n++;
				}catch(ExceptionEchangeableFichierFini e){break;}
			}
		}catch(IOException e){e.printStackTrace();}
		
		
		System.out.println("Fini");
		
	}
}
