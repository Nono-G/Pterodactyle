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
	//protected HashMap< Autorisation , Droits > listeDroits;
	
	
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
	
<<<<<<< HEAD
	
	/*
	 * Ajouter des autorisations avec les droits ( autorisation = tag | Specifique) 
	 */
=======
	/*
>>>>>>> c10cdbb5153e261b8023b99829cd5bd7e3a43f49
	public void ajouterAut(Autorisation aut, Droits droit ){
		listeDroits.put(aut, droit);
	}
	*/
	
	
	
}
