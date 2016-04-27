package pterodactyle.echangeable;

import java.util.HashSet;
import java.util.Set;

import pterodactyle.utilisateur.Utilisateur;

public abstract class $EchangeableAvecTag extends $Echangeable{

	private static final long serialVersionUID = -2822540663675076727L;
	
	//Invariant de classe : tags non vide
	protected Set<Tag> tags;//La liste des tags par lesquels l'échangeable est marqué
	
	protected $EchangeableAvecTag(String nom, Utilisateur ut, Tag t) {
		super(nom, ut);
		
		this.ajouterTag(t);
		this.tags = new HashSet<Tag>();
	}
	
	//Ajoute le tag passé en paramètre à cet échangeable
	public void ajouterTag( Tag t){
		this.tags.add(t);
	}
	
	//Permet de voir sous forme de string tous les tags qui s'appliquent à cet échangeable
	public String voirTags(){
		String ret = "| ";
		for(Tag t : tags){
			ret += t.toString() + " | ";
		}
		return ret;
	}
	
	public Set<Tag> getTags(){
		return tags;
	}
}
