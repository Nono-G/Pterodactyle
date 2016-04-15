package pterodactyle.test;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public class TestPost {

	public static void main (String[] args){
		
		Tag t = new Tag("Dev2016");
		Utilisateur u = new Utilisateur("Nono", "Goudian", "goudn", "capre");
		Utilisateur u2 = new Utilisateur("Anas", "Berahab", "beraa", "gilles<3");
		
		Post p = new Post("post11", u, "Qu'est ce qu'on fait ?");
		MessagePost m1 = new MessagePost(u,"Bonjour,\nJe m'apelle Henry\n");
		MessagePost m2 = new MessagePost(u2,"Bonjour Henry\n");
		
		p.repondre(m1);
		p.repondre(m2);
		
		p.ajouterTag(t);
		
		System.out.print(p);
		System.out.print(p.voirTags());
		
		
	}
}
