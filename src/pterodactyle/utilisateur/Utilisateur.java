package pterodactyle.utilisateur;

import java.util.*;
import pterodactyle.coeur.AdministrateurException;
import java.awt.List;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;

public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 3755293297347406031L;
	
	//Attributs de base de l'utilisateur
	protected String nom; 
	protected String prenom; 
	protected String login; 
	protected String motDePasse; 
	protected boolean admin; 
	protected int id = 0 ;
	protected HashMap< Autorisation , Droits > listeDroits = new HashMap< Autorisation , Droits >();
	
	/*
	 * Constructeur basique 
	 * @param : Nom, Prenom, Login, motDePasse
	 */
	public Utilisateur(String nom, String prenom, String login, String motDePasse, boolean admin){
		this.nom = nom;
		this.prenom = prenom; 
		this.login = login; 
		this.motDePasse = motDePasse; 
		this.admin = admin;
	}
	
	
	/*
	 * @return : String le nom de l'utilisateur
	 */
	public String toString(){
		return ""+this.prenom +" "+this.nom+" id = "+this.id;  
	}
	
	
	/*
	 * Retourne la liste des autorisations et droits lies a l'utilisateur
	 */
	public String toStringDroits(){
		String res = "------------------------------------------------------------------ \n";
		res = res + "Autorisation et droit de " +this.prenom+" "+ this.prenom+"\n \n"; 
		for(Entry<Autorisation , Droits> e: listeDroits.entrySet()){
			res = res + "Nom autorisation = "+e.getKey() +"\n";
			res = res + e.getValue() + "\n \n";
		}
		
		res = res+ "------------------------------------------------------------------";
		return res;
	}
	

	/*
	 * Ajout des autorisations avec les droits speciaux
	 */
	public void ajouterAut(Autorisation aut, Droits droit ){
		listeDroits.put(aut, droit);
	}
	
	 
	/*
	 * Les getters pour mot de passe et login 
	 */
	public String getMdp(){
		return this.motDePasse;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	/*
	 * Regrouper les infos pour profil a voir selon utilite
	 */
	public String[] getProfil(){
		String[] profil = new String[4];
		profil[0] = this.login;
		profil[1] = this.nom;
		profil[2] = this.prenom;
		profil[3] = String.valueOf(this.id);
		return profil;
	}
	
	public boolean estAdmin()throws AdministrateurException{
		return admin;
	}
	
}
