package pterodactyle.coeur2;

import pterodactyle.utilisateur.Autorisation;
import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.echangeable.*;

public interface _VerifAutorisation {

	/*
	 *@param echangeable sur lequel on fait passer les tests
	 *@param utilisateur pour qui on va faire les tests des differents droits
	 */
	boolean lecture($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean modification($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean partage($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean creation($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean suppression($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	
	/*
	 *@param tag sur lequel on fait passer les tests
	 *@param utilisateur pour qui on va faire les tests des differents droits
	 */
	boolean lectureTag(Tag tag, Utilisateur utilisateur);
	
	boolean modificationTag(Tag tag, Utilisateur utilisateur);
	
	boolean partageTag(Tag tag, Utilisateur utilisateur);
	
	boolean creationTag(Tag tag, Utilisateur utilisateur);
	
	boolean suppressionTag(Tag tag, Utilisateur utilisateur);
	
	
	
	/*
	 * @param echangeable pour lequel on va tester 
	 */
	public boolean aDroit($EchangeableAvecTag echangeable, Utilisateur utilisateur, int numeroDroit);
	
	public boolean droitTag(Autorisation tag, Utilisateur utilisateur, int numeroDroit);
	
	
}
