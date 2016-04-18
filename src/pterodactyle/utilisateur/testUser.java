package pterodactyle.utilisateur;

import java.util.ArrayList;

import pterodactyle.echangeable.Tag;

public class testUser {
	
	public static ArrayList<Integer> listID = new ArrayList<Integer>(); 
	public static int nbreUtilisateur = 0; 
	public static void main(String[] Args){
		
		Utilisateur anasse = new Utilisateur("Anasse","Berahab","Ba","lool", listID);
		Utilisateur noe = new Utilisateur("Noe","Goudian", "Ng", "lool",listID);	
		Utilisateur Max = new Utilisateur("Maxime","Silvestre", "Ng", "lool", listID);	
		System.out.println(anasse.toString());
		System.out.println(noe.toString());
		System.out.println(Max.toString());
	}
}
