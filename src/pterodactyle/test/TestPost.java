package pterodactyle.test;


import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public class TestPost {

	public static void main (String[] args) throws ExceptionEchangeablePasDeTag{
		
		Tag t1 = new Tag("Dev2016");
		Tag t2 = new Tag("ClubReptiles");
		Utilisateur u = new Utilisateur("Nono", "Goudian", "goudn", "capre", false);
		Utilisateur u2 = new Utilisateur("Anas", "Berahab", "beraa", "gilles<3", false);
		
		Post p = Post.nouveauPost("post11", u, "Qu'est ce qu'on fait ?", t1);
		MessagePost m1 = new MessagePost(u,"Bonjour,\nJe m'apelle Henry");
		MessagePost m2 = new MessagePost(u2,"Bonjour Henry");
		
		p.repondre(m1);
		p.repondre(m2);
		
		p.ajouterTag(t1);
		p.ajouterTag(t2);
		
		System.out.print(p);
		System.out.println(p.voirTags());
		
		System.out.println("SERIALISATION");
		p.sauver();
		$EchangeableAvecTag p2 = ($EchangeableAvecTag) $Echangeable.charger("post11");
		System.out.print(p2);
		System.out.print(p2.voirTags());
	}
}
