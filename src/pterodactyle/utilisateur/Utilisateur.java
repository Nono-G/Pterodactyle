package pterodactyle.utilisateur;

import java.util.*;
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
	protected int id = 0 ;
	protected HashMap< Autorisation , Droits > listeDroits = new HashMap< Autorisation , Droits >();
	protected ArrayList<Integer> listID = new ArrayList<Integer>();
	
	/*
	 * Constructeur basique 
	 * @param : Nom, Prenom, Login, motDePasse
	 */
	public Utilisateur(String nom, String prenom, String login, String motDePasse, ArrayList<Integer> l){
		this.nom = nom;
		this.prenom = prenom; 
		this.login = login; 
		this.motDePasse = motDePasse; 
		setId(l);
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
		String res = "Autorisation et droit de " +this.prenom+" "+ this.prenom+"\n \n"; 
		for(Entry<Autorisation , Droits> e: listeDroits.entrySet()){
			res = res + "Nom autorisation = "+e.getKey() +"\n";
			res = res + e.getValue() + "\n \n";
		}
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
	
	public void setId(ArrayList<Integer> list){
		if(list.isEmpty()){
			list.add(this.id);
		}else{
			list.add(list.size() );
			this.id = list.get(list.size() - 1);
		}
	}
	
}
