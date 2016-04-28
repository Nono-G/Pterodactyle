package pterodactyle.test;

import pterodactyle.coeur2.CoeurBase;
import pterodactyle.echangeable.Tag;
import pterodactyle.utilisateur.Droits;
import pterodactyle.utilisateur.Utilisateur;

public class testPostCoeur {

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
			c.partageDroits("Ng", "Comptabilite", 1, "Petry", "abc");
			
			
			c.partageDroits("Ba", "Comptabilite", 0, "Petry", "abc");
			c.partageDroits("Ba", "Comptabilite", 3, "Petry", "abc");
			c.partageDroits("Ba", "Comptabilite", 1, "Petry", "abc");
			
			c.creerPost("P1", "Va te faire foutre" , "Comptabilite", "Ng", "lol");

			
			c.repondrePost("P1", "Toi aussi Anasse", "Ng", "lol");
			c.repondrePost("P1", "Tu es trop con Noe !! " , "Ba", "lol");
			
			

			
			System.out.println(c.listeEchangeableParTag("Comptabilite", "Petry", "abc").toString());
			
		}catch(Exception e){e.printStackTrace();;}
	}

}
