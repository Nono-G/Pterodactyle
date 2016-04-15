package pterodactyle.utilisateur;

import pterodactyle.echangeable.Tag;

public class testUser {
	
	public static void main(String[] Args){
		Utilisateur anasse = new Utilisateur("Anasse","Berahab","Ba","lool");
		
		
		Tag t = new Tag("Comptabilite");
		Droits d = new Droits();
		
		anasse.ajouterAut(t, d);
		
		Tag rh = new Tag("RH");
		Droits dh = new Droits();
		
		anasse.ajouterAut(rh, dh);
		System.out.println(anasse.toStringDroits());
	}
}
