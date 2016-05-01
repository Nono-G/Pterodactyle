package pterodactyle.utilisateur;

import java.util.Set;

public interface _Utilisateur {

	
	/*
	 * @return : String le nom de l'utilisateur
	 */
	public String toString();
	
	/*
	 * Retourne la liste des autorisations et droits lies a l'utilisateur
	 */
	public String toStringDroits();
	
	
	/*
	 * Ajout des autorisations avec les droits speciaux
	 * @param autorisation a ajouter
	 * @param Droit a lier a l'autorisation
	 */
	public void ajouterAut(Autorisation aut, Droits droit );
	
	/*
	 * Ajout d'autorisation avec droits initiaux
	 * @param autorisation 
	 */
	public void ajouterAut(Autorisation aut);
	
	/*
	 * @return motDePasse
	 */
	public String getCle();
	
	
	/*
	 * @return login
	 */
	public String getLogin();
	
	/*
	 * Verifie si la personne est admin
	 * @return admin
	 */
	public boolean estAdmin();
	
	
	public boolean equals(Object u2);
	
	
	/*
	 * Verifie si l'utilisateur a une autorisation precise 
	 * @param autorisation a verifier
	 */
	public boolean aAutorisation(Autorisation autorisation);
	
	
	/*
	 * Recupere les droits lie a une autorisation (Tag ou specifique)
	 * @param autorisation 
	 */
	public Droits getDroits(Autorisation autorisation);
	
	
	/*
	 * @return Speciciques un set de toutes les autorisations specifiques liees a l'utilisateur
	 */
	public Set<Specifique> getSpecifique();
	
	
	/*
	 * Verifie si l'utilisateur a une autorisation specifique
	 * @param url de l'autorisation specifique
	 */
	public boolean aSpecifique(String url);
	
	
	/*
	 * Supprime l'autorisation specifique dont le nom est passe en parametre
	 * @param nom de l'autorisation
	 */
	public void supprimerSpec(String nom);
	
	
	/*
	 * Renvoie une specifique bien precis
	 * @param url du specifique a recuperer
	 * @retun Specifique
	 */
	public Specifique getSpecifique(String urlSpec);
	
	public void sauver();
}
