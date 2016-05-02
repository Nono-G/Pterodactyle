package pterodactyle.test;

import java.rmi.RemoteException;

import pterodactyle.coeur.CoeurBase;
import pterodactyle.coeur._ServicesCoeur;
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

			c.creerUtilisateur(noe, "Petry", "abc");
			c.creerUtilisateur(anasse, "Petry", "abc");
			
			c.partageDroits("Ng", "Comptabilite" ,0, "Petry", "abc");
			c.partageDroits("Ng", "Comptabilite", 2, "Petry", "abc");
			c.partageDroits("Ba", "Comptabilite", 0, "Ng", "lol");
			
			c.supprimerDroits("Ba", "Comptabilite", 0, "Petry", "abc");
			System.out.println(c.voirUtilisateur("Ng", "Petry", "abc"));
			c.supprimerUtilisateur("Bo", "Petry", "abc");
			System.out.println(c.voirUtilisateur("Ng", "Ba", "lol"));
			
			
			
			System.out.println(anasse.toStringDroits());	
			
		}catch(Exception e){e.printStackTrace();;}

	}
}
