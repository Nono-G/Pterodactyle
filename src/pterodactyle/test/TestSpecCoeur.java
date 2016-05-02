package pterodactyle.test;

import pterodactyle.coeur.CoeurBase;
import pterodactyle.utilisateur.Utilisateur;

public class TestSpecCoeur {

	public static void main(String[] args) {

		try{

			CoeurBase c = new CoeurBase("Petry", "abc");
			
			c.creerTag("Comptabilite", "Petry", "abc");

			Utilisateur noe = new Utilisateur("Noe", "Goudian", "Ng", "lol", false);
			Utilisateur anasse = new Utilisateur("Anasse", "Berahab", "Ba", "lol", false);
			c.creerUtilisateur(noe, "Petry", "abc");
			c.creerUtilisateur(anasse, "Petry", "abc");
			
			
			c.partageDroits("Ng", "Comptabilite", 0, "Petry", "abc");
			c.partageDroits("Ng", "Comptabilite", 3, "Petry", "abc");

			c.creerPost("P1", "Va te faire foutre" , "Comptabilite", "Ng", "lol");
			c.creerSpecifique("P1", "Ba", "Petry", "abc");
			c.ajouterDroitsSpecifiques("Ba", "P1", 0, "Petry", "abc");
			System.out.println(anasse.toStringDroits());

			
			System.out.println(c.listeEchangeableParTag("Comptabilite", "Petry", "abc").toString());
			
		}catch(Exception e){e.printStackTrace();;}
	}

}
