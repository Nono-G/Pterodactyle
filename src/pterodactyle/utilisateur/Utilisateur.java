package pterodactyle.utilisateur;

import java.util.HashMap;

public class Utilisateur {
	//Attributs de base de l'utilisateur
	protected String nom; 
	protected String prenom; 
	protected String login; 
	protected String motDePasse; 
	protected int id;
	protected HashMap< Autorisation , Droits > listeDroits;
	
	
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
	
	
	/*
	 * Ajouter des autorisations avec les droits ( autorisation = tag | Specifique) 
	 */
	public void ajouterAut(Autorisation aut, Droits droit ){
		listeDroits.put(aut, droit);
	}
	
	
	
	
}
