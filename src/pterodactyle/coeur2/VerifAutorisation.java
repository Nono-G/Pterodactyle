package pterodactyle.coeur2;

import pterodactyle.echangeable.Tag;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Utilisateur;

import java.util.Set;

import pterodactyle.echangeable.*;

public class VerifAutorisation implements _VerifAutorisation {

	protected Set<Tag> tags;
	
	@Override
	/*
	 * 
	 */
	public boolean lecture($EchangeableAvecTag echangeable, Utilisateur utilisateur) {
		return aDroit(echangeable, utilisateur, 0);
	}

	@Override
	public boolean ecriture($EchangeableAvecTag echangeable, Utilisateur utilisateur) {
		return aDroit(echangeable, utilisateur, 1);	
	}

	@Override
	public boolean partage($EchangeableAvecTag echangeable, Utilisateur utilisateur) {
		return aDroit(echangeable, utilisateur, 2);	
	}

	@Override
	public boolean creation($EchangeableAvecTag echangeable, Utilisateur utilisateur) {
		return aDroit(echangeable, utilisateur, 3);	
	}

	@Override
	public boolean suppression($EchangeableAvecTag echangeable, Utilisateur utilisateur) {
		return aDroit(echangeable, utilisateur, 4);	
	}

	@Override
	public boolean lectureTag(Tag tag, Utilisateur utilisateur) {
		return utilisateur.getDroits(tag).getDroits()[0] = true;
	}

	@Override
	public boolean ecritureTag(Tag tag, Utilisateur utilisateur) {
		return utilisateur.getDroits(tag).getDroits()[1] = true;
	}

	@Override
	public boolean partageTag(Tag tag, Utilisateur utilisateur) {
		return utilisateur.getDroits(tag).getDroits()[2] = true;

	}

	@Override
	public boolean creationTag(Tag tag, Utilisateur utilisateur) {
		return utilisateur.getDroits(tag).getDroits()[3] = true;

	}

	@Override
	public boolean suppressionTag(Tag tag, Utilisateur utilisateur) {
		return utilisateur.getDroits(tag).getDroits()[4] = true;

	}
	
	public boolean aDroit($EchangeableAvecTag echangeable, Utilisateur utilisateur, int numeroDroit){
		tags = echangeable.getTags();
		for(Tag t : tags){
			if(utilisateur.possedeAut(t)){
				return droitTag(t,utilisateur, numeroDroit);
			}
		}
		return false;
	}
	
	public boolean droitTag(Tag tag, Utilisateur utilisateur, int numeroDroit){
		return  utilisateur.getDroits(tag).getDroits()[numeroDroit] == true;
	}

}
