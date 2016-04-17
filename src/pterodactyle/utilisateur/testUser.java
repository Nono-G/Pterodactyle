package pterodactyle.utilisateur;

import pterodactyle.echangeable.Tag;

public class testUser {
	
	public static void main(String[] Args){
		Utilisateur anasse = new Utilisateur("Anasse","Berahab","Ba","lool");
		Utilisateur noe = new Utilisateur("Noe","Goudian", "Ng", "lool");	
		Utilisateur Max = new Utilisateur("Maxime","Silvestre", "Ng", "lool");	
		Utilisateur test = new Utilisateur("Maxime","Silvestre", "Ms", "lool");
		System.out.println(anasse.toString());
		System.out.println(test.toString());
		System.out.println(Max.toString());
	}
}
