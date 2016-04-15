package pterodactyle.echangeable;

import java.util.ArrayList;
import java.util.List;

import pterodactyle.utilisateur.Utilisateur;

public abstract class $EchangeableAvecTag extends $Echangeable{

	//Invariant de classe : tags non vide
	private List<Tag> tags;//La liste des tags par lesquels l'échangeable est marqué
	
	public $EchangeableAvecTag(String nom, Utilisateur ut) {
		super(nom, ut);
		this.tags = new ArrayList<Tag>();
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
}
