package pterodactyle.utilisateur;

import java.util.Set;

public class Specifique extends Autorisation{
	
	protected String cible;
	
	public Specifique(String cible){
		this.cible = cible;
	} 
	
	public String toString(){
		return ""+this.cible;
	}
}
