package pterodactyle.coeur2;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pterodactyle.echangeable.ExceptionEchangeableFichierFini;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.utilisateur.Utilisateur;

public interface _ServicesCoeur extends Remote {
	
	public String test()throws RemoteException;

	/*
	 * Permet de créer un nouvelle utilisateur en vérifiant que l'utilisateur est admin
	 * @param nouveau le nouvelle utilisateur que l'on veut créer
	 * @param utlisateurCourant permettant de reconnaitre l'utilisateur
	 * @require etre administrateur
	 * @return void
	 */
	public void creerUtilisateur(Utilisateur nouveau, Utilisateur utlisateurCourant)throws RemoteException;
	
	/*
	 * Permet de recupérer l'utilisateur connecter
	 * @param identificateur le parametre permettant de retrouver le bon utilisateur
	 * @param cle assossier pour valider que ce soit le bon utlisateur
	 * @return un Utilisateur de la personne connectee
	 */
	public Utilisateur utilisateurCourant(String identificateur, String cle)throws RemoteException;
	
	
	/*
	 * Permet de créer récuperer un Utilisateur en vérifiant l'identite de la personne
	 * @param identificateur de la personne dont nous voulons récuperer les informations
	 * @param utlisateurCourant permettant de reconnaitre l'utilisateur
	 * @return un Utilisateur
	 */
	public Utilisateur voirUtilisateur(String identificateur, Utilisateur utilisateurCourant)throws RemoteException;

	/*Renvoie une tranche (cf méthode dans la classe pterodactyle.echangeable.Fichier) du fichier désigné par url,
	*Sous réserve que le couple identificateur, cle corresponde à un utilisateur existant et autorisé à LIRE cet echangeable
	**/
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType;
	
	/**
	 * POST	
	 */
	/*
	 * 
	 */
	public void repondrePost(String url, String contenu, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	
	/**
	 * MESSAGERIE INTERNE
	 */
	/*
	 * 
	 */
	public void envoieMessageInterne(String url, String contenu, String objet, Utilisateur utilisateurCourant, String identificateurDestinataire)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	/*
	 * 
	 */
	//public void reponseMessage(String url, String contenu, Utilisateur utilisateurCourant);
}
