package pterodactyle.coeur;

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
	public boolean modification($EchangeableAvecTag echangeable, Utilisateur utilisateur) {
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
		if(utilisateur.getDroits(tag) == null) {return false;}
		return utilisateur.getDroits(tag).getDroits()[0];
	}

	@Override
	public boolean modificationTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		if(utilisateur.getDroits(tag) == null) {return false;}
		return utilisateur.getDroits(tag).getDroits()[1];
	}

	@Override
	public boolean partageTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		if(utilisateur.getDroits(tag) == null) {return false;}
		return utilisateur.getDroits(tag).getDroits()[2];

	}

	@Override
	public boolean creationTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		if(utilisateur.getDroits(tag) == null) {return false;}
		return utilisateur.getDroits(tag).getDroits()[3];
	}

	@Override
	public boolean suppressionTag(Tag tag, Utilisateur utilisateur) {
		if(utilisateur.estAdmin()){
			return true;
		}
		if(utilisateur.getDroits(tag) == null) {return false;}
		return utilisateur.getDroits(tag).getDroits()[4];
	}
	
	public boolean aDroit($EchangeableAvecTag echangeable, Utilisateur utilisateur, int numeroDroit){
		boolean resultat = false;
		tags = echangeable.getTags();	
		
		
		if(utilisateur.estAdmin()){
			return true;
		}
		if(echangeable.getClass().getName() == "pterodactyle.echangeable.Fichier" || echangeable.getClass().getName() == "pterodactyle.echangeable.Dossier"){
			while(echangeable instanceof $DossierOuFichier && (($DossierOuFichier)echangeable).getPere() != null){
				tagsHeritage = echangeable.getTags();
				for(Tag t : tagsHeritage){
					if(utilisateur.aAutorisation(t)){
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
				echangeable = (($DossierOuFichier)echangeable).getPere();
			}
		}
		for(Tag t : tags){
			boolean rustine = false;
			Autorisation rustineTag = null;
			for(Autorisation s : utilisateur.recupererTousLesDroits().keySet()){
				if(s.equals(t)){rustine = true;rustineTag=s;}
			}
			if(rustine){
				if(droitTag((Tag)rustineTag,utilisateur, numeroDroit)) resultat = true;
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
		if(utilisateur.getDroits(tag) != null && utilisateur.getDroits(tag).getDroits() != null){
			return  utilisateur.getDroits(tag).getDroits()[numeroDroit] ;
		}
		return false;
		//*TRACE*/System.out.println("TRACE D4ANASSE"+utilisateur.getDroits(tag).getDroits()[numeroDroit]);
		//return  utilisateur.getDroits(tag).getDroits()[numeroDroit] ;
	}
	
	
	public boolean aSpecifiqueSuppression(String urlEchangeable , Utilisateur utilisateur){
		if(utilisateur.aSpecifique(urlEchangeable)){
			return this.droitTag(utilisateur.getSpecifique(urlEchangeable), utilisateur, 4);
		}
		return false ;
	}


}
