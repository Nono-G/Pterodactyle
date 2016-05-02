package pterodactyle.test;

import pterodactyle.coeur.CoeurBase;
import pterodactyle.utilisateur.Utilisateur;

public class TestMessageInterneCoeur {

	public static void main(String[] args) {
		try{

			CoeurBase c = new CoeurBase("Petry", "abc");
			c.creerTag("Comptabilite", "Petry", "abc");

			Utilisateur noe = new Utilisateur("Noe", "Goudian", "Ng", "lol", false);
			Utilisateur anasse = new Utilisateur("Anasse", "Berahab", "Ba", "lol", false);

			c.creerUtilisateur(noe, "Petry", "abc");
			c.creerUtilisateur(anasse, "Petry", "abc");
			
			c.envoieMessageInterne( "Bonjour comment va?", "Coucou", "Ng", "lol", "Ba");
			c.envoieMessageInterne( "Tu es trop beau anas", "Coucou2", "Ng", "lol", "Ba");
			c.envoieMessageInterne( "Ploup", "Coucou3", "Ng", "lol", "Ba");
			c.envoieMessageInterne( "Genius ", "Coucou4", "Ng", "lol", "Ba");

			System.out.println(c.releverMessages("Ba", "lol"));
		}catch(Exception e){e.printStackTrace();;}
		
	}

}
