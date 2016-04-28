package pterodactyle.test;

import pterodactyle.coeur2.CoeurBase;
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
			

			
			System.out.println(anasse.toStringDroits());	
			
		}catch(Exception e){e.printStackTrace();;}
		
	}

}
