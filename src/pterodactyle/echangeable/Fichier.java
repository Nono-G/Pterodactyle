package pterodactyle.echangeable;

import java.io.File;
import java.io.*;

import pterodactyle.utilisateur.Utilisateur;

public class Fichier extends $EchangeableAvecTag{

	private static final long serialVersionUID = 4875854715778443691L;

	
	public Fichier(String nom, Utilisateur ut) {
		super(nom, ut);
	}
	
	//Renvoie la n-ieme tranche de 1024 octets du fichier.
	public byte[] obtenirTranche(int n) throws ExceptionEchangeableFichierFini {
		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream(new File("sauv/"+this.nom))) {
			int l;
	        if( ( l = fis.read(buffer, 1024*n, 1024)) == 0){throw new ExceptionEchangeableFichierFini();}
	    }catch(IOException e){e.printStackTrace();}
		return buffer;
	}

	
}
