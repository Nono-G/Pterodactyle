package pterodactyle.coeur2;

import pterodactyle.echangeable.Tag;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Autorisation;
import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.echangeable.*;

public interface _VerifAutorisation {

	boolean lecture($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean modification($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean partage($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean creation($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean suppression($EchangeableAvecTag echangeable, Utilisateur utilisateur);
	
	boolean lectureTag(Tag tag, Utilisateur utilisateur);
	
	boolean modificationTag(Tag tag, Utilisateur utilisateur);
	
	boolean partageTag(Tag tag, Utilisateur utilisateur);
	
	boolean creationTag(Tag tag, Utilisateur utilisateur);
	
	boolean suppressionTag(Tag tag, Utilisateur utilisateur);
	
	public boolean droitTag(Autorisation tag, Utilisateur utilisateur, int numeroDroit);
	
	
}
