package pterodactyle.coeur2;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pterodactyle.utilisateur.Utilisateur;

public interface _ServicesCoeur extends Remote {

	/*
	 * Permet de créer un nouvelle utilisateur en vérifiant que l'utilisateur est admin
	 * @param nouveau le nouvelle utilisateur que l'on veut créer
	 * @param utlisateurCourant permettant de reconnaitre l'utilisateur
	 * @require etre administrateur
	 * @return void
	 */
	public void creerUtilisateur(Utilisateur nouveau, Utilisateur utlisateurCourant);
	
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

	
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant) throws RemoteException;
	
}
