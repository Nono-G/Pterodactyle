package pterodactyle.coeur2;

import pterodactyle.echangeable.Tag;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Utilisateur;

public interface _VerifAutorisation {

	boolean lecture(_Echangeable echangeable, Utilisateur utilisateur);
	
	boolean ecriture(_Echangeable echangeable, Utilisateur utilisateur);
	
	boolean partage(_Echangeable echangeable, Utilisateur utilisateur);
	
	boolean creation(_Echangeable echangeable, Utilisateur utilisateur);
	
	boolean suppression(_Echangeable echangeable, Utilisateur utilisateur);
	
	boolean lectureTag(Tag tag, Utilisateur utilisateur);
	
	boolean ecritureTag(Tag tag, Utilisateur utilisateur);
	
	boolean partageTag(Tag tag, Utilisateur utilisateur);
	
	boolean creationTag(Tag tag, Utilisateur utilisateur);
	
	boolean suppressionTag(Tag tag, Utilisateur utilisateur);
}
