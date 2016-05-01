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
import java.util.ArrayList;
import java.util.List;

public class Editeur {

	protected String corps = "";
	protected String nomClient = "";
	protected String chemin = "src/";
	protected String buffer2 = "";
	
	public Editeur(){	
	}
	
	public void creerS(String nomProjet, String ajout){
		this.nomClient = nomProjet;
		chemin = chemin +nomProjet;
		File f = new File( chemin);
		f = new File(chemin +"/Reseau");
		f.mkdir();
		corps = "";
		constcorps(nomProjet, "Serveur", ajout);
		//System.out.println("Dossier cree");
		copieNouveau(chemin+"/Reseau/Serveur.java", corps);
		

	}
	
	public void creerC(String nomProjet, String ajout){
		corps = "";
		constcorps(nomProjet, "Client", ajout);
		//System.out.println("Dossier cree");
		copieNouveau(chemin+"/Reseau/Client.java", corps);
		nomClient = "" ;
		chemin = "src/";
	}


	
	
	private void constcorps(String nomProjet, String chemin , String ajout){
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
		if( ! (ajout.equals("<Defaut>")) && chemin.equals("Serveur")){
			System.out.println(chemin+" "+ajout);
			corps = corps.replaceFirst("pterodactyle.coeur2.CoeurBase", ajout);
			corps = corps.replaceAll("CoeurBase", buffer2);
			System.out.println(buffer2);
		}
		
	}
	
	private void copieNouveau(String chemin, String contenu){
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
	/*
	 * 	public String[] choixImpl(String impl){
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
	 */
	
	
	public ArrayList<String> recupImpl(String implementation){
		int i = 0 ;
		int j = 0 ;
		int k = 0 ;
		String buff = " ";
		ArrayList<String> impls = new ArrayList<String>();
		File src = new File("src");
		while(i < src.listFiles().length){
			j = 0 ;
			while(  src.listFiles()[i].isDirectory() && j <src.listFiles()[i].listFiles().length ){
				if(src.listFiles()[i].listFiles()[j].getName().equals(implementation) && !(src.listFiles()[i].getPath().equals("src/pterodactyle") )){
					k =0;
					while( k < src.listFiles()[i].listFiles()[j].listFiles().length){
						if(! (src.listFiles()[i].listFiles()[j].listFiles()[k].isHidden())){
							buff = src.listFiles()[i].listFiles()[j].listFiles()[k].getPath().replace('/', '.');
							buff = buff.replaceAll("src.", "");
							buff = buff.replaceAll(src.listFiles()[i].listFiles()[j].listFiles()[k].getName(), "*");
							//System.out.println(implementation +" "+buff);
							impls.add(buff);
							buffer2 = src.listFiles()[i].listFiles()[j].listFiles()[k].getName().replaceAll(".java", "");

						}
						k++;
					}
				}			
			j++;
			}
		i++;
		}
		return impls;
		}
	
	public String[] implementation(String implementation){
		ArrayList<String> l = new ArrayList<String>();
		l = this.recupImpl(implementation);
		String[] impl = new String[l.size() + 1] ;
		int i = 0;
		impl[i] = "<Defaut>";
		while( i < l.size()){
			impl[i + 1 ] = l.get(i);
			i++;
		}
		return impl;
	}
	
	
	
	
	
	}
	

	

