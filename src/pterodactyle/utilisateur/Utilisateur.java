package pterodactyle.utilisateur;

public class Utilisateur {
	//Attributs de base de l'utilisateur
	private String nom; 
	private String prenom; 
	private String login; 
	private String motDePasse; 
	
	
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
	
	public String toString(){
		return ""+this.prenom +""+this.nom;  
	}
	
	
	
}
