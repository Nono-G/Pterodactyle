package pterodactyle.echangeable;

import java.io.File;
import java.io.*;

import pterodactyle.utilisateur.Utilisateur;

public class Fichier extends $DossierOuFichier{

	private static final long serialVersionUID = 4875854715778443691L;

	
	public Fichier(String nom, Utilisateur ut, Dossier pere) {
		super(nom, ut, pere);
	}
	
	//Renvoie un couple composé du nombre d'octets lu et de la n-ieme tranche de 'tailleTampon' octets du fichier.
	public Object[] obtenirTranche(int n, int tailleTampon) throws ExceptionEchangeableFichierFini {
		byte[] buffer = new byte[tailleTampon];
		Object[] ret = new Object[2];
		File f = new File("sauv/"+this.url);
		try (FileInputStream fis = new FileInputStream(f)) {
			if(n*tailleTampon > f.length()) {throw new ExceptionEchangeableFichierFini();}
			fis.skip(n*tailleTampon);
	        int t = fis.read(buffer, 0, tailleTampon);
	        ret[0]=t;
	        ret[1]=buffer;
	    }catch(IOException e){e.printStackTrace();}
		return ret;
	}

	//Renvoie false car l'objet est un fichier
	@Override
	public boolean estDossier() {
		return false;
	}
	
}
