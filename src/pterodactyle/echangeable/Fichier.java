package pterodactyle.echangeable;

import java.io.*;

import pterodactyle.utilisateur.Utilisateur;

public class Fichier extends $DossierOuFichier{


	private int cleCreation;
	
	private Fichier(String nom, Utilisateur ut, Dossier pere, Tag t) {
		super(nom, ut, pere, t);
		this.cleCreation = (int)(System.currentTimeMillis()*Math.random());
	}
	
	//Constructeur
	public static Fichier nouveauFichier(String nom, Utilisateur ut, Dossier pere, Tag t) throws ExceptionEchangeablePasDeTag {
		if( ! (t != null))throw new ExceptionEchangeablePasDeTag();
		return new Fichier(nom, ut, pere, t);
	}
	
	//Renvoie un couple composé du nombre d'octets lu et de la n-ieme tranche de 'tailleTampon' octets du fichier.
	public Object[] obtenirTranche(int n, int tailleTampon) throws ExceptionEchangeableFichierFini {
		byte[] buffer = new byte[tailleTampon];
		Object[] ret = new Object[2];
		File f = new File("sauv/fichiers/"+this.url);
		try (FileInputStream fis = new FileInputStream(f)) {
			if(n*tailleTampon > f.length()) {throw new ExceptionEchangeableFichierFini();}
			fis.skip(n*tailleTampon);
	        int t = fis.read(buffer, 0, tailleTampon);
	        ret[0]=t;
	        ret[1]=buffer;
	    }catch(IOException e){e.printStackTrace();}
		return ret;
	}
	
	//Ecrit une tranche du fichier
	public void ecrireTranche(Object[] tranche) throws FileNotFoundException, IOException{
		try(FileOutputStream fos = new FileOutputStream(new File("sauv/fichiers/"+this.url),true)){
			fos.write((byte[])tranche[1], 0, (int)tranche[0]);
		}
	}

	//Renvoie false car l'objet est un fichier
	@Override
	public boolean estDossier() {
		return false;
	}
	
	public int getCleCreation(){
		return cleCreation;
	}
	
	@Override
	public void detruireSauvegarde(){
		super.detruireSauvegarde();
		new File("sauv/fichiers/"+url).delete();
		
	}
}
