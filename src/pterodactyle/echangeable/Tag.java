package pterodactyle.echangeable;

import pterodactyle.utilisateur.Autorisation;

public class Tag extends Autorisation {

	private String nom;//Le nom du tag;
	
	public Tag (String nom){
		this.nom = nom;
	}
	
	//Retourne une représentation textuelle du tag.
	@Override
	public String toString(){
		return this.nom;
	}
}
