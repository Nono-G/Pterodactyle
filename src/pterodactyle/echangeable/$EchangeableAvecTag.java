package pterodactyle.echangeable;

import java.util.List;

public abstract class $EchangeableAvecTag extends $Echangeable{

	//Invariant de classe : tags non vide
	protected List<Tag> tags;//La liste des tags par lesquels l'échangeable est marqué
	
	//Ajoute le tag passé en paramètre à cet échangeable
	protected void ajouterTag( Tag t){
		this.tags.add(t);
	}
	
	//Permet de voir sous forme de string tous les tags qui s'appliquent à cet échangeable
	protected String voirTags(){
		String ret = "| ";
		for(Tag t : tags){
			ret += t.toString() + " | ";
		}
		return ret;
	}
}
