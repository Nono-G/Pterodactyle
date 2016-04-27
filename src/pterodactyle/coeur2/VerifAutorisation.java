package pterodactyle.coeur2;

import pterodactyle.echangeable.Tag;
import pterodactyle.echangeable._Echangeable;
import pterodactyle.utilisateur.Autorisation;
import pterodactyle.utilisateur.Specifique;
import pterodactyle.utilisateur.Utilisateur;

import java.util.Set;

import pterodactyle.echangeable.*;

public class VerifAutorisation implements _VerifAutorisation {

	protected Set<Tag> tags;
	protected Set<Tag> tagsHeritage;
	
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
		if(utilisateur.estAdmin()){
			return true;
		}
		return utilisateur.getDroits(tag).getDroits()[0] == true;
	}

	@Override
	public boolean ecritureTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		return utilisateur.getDroits(tag).getDroits()[1] == true;
	}

	@Override
	public boolean partageTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		return utilisateur.getDroits(tag).getDroits()[2] == true;

	}

	@Override
	public boolean creationTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		return utilisateur.getDroits(tag).getDroits()[3] == true;
	}

	@Override
	public boolean suppressionTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		return utilisateur.getDroits(tag).getDroits()[4] == true;
	}
	
	public boolean aDroit($EchangeableAvecTag echangeable, Utilisateur utilisateur, int numeroDroit){
		boolean resultat = false;
		tags = echangeable.getTags();	
		
		
		if(utilisateur.estAdmin()){
			return true;
		}
		if(echangeable.getClass().getName() == "pterodactyle.echangeable.Fichier" || echangeable.getClass().getName() == "pterodactyle.echangeable.Dossier"){
			while(echangeable.getPere() != null){
				tagsHeritage = echangeable.getTags();
				for(Tag t : tagsHeritage){
					if(utilisateur.possedeTag(t)){
						if(droitTag(t,utilisateur, numeroDroit)) resultat = droitTag(t,utilisateur, numeroDroit);
					}
				}
				for(Specifique s : utilisateur.getSpecifique()){
					if(s.aPourCible(echangeable.getUrl())) {
						if(droitTag(s,utilisateur, numeroDroit)) {
							resultat = droitTag(s,utilisateur, numeroDroit);
						}
					}
				}
				echangeable = echangeable.getPere();
			}
		}
		for(Tag t : tags){
			if(utilisateur.possedeTag(t)){
				if(droitTag(t,utilisateur, numeroDroit)) resultat = droitTag(t,utilisateur, numeroDroit);
			}
		}
		for(Specifique s : utilisateur.getSpecifique()){
			if(s.aPourCible(echangeable.getUrl())){
				if(droitTag(s,utilisateur, numeroDroit)) {
					resultat = droitTag(s,utilisateur, numeroDroit);
				}			
			}
		}
		
		return resultat;

		
		
	}
	
	public boolean droitTag(Autorisation tag, Utilisateur utilisateur, int numeroDroit){
		if(utilisateur.estAdmin()){
			return true;
		}
		return  utilisateur.getDroits(tag).getDroits()[numeroDroit] == true;
	}

}
