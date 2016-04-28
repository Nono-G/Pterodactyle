package pterodactyle.test;

import java.rmi.RemoteException;

import pterodactyle.coeur.Utilisateurs;
import pterodactyle.coeur2.CoeurBase;
import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.Tag;
import pterodactyle.utilisateur.Droits;
import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.utilisateur.UtilisateurException;

public class testModificationDroitsCoeurs {
	public static boolean[] droits= new boolean[5];

	public static void main(String[] args)  {
		try{

			CoeurBase c = new CoeurBase("Petry", "abc");
			c.creerTag("Comptabilite", "Petry", "abc");

			Utilisateur noe = new Utilisateur("Noe", "Goudian", "Ng", "lol", false);
			Utilisateur anasse = new Utilisateur("Anasse", "Berahab", "Ba", "lol", false);
			Tag comptabilite = new Tag("comptabilite");
			droits[0] = false;
			droits[1] = false;
			droits[2] = false;
			droits[3] = false;
			droits[4] = false;
			Droits drCompta = new Droits(droits);
			c.creerUtilisateur(noe, "Petry", "abc");
			c.creerUtilisateur(anasse, "Petry", "abc");
			
			c.partageDroits("Ng", comptabilite ,0, "Petry", "abc");
			c.partageDroits("Ng", comptabilite, 2, "Petry", "abc");
			c.partageDroits("Ba", comptabilite, 0, "Ng", "lol");
			
			//c.supprimerDroits("Ba", comptabilite, 0, "Petry", "abc");
			System.out.println(anasse.toStringDroits());	
			
		}catch(Exception e){e.printStackTrace();;}

	}
}
