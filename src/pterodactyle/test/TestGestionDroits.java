package pterodactyle.test;

import pterodactyle.coeur2.VerifAutorisation;
import pterodactyle.echangeable.Dossier;
import pterodactyle.echangeable.Fichier;
import pterodactyle.echangeable.Post;
import pterodactyle.echangeable.Tag;
import pterodactyle.utilisateur.Droits;
import pterodactyle.utilisateur.Specifique;
import pterodactyle.utilisateur.Utilisateur;

public class TestGestionDroits {
	public static boolean[] droits= new boolean[5];

	public static void main(String[] args) {
		Utilisateur anasse = new Utilisateur("Anasse", "Berahab" , "ba", "lol" ,false);
		VerifAutorisation V = new VerifAutorisation();
		Tag comptabilite = new Tag("comptabilite");
		droits[0] = false;
		droits[1] = true;
		droits[2] = false;
		droits[3] = false;
		droits[4] = true;
		Droits drCompta = new Droits(droits);
		anasse.ajouterAut(comptabilite, drCompta);
		
		Specifique RH = new Specifique("papa");
		droits[0] = false;
		droits[1] = true;
		droits[2] = false;
		droits[3] = false;
		droits[4] = true;
		Droits drRH = new Droits(droits);
		anasse.ajouterAut(comptabilite, drRH);
		anasse.ajouterAut(RH, drRH);
		
		
		//test tag post 
		Post p = new Post("Testons", anasse, "Bonjour");
		//p.ajouterTag(comptabilite);
		//System.out.println(V.ecriture(p, anasse));
		//System.out.println(V.lecture(p, anasse));
		//System.out.println(V.suppression(p, anasse));
		
		
		
		//Test Fichier normal sans pere 
		Fichier f = new Fichier("t.avi", anasse , null);
		f.ajouterTag(comptabilite);
		//System.out.println(V.ecriture(f, anasse));
		//System.out.println(V.lecture(f, anasse));
		//System.out.println(V.suppression(f, anasse));
		
		
		
		
		
		Dossier dPapa = new Dossier("papa", anasse, null);
		Dossier dPapa2 = new Dossier("papa2", anasse, dPapa);
		Fichier f1 = new Fichier("t2 ", anasse, dPapa2);
		//dPapa.ajouterTag(comptabilite);
		dPapa.ajouterDans(dPapa2);
		dPapa2.ajouterDans(f1);
		System.out.println(V.ecriture(dPapa, anasse));
		System.out.println(V.lecture(f1, anasse));
		System.out.println(V.suppression(f1, anasse));
		
	}

}
