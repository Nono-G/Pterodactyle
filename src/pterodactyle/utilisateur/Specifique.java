package pterodactyle.utilisateur;

public class Specifique extends Autorisation{
	
	protected String nom;
	
	public Specifique(String nom){
		this.nom = nom;
	} 
	
	public String toString(){
		return ""+this.nom;
	}
	
}
