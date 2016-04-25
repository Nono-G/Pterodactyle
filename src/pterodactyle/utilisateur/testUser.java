package pterodactyle.utilisateur;

import java.util.ArrayList;

import pterodactyle.echangeable.Tag;

public class testUser {
	
	public static ArrayList<Integer> listID = new ArrayList<Integer>(); 
	public static int nbreUtilisateur = 0; 
	public static boolean[] droits= new boolean[5];
	public static void main(String[] Args){
		
		Utilisateur anasse = new Utilisateur("Anasse","Berahab","Ba","lool", listID);
		Utilisateur noe = new Utilisateur("Noe","Goudian", "Ng", "lool",listID);	
		Utilisateur Max = new Utilisateur("Maxime","Silvestre", "Ms", "lool", listID);	
		Utilisateur Naffy = new Utilisateur("Fanny","VIgnal", "Fv", "lool", listID);	

		Tag comptabilite = new Tag("Comptabilite");
		Droits drCompta = new Droits();
		droits[0] = false;
		droits[1] = true;
		droits[2] = true;
		droits[3] = false;
		droits[4] = false;
		drCompta.setDroits(droits);
		anasse.ajouterAut(comptabilite, drCompta);
		
		
		Tag PDG = new Tag("PDG");
		Droits drAbsolu = new Droits();
		droits[0] = true;
		droits[1] = true;
		droits[2] = true;
		droits[3] = true;
		droits[4] = true;
		drAbsolu.setDroits(droits);
		anasse.ajouterAut(PDG, drAbsolu);
		System.out.println(anasse.toStringDroits());
		
	}
}
