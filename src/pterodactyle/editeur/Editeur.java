package pterodactyle.editeur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Editeur {

	protected String corps = "";
	protected String nomClient = "";
	
	public Editeur(String nomProjet){
		this.nomClient = nomProjet;
		String chemin = "src/" +nomProjet;
		File f = new File( chemin);
		f.mkdir();
		
		f = new File(chemin +"/Reseau");
		f.mkdir();
		
		constcorps(nomProjet, "Serveur");
		//System.out.println("Dossier cree");
		creerServeur(chemin+"/Reseau/Serveur.java", corps);
		
		corps = "";
		constcorps(nomProjet, "Client");
		//System.out.println("Dossier cree");
		creerServeur(chemin+"/Reseau/Client.java", corps);
	}

	private void constcorps(String nomProjet, String chemin){
		BufferedReader buffRead = null; 
		InputStream in; 
		InputStreamReader inR;
		FileReader f;
		String buffer;
		try{
			in = new FileInputStream(new File("src/pterodactyle/rmi/"+chemin+".java"));
			inR = new InputStreamReader(in);
			buffRead = new BufferedReader(inR);
			buffer = buffRead.readLine();
			while(buffer != null){
				corps = corps + buffer + "\n";
				buffer = buffRead.readLine();				
			}
		}catch(FileNotFoundException e){e.printStackTrace();
		}catch(IOException e){e.printStackTrace();}	
		corps = corps.replaceFirst("pterodactyle", nomProjet+".Reseau");
		corps = corps.replaceFirst(".rmi", "");
		
	}
	
	private void creerServeur(String chemin, String contenu){
		File serveur = new File(chemin);
		FileWriter writer ; 
		try{
			writer = new FileWriter(serveur);
			writer.write(contenu);
			writer.close();
		}catch(FileNotFoundException e){e.printStackTrace();
		}catch(IOException e){e.printStackTrace();}	
		
	}

	public boolean repertoireExiste(String nom){
		File repertoire = new File("src/"+nomClient+"/" +nom);
		return repertoire.exists();
	}
		
	public String[] choixImpl(String impl){
		int i = 0; 
		int j = 0;
		String[] nomImpl;
		File repertoire = new File("src/"+nomClient+"/"+impl);
		//System.out.println(repertoireUtilisateur.listFiles().length);
		if(repertoireExiste(impl) && repertoire.listFiles().length != 0 ){
			nomImpl = new String[repertoire.listFiles().length - fichierCache(repertoire) + 1] ;
			System.out.println(repertoire.listFiles().length );
			System.out.println(repertoire.listFiles().length - fichierCache(repertoire) + 1);
			nomImpl[j] = "<Default>";
			while( i < (repertoire.listFiles().length) && repertoire.listFiles()[i].isFile()){
				if(repertoire.listFiles()[i].getName().charAt(0) != '.'){
					j++;
					nomImpl[j] = repertoire.listFiles()[i].getName();
				}
				System.out.println(repertoire.listFiles()[i].getName());
				i++;
			}
			return nomImpl;
		}else{
			nomImpl = new String[1];
			nomImpl[0] = "<Default>";
			return nomImpl;
		}

	}
	
	public int fichierCache(File dossier){
		int i = 0 ;
		int nbreFicCache = 0; 
		while(i < dossier.listFiles().length){
			if(dossier.listFiles()[i].getName().charAt(0) == '.'){
				nbreFicCache++;
			}
			i++;
		}
		return nbreFicCache;
	}
	

	
}
