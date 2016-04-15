package pterodactyle.utilisateur;

import java.io.Serializable;
import java.util.HashMap;

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 3755293297347406031L;

	//Attributs de base de l'utilisateur
	protected String nom; 
	protected String prenom; 
	protected String login; 
	protected String motDePasse; 
	protected int id;
	protected HashMap< Autorisation , Droits > listeDroits = new HashMap< Autorisation , Droits >();
	
	
	/*
	 * Constructeur basique 
	 * @param : Nom, Prenom, Login, motDePasse
	 */
	public Utilisateur(String nom, String prenom, String login, String motDePasse){
		this.nom = nom;
		this.prenom = prenom; 
		this.login = login; 
		this.motDePasse = motDePasse; 
	}
	
	
	/*
	 * @return : String le nom de l'utilisateur
	 */
	public String toString(){
		return ""+this.prenom +" "+this.nom;  
	}
	
	
	/*
	 * Retourne la liste des autorisations et droits lies a l'utilisateur
	 */
	public String toStringDroits(){
		return ""+listeDroits.entrySet();
	}
	

	
	public void ajouterAut(Autorisation aut, Droits droit ){
		listeDroits.put(aut, droit);
	}
	
	
	
	
}
