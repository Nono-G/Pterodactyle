package pterodactyle.utilisateur;

import java.io.Serializable;
import java.util.HashMap;

public class $Utilisateur implements Serializable {
	protected String nom; 
	protected String prenom; 
	protected String login; 
	protected String motDePasse; 
	protected boolean admin;
	protected HashMap< Autorisation , Droits > listeDroits = new HashMap< Autorisation , Droits >();

	protected $Utilisateur(String nom, String prenom, String login, String motDePasse, boolean admin){
		this.nom = nom;
		this.prenom = prenom; 
		this.login = login; 
		this.motDePasse = motDePasse; 
		this.admin = admin;
	}
}
