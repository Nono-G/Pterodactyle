package pterodactyle.coeur2;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pterodactyle.echangeable.ExceptionEchangeableFichierFini;
import pterodactyle.echangeable.ExceptionEchangeableMauvaisType;
import pterodactyle.utilisateur.Utilisateur;

public interface _ServicesCoeur extends Remote {

	
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle);
	
	
	public Utilisateur utilisateurCourant(String login, String motDePasse)throws RemoteException;
	

	public String voirUtilisateur(String login, Utilisateur utilisateurCourant)throws RemoteException;

	/*Renvoie une tranche (cf méthode dans la classe pterodactyle.echangeable.Fichier) du fichier désigné par url,
	*Sous réserve que le couple identificateur, cle corresponde à un utilisateur existant et autorisé à LIRE cet echangeable
	**/
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType;
	
	/*
	 * 
	 */
	public void repondrePost(String url, String contenu, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType;
}
