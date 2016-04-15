package pterodactyle.echangeable;

import java.io.Serializable;
import pterodactyle.utilisateur.Autorisation;

public class Tag extends Autorisation implements Serializable{

	private static final long serialVersionUID = 4431577932936612825L;
	
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
