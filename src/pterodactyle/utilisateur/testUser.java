package pterodactyle.utilisateur;

import pterodactyle.echangeable.Tag;

public class testUser {
	
	public static void main(String[] Args){
		Utilisateur anasse = new Utilisateur("Anasse","Berahab","Ba","lool");
		Droits d = new Droits();
		Tag t = new Tag("t");
		
		anasse.ajouterAut(t, d);
		System.out.println(anasse.toStringDroits());
	}
}
