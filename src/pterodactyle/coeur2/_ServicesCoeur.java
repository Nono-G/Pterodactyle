package pterodactyle.coeur2;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

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
	 * @param utlisateurCourant permettant de reconnaitre l'utilisateur
	 * @require etre administrateur
	 * @return void
	 */
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle)throws RemoteException;
	
	/*
	 * @author MaximeSilvestre
	 * Permet de recupérer l'utilisateur connecter
	 * @param identificateur le parametre permettant de retrouver le bon utilisateur
	 * @param cle assossier pour valider que ce soit le bon utlisateur
	 * @return un Utilisateur de la personne connectee
	 */
	public Utilisateur utilisateurCourant(String identificateur, String cle)throws RemoteException;
	
	
	/*
	 * @author MaximeSilvestre
	 * Permet de créer récuperer un Utilisateur en vérifiant l'identite de la personne
	 * @param identificateurCible de la personne dont nous voulons récuperer les informations
	 * @param utlisateurCourant permettant de reconnaitre l'utilisateur
	 * @return un Utilisateur
	 */

	public Utilisateur voirUtilisateur(String identificateurCible, String identificateur, String cle)throws RemoteException;
	
	/*
	 * @autor MaximeSIlvestre
	 * Permet de recuperer tout les utilisateurs
	 * @return hasmap<login,Utilisateur>
	 */
	public Map<String, Utilisateur> recupererToutLesUtilisateurs(String identificateur, String cle) throws RemoteException;

	/*
	 * @author Nono
	 * Renvoie une tranche (cf méthode dans la classe pterodactyle.echangeable.Fichier) du fichier désigné par url,
	 * Sous réserve que le couple identificateur, cle corresponde à un utilisateur existant et autorisé à LIRE cet echangeable
	 */
	public Object[] trancheFichier(String url, int n, int tailleTampon, String identificateur, String cle)

			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType;

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

	public void creerPost(String url, String titre, Tag t, String identificateur, String cle)
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
	public void envoieMessageInterne(String url, String contenu, String objet, String identificateurDestinataire, String identificateur, String cle )
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
	
	
	/*
	 * @author Anasse
	 * Methodes qui permet d'ajouter/supprimer des droits 
	 */
	
}