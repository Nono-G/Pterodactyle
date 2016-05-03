package pterodactyle.utilisateur;
/*
 * @author Anasse 
 */
import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class Utilisateur extends $Utilisateur implements Serializable {

	/*
	 * Constructeur basique 
	 * @param nom du nouvel utilisateur
	 * @param prenom du nouvel utilisateur
	 * @param login du nouvel utilisateur
	 * @param motDePasse du nouvel utilisateur
	 * @param admin un boolean pour definir si cette personne peut etre admin
	 */
	public Utilisateur(String nom, String prenom, String login, String motDePasse, boolean admin){
		super(nom, prenom, login, motDePasse, admin);
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
	 * @param autorisation a ajouter
	 * @param Droit a lier a l'autorisation
	 */
	public void ajouterAut(Autorisation aut, Droits droit ){
		listeDroits.put(aut, droit);
	}
	
	/*
	 * Ajout d'autorisation avec droits initiaux
	 * @param autorisation 
	 */
	public void ajouterAut(Autorisation aut){
		Droits d = new Droits();
		listeDroits.put(aut, d);
		System.out.println("Ajout d'autorisation = " +aut);
	}
	 
	/*
	 * @return motDePasse
	 */
	public String getCle(){
		return this.motDePasse;
	}
	
	/*
	 * @return login
	 */
	public String getLogin(){
		return this.login;
	}
	

	/*
	 * Verifie si la personne est admin
	 * @return admin
	 */
	public boolean estAdmin()throws AdministrateurException{
		return admin;
	}
	
	
	
	@Override
	public boolean equals(Object u2){
		if (!(u2 instanceof Utilisateur)){return false;
		}else{
			return this.login.equals( ((Utilisateur)u2).login);
		}
	}
	
	/*
	 * Verifie si l'utilisateur a une autorisation precise 
	 * @param autorisation a verifier
	 */

	public boolean aAutorisation(Autorisation autorisation){
		return listeDroits.keySet().contains(autorisation);
		//return listeDroits.containsKey(autorisation);	
	}
	
	/*
	 * Recupere les droits lie a une autorisation (Tag ou specifique)
	 * @param autorisation 
	 */
	public Droits getDroits(Autorisation autorisation){
		return listeDroits.get(autorisation);
	}
	
	public HashMap<Autorisation,Droits> recupererTousLesDroits(){
		return listeDroits;
	}
	
	public String getPrenom(){
		return prenom;
	}
	
	public String getNom(){
		return nom;
	}
	
	
	
	/*
	 * Coin des droits specifiques
	 */
	
	/*
	 * @return Speciciques un set de toutes les autorisations specifiques liees a l'utilisateur
	 */
	public Set<Specifique> getSpecifique(){
		Set<Specifique> resultat = new HashSet<Specifique>(); 

		for(Autorisation autorisation : listeDroits.keySet()){

			if(autorisation.getClass().getName() == "pterodactyle.utilisateur.Specifique"){
				resultat.add((Specifique)autorisation);
			}
		}
		return resultat;
	}
	

	/*
	 * Verifie si l'utilisateur a une autorisation specifique
	 * @param url de l'autorisation specifique
	 */
	public boolean aSpecifique(String url){
		for(Specifique s : this.getSpecifique()){
			if(s.aPourCible(url)) return true;
		}
		return false;
	}
	
	/*
	 * Supprime l'autorisation specifique dont le nom est passe en parametre
	 * @param nom de l'autorisation
	 */
	public void supprimerSpec(String nom){
		for(Specifique s : this.getSpecifique()){
			if(s.aPourCible(nom)) this.getSpecifique().remove(s);
		}
	}
	
	
	/*
	 * Renvoie une specifique bien precis
	 * @param url du specifique a recuperer
	 * @retun Specifique
	 */
	public Specifique getSpecifique(String urlSpec){
		Specifique resultat = null;
		for(Specifique s : this.getSpecifique()){
			if(s.aPourCible(urlSpec)) resultat = s;
		}
		return resultat;
	}
	
	
	public void sauver(){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File ("sauv/utilisateurs/"+this.login)))){
			oos.writeObject(this);
		}catch(IOException e){e.printStackTrace();}
	}
	


}
