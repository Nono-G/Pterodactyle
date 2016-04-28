package pterodactyle.coeur2;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
import java.rmi.*;
import java.io.*;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public interface _ServicesCoeur extends Remote {
	
	public String test()throws RemoteException;

	/*
	 * @author MaximeSilvestre
	 * Permet de créer un nouvelle utilisateur en vérifiant que l'utilisateur est admin
	 * @param nouveau le nouvelle utilisateur que l'on veut créer
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @require etre administrateur
	 * @return void
	 */
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle)throws RemoteException;
	
	/*
	 * @author MaximeSilvestre
	 * Permet de tester si un utilisateur existe pour ce mot de passe et ce login
	 * @param identificateur le parametre permettant de retrouver le bon utilisateur
	 * @param cle assossier pour valider que ce soit le bon utlisateur
	 * @return true si le compte existe et que le mot de passe est le bon
	 */
	public boolean seConnecter(String identificateur, String cle)throws RemoteException;
	
	
	/*
	 * @author MaximeSilvestre
	 * Permet de créer récuperer un Utilisateur en vérifiant l'identite de la personne
	 * @param identificateurCible de la personne dont nous voulons récuperer les informations
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return un Utilisateur
	 */

	public Utilisateur voirUtilisateur(String identificateurCible, String identificateur, String cle)throws RemoteException;
	
	/*
	 * @autor MaximeSIlvestre
	 * Permet de recuperer tout les utilisateurs
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return hasmap<login,Utilisateur>
	 */
	public Map<String, Utilisateur> recupererToutLesUtilisateurs(String identificateur, String cle) throws RemoteException;

	/*
	 * @author Nono
	 * Renvoie une tranche (cf méthode dans la classe pterodactyle.echangeable.Fichier) du fichier désigné par url,
	 * Sous réserve que le couple identificateur, cle corresponde à un utilisateur existant et autorisé à LIRE cet echangeable
	 * Cette méthode est utilisé côté client dans une boucle qui constitue la méthode de téléchargement d'un fichier.
	 * @require le droit de lecture pour l'utilisateur.
	 * @param url du fichier côté serveur dont on veut une part
	 * @param n numéro de la tranche que l'on veut récupérer (selon un partage en tranches de tailleTampon octets)
	 * @param tailleTampon taille d'une tranche
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return un couple : le premier est le nombre d'octets effectivement présents, le second est le tableau d'octets de la tranche
	 */
	public Object[] trancheFichier(String url, int n, int tailleTampon, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType;

	/*
	 * @author Nono
	 * écrit une tranche d'octets (objet composé d'un entier représentant le nombre d'octets et du tableau d'octets)
	 * dans le fichier désigné sur le serveur par l'url.
	 * Sous réserve que identificateur-cle corrensponde à un utilisateur reconnu.
	 * @require droit ECRITURE si le fichier n'existe pas, droit modification si il existe.
	 * @param tranche un couple : le premier est le nombre d'octets effectivement présents, le second est le tableau d'octets de la tranche
	 * @param url du fichier côté serveur dont on veut une part
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 */
	public void ecrireTranche(Object[] tranche, String fich, String identificateur, String cle)
			throws FileNotFoundException, IOException, ExceptionEchangeableMauvaisType;

	
	public void creerFichier(String url, Dossier pere, String tag, String identificateur, String cle) 
			throws ExceptionEchangeablePasDeTag, RemoteException;
	/**
	 * ADMINISTRATEUR TAG
	 */
	
	/*
	 * @author Fanny
	 * @Require verifIdentite.estAdmin(utilisateurCourant, utilisateurs)
	 * @Ensure le tag est dans la liste de 
	 * 
	 * création d'un tag par un admin
	 */
	public void creerTag(String nomTag, String identificateur, String cle)
		throws RemoteException, AdministrateurException, ExceptionEchangeableTagExistant;	
	
	/*
	 * @author Fanny
	 * Service de suppression de tag par un admin
	 */
	public void supprimerTag(Tag tag, String identificateur, String cle)
			throws RemoteException, AdministrateurException;	
	/**
	 * POST	
	 */
	/*
	 * @author Fanny
	 * Méthode qui permet le service de création d'un post
	 * @require utilisateur ci 
	 */

	public void creerPost(String url, String titre, String urlTag, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType, ExceptionEchangeablePasDeTag;
	/*
	 * 
	 */
	public void repondrePost(String url, String contenu, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	
	/**
	 * MESSAGERIE INTERNE
	 */
	/*
	 * @author Fanny
	 * Méthode qui permet le service d'un envoie de message interne
	 * @require verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateur)
	 * @require verifIdentite.estUtilisateur(destinataire, utilisateurs)
	 * @ensure message interne est sauvé messageInterne.sauver()
	 */
	public void envoieMessageInterne(String contenu, String objet, String identificateurDestinataire, String identificateur, String cle )
			throws RemoteException, UtilisateurException;
	/*
	 * @author Fanny
	 * Méthode qui permet le service de réponse à un message interne sans objet
	 * @require utilisateur courant existe dans la liste des utilisateurs verifIdentite.verificationIdentiteUtilisateur()
	 * @require l'url correspond bien au message interne
	 * @ensure la réponse est envoyée
	 */
	public void reponseMessage(String url, String contenu, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	
	/*
	 * @author Fanny
	 * Méthode qui permet le service de réponse à un message interne avec objet
	 * @require utilisateur courant existe dans la liste des utilisateurs verifIdentite.verificationIdentiteUtilisateur()
	 * @require l'url correspond bien au message interne
	 * @ensure la réponse est envoyée
	 */
	public void reponseMessage(String url, String contenu, String objet, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	
	public Set<$EchangeableAvecTag> listeEchangeableParTag(String urlTag, String identificateur, String cle)throws RemoteException;
	
	
	/*
	 * @author Anasse
	 * Methodes qui permet d'ajouter/supprimer des droits 
	 * @param L'identifiant de la personne qui va subit le changement
	 * @param L'autorisation a changer 
	 * @param Le numero du droit a changer 0 : lecture / 1 : modification / 2 : partage / 3 :creation / 4 : suppression
	 * @param  l'id de la personne qui fait le partage
	 * @param la cle qui correspond au mdp de la personne responsable  
	 */
	public void partageDroits(String idVictime,  String tag, int numeroDroit, String idResponsable, String cle) throws RemoteException;
	

	public void supprimerDroits(String idVictime,  String tag, int numeroDroit, String idResponsable, String cle) throws RemoteException;

	/*
	 * @author Anasse
	 * Supprimer un utilisateur
	 */
	public void supprimerUtilisateur(String idSupprime, String idResponsable, String cle) throws RemoteException;

}

