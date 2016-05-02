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

	/**
	 * @author MaximeSilvestre
	 * Permet de créer un nouvelle utilisateur en vérifiant que l'utilisateur est admin
	 * @param nouveau le nouvelle utilisateur que l'on veut créer
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @require etre administrateur
	 * @return void
	 */
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle)throws RemoteException;
	
	/**
	 * @author MaximeSilvestre
	 * Permet de tester si un utilisateur existe pour ce mot de passe et ce login
	 * @param identificateur le parametre permettant de retrouver le bon utilisateur
	 * @param cle assossier pour valider que ce soit le bon utlisateur
	 * @return true si le compte existe et que le mot de passe est le bon
	 */
	public boolean seConnecter(String identificateur, String cle)throws RemoteException;
	
	
	/**
	 * @author MaximeSilvestre
	 * Permet de créer récuperer un Utilisateur en vérifiant l'identite de la personne
	 * @param identificateurCible de la personne dont nous voulons récuperer les informations
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return un Utilisateur
	 */

	public Utilisateur voirUtilisateur(String identificateurCible, String identificateur, String cle)throws RemoteException;
	
	/**
	 * @autor MaximeSIlvestre
	 * Permet de recuperer tout les utilisateurs
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return hasmap<login,Utilisateur>
	 */
	public Map<String, Utilisateur> recupererToutLesUtilisateurs(String identificateur, String cle) throws RemoteException;

	/**
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
	 * @throws RemoteException RMI
	 * @throws ExceptionEchangeableFichierFini si le début de la tranche demandé est au delà de la fin du fichier
	 * @throws ExceptionEchangeableMauvaisType si l'url ne désigne pas un fichier.
	 */
	public Object[] trancheFichier(String url, int n, int tailleTampon, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType;

	/**
	 * @author Nono
	 * écrit une tranche d'octets (objet composé d'un entier représentant
	 * le nombre d'octets et du tableau d'octets)
	 * dans le fichier désigné sur le serveur par l'url.
	 * Sous réserve que identificateur-cle corrensponde à un utilisateur reconnu.
	 * @require droit MODIFICATION.
	 * @param tranche un couple : le premier est le nombre d'octets effectivement présents,
	 * 		le second est le tableau d'octets de la tranche
	 * @param url du fichier côté serveur dont on veut une part
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @throws FileNotFoundException si le fichier n'existe pas en local
	 * @throws IOException si la lecture échoue sur le fichier local
	 * @throws ExceptionEchangeableMauvaisType si l'url ne désigne pas un fichier.
	 * @throws RemoteException RMI
	 */
	public void ecrireTranche(Object[] tranche, String fich, String identificateur, String cle)
			throws FileNotFoundException, IOException, ExceptionEchangeableMauvaisType, RemoteException;

	/**
	 * @author Nono
	 * écrit une tranche d'octets (objet composé d'un entier représentant le nombre d'octets
	 * et du tableau d'octets) dans le fichier désigné sur le serveur par l'url.
	 * Sous réserve que identificateur-cle corrensponde à un utilisateur reconnu et que la 
	 * cléCreation corresponde à la clé de création générée lors de la cr�ation d'un fichier.
	 * @require droit CREATION.
	 * @param tranche un couple : le premier est le nombre d'octets effectivement présents,
	 * 		le second est le tableau d'octets de la tranche
	 * @param url du fichier côté serveur dont on veut une part
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @throws IOException si la lecture échoue sur le fichier local
	 * @throws ExceptionEchangeableMauvaisType si l'url ne désigne pas un fichier.
	 * @throws RemoteException RMI
	 */
	public void ecrireTranche(Object[] tranche, String fich, int cleCreation, String identificateur, String cle)
			throws FileNotFoundException, IOException, ExceptionEchangeableMauvaisType;
	
	/**
	 * @author Nono
	 * Cr�e un nouvel Echangeable de type Fichier dans le serveur, celui-ci est vide avant
	 * 		son remplissage avec ecrireTranche.
	 * @param url du fichier c�t� serveur.
	 * @param pere du fichier (un Dossier ou null)
	 * @param tag que porte le fichier. Il faut en fournir un à la création puis ajouter
	 * 		 les autres ensuite.
	 * @require tag doit correspondre à un tag existant côté serveur.
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return la cl� de cr�ation g�n�r�e pour permettre d'utiliser ecrireTranche avec
	 * 		 le droit de creation mais pas de modification.
	 * @throws ExceptionEchangeablePasDeTag si le tag n'existe pas (ou null)
	 * @throws RemoteException RMI
	 */
	public int creerFichier(String url, Dossier pere, String tag, String identificateur, String cle) 
			throws ExceptionEchangeablePasDeTag, RemoteException;
	
	/**
	 * @author Nono
	 * Retire le tag pass� en param�tre de l'�changeable dont l'url est pass� en param�tre.
	 * @param url du fichier c�t� serveur.
	 * @param tag que l'on souhaite retirer. (Si celui n'existe pas ou n'est pas port� par l'�changeable, il ne se passe rien)
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @throws ExceptionEchangeableMauvaisType si l'url ne correspond pas � un Echangeable avec Tag ($EchangeableAvecTag)
	 * @throws RemoteException
	 */
	public void enleverTag(String url, String tag, String identificateur, String cle)
			throws ExceptionEchangeableMauvaisType, RemoteException;
	
	/**
	 * @author Nono
	 * Ajoute le tag dont le nom est pass� en param�tre aux tags port�s par l'�changeable dont l'url figure en param�tre.
	 * @param urlEch url serveur de l'�changeable manipul�.
	 * @param urlTag nom du tag manipul�
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @throws RemoteException RMI
	 * @throws ExceptionEchangeableMauvaisType si l'url ne correspond pas � un Echangeable avec Tag ($EchangeableAvecTag)
	 * @throws ExceptionEchangeablePasDeTag si le tag n'existe pas.
	 */
	public void ajouterTagSurEchangeable(String urlEch, String urlTag, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType, ExceptionEchangeablePasDeTag;
	
	/**
	 * @author Nono
	 * renvoie l'ensemble des posts que l'utilisateur � le droit de LIRE.
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return l'ensemble des posts
	 * @throws RemoteException RMI
	 */
	public Set<Post> getPosts(String identificateur, String cle)
			throws RemoteException;
	
	/**
	 * @author Nono
	 * renvoie l'ensemble des fichiers que l'utilisateur � le droit de LIRE.
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return l'ensemble des fichiers
	 * @throws RemoteException RMI
	 */
	public Set<Fichier> getFichiers(String identificateur, String cle)
			throws RemoteException;
	
	/**
	 * @author Nono
	 * renvoie l'ensemble des tags sur lesquels l'utilisateur a le droit CREATION, c'est � dire
	 * l'ensemble des tags que l'utilisateur � le droit d'aposer � un Echangeable Avec Tag.
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return l'ensemble de tags
	 * @throws RemoteException RMI
	 */
	public Set<Tag> getTagsDroitCreation(String identificateur, String cle)
			throws RemoteException;
	
	/**
	 * @author Nono
	 * Renvoie l'�changeable d�sign� par le param�tre url, � condition que l'utilisateur ait le droit le LECTURE sur cet �changeable
	 * si il s'agit d'un �changeable avec tag ou qu'il en soit le destinataire si il s'agit d'un message interne.
	 * @param url serveur de l'�changeable
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return l'�changeable d�sign� par l'url.
	 * @throws RemoteException
	 * @throws ExceptionEchangeableInexistant si l'url est inconnu
	 * @throws ExceptionAutorisationManquante si l'utilisateur n'as pas le droit de LECTURE ou n'est pas destinataire
	 */
	public _Echangeable getEchangeable(String url, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableInexistant, ExceptionAutorisationManquante;
			
	/**
	 * ADMINISTRATEUR TAG
	 */
	
	/**
	 * @author Fanny
	 * création d'un tag par un admin
	 * @Require verifIdentite.estAdmin(utilisateurCourant, utilisateurs)
	 * @Ensure le tag est dans la liste de 
	 * @throws RemoteException
	 * @throws AdministrateurException si l'identificateur ne correspond pas à un administrateur
	 * @throws ExceptionEchangeableTagExistant si le tag que l'administrateur veut créer existe déjà dans la liste des tags
	 */
	public void creerTag(String nomTag, String identificateur, String cle)
		throws RemoteException, AdministrateurException, ExceptionEchangeableTagExistant;	
	
	/**
	 * @author Fanny
	 * Service de suppression de tag par un admin
	 */
	public void supprimerTag(String tag, String identificateur, String cle)throws RemoteException, AdministrateurException;
	
	/**
	 * POST	
	 */
	/**
	 * @author Fanny
	 * Méthode qui permet le service de création d'un post
	 * @require utilisateur ci 
	 */

	public void creerPost(String url, String titre, String urlTag, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeablePasDeTag;
	
	/**
	 * Permet de rajouter un message en r�ponse � la suite des messages d'un post � condition qu'on ait le droit de MODIFICATION dessus.
	 * @require Droit MODIFICATION sur url
	 * @param url du post concern�
	 * @param contenu du message
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @throws RemoteException RMI
	 * @throws ExceptionEchangeableMauvaisType si l'url ne d�signe pas un post.
	 * @throws ExceptionAutorisationManquante si l'utilisateur n'as pas le droit de modification sur le post.
	 */
	public void repondrePost(String url, String contenu, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType, ExceptionAutorisationManquante;
	
	/**
	 * Permet la supression de l'�changeable d�sign� par l'url. Conform�ment � la description des droits, cette action n�c�ssite
	 * une autorisation SPECIFIQUE de SUPRESSION sur l'�l�ment. Dans l'absence de ce droit la supression devra se faire en enlevant le dernier
	 * tag que portera l'echangeable.
	 * @require Droit SPECIFIQUE de SUPRESSION
	 * @param url de l'�changeable concern�
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @throws RemoteException RMI
	 * @throws ExceptionAutorisationManquante si l'utilisateur n'as pas le droit SPECIFIQUE de SUPRESSION  sur l'�l�ment.
	 */
	public void supprimerEchangeable(String url, String identificateur, String cle)
			throws RemoteException, ExceptionAutorisationManquante;
	
	/**
	 * MESSAGERIE INTERNE
	 */
	
	/**
	 * @author Fanny
	 * Méthode qui permet le service d'un envoie de message interne
	 * @require verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateur)
	 * @require verifIdentite.estUtilisateur(destinataire, utilisateurs)
	 * @ensure message interne est sauvé messageInterne.sauver()
	 */
	public void envoieMessageInterne(String contenu, String objet, String identificateurDestinataire, String identificateur, String cle )
			throws RemoteException, UtilisateurException;
	/**
	 * @author Fanny
	 * Méthode qui permet le service de réponse à un message interne sans objet
	 * @require utilisateur courant existe dans la liste des utilisateurs verifIdentite.verificationIdentiteUtilisateur()
	 * @require l'url correspond bien au message interne
	 * @ensure la réponse est envoyée
	 */
	public void reponseMessage(String url, String contenu, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	
	/**
	 * @author Fanny
	 * Méthode qui permet le service de réponse à un message interne avec objet
	 * @require utilisateur courant existe dans la liste des utilisateurs verifIdentite.verificationIdentiteUtilisateur()
	 * @require l'url correspond bien au message interne
	 * @ensure la réponse est envoyée
	 */
	public void reponseMessage(String url, String contenu, String objet, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType;
	
	/**
	 * @author Nono
	 * Renvoie l'ensemble des echangeables avec tag portant un tag donn�, � condition que l'on ait le droit LECTURE dessus.
	 * @require droit LECTURE sur le tag
	 * @param urlTag nom du tag
	 * @param identificateur de l'utilisateur à l'origine de la demande
	 * @param cle de l'utilisateur à l'origine de la demande
	 * @return l'ensemble d'�changeables avec tag d�crit ci-dessus.
	 * @throws RemoteException RMI
	 * @throws ExceptionAutorisationManquante si l'on ne dspose pas du droit LECTURE
	 */
	public Set<$EchangeableAvecTag> listeEchangeableParTag(String urlTag, String identificateur, String cle)throws RemoteException, ExceptionAutorisationManquante;
	
	
	/**
	 * @author Anasse
	 * Methodes qui permet d'ajouter/supprimer des droits 
	 * @param identifiant de la personne qui va subit le changement
	 * @param url de L'autorisation a changer 
	 * @param numero du droit a changer 0 : lecture / 1 : modification / 2 : partage / 3 :creation / 4 : suppression
	 * @param id de la personne qui fait le partage
	 * @param cle qui correspond au mdp de la personne responsable  
	 * @require la personne qui veut partager doit avoir le droit de partage et le droit qu'elle veut partager
	 */
	public void partageDroits(String idVictime,  String tag, int numeroDroit, String idResponsable, String cle) throws RemoteException;
	

	/**
	 * @author Anasse
	 * @param identifiant de la personne qui va se faire supprimer les droits
	 * @param url du tag dont les droits vont etre modifier
	 * @param identifiant de la personne qui va modifier les droits
	 * @param cle le mot de passe de la personne qui va modifier les droits
	 * @require la personne qui va modifier doit etre administrateur
	 */
	public void supprimerDroits(String idVictime,  String tag, int numeroDroit, String idResponsable, String cle) throws RemoteException;

	/**
	 * @author Anasse
	 * Supprimer un utilisateur
	 * @param identifiant de la personne a supprimer 
	 * @param identifiant de la personne qui supprime
	 * @param cle le mot de passe de la personne qui va supprimer
	 * @require la personne qui va supprimer doit etre administrateur
	 */
	public void supprimerUtilisateur(String idSupprime, String idResponsable, String cle) throws RemoteException;
	
	/**
	 * @author Anasse
	 * Relever les messages 
	 * @param identifiant de la personne qui veut voir ses messages
	 * @param cle le mot de passe de cette personne
	 */
	public Set<MessageInterne> releverMessages(String identificateur , String cle ) throws RemoteException;
	
	
	/**
	 * @author Anasse
	 * @param url de l'echangeable sur lequel va porter les droits specifiques
	 * @param identifiant de la personne qui va en beneficier
	 * @param identifiant de la personne qui va creer le specifique
	 * @param cle le mot de passe de de la personne qui va le creer 
	 * @require la personne qui va creer le specifique doit etre administrateur
	 */
	public void creerSpecifique(String urlEchangeable, String idBeneficiant , String identificateur , String cle) throws ExceptionEchangeableNonExistant ,RemoteException;

	/**
	 * @author  Anasse
	 * @param url du specifique a supprimer
	 * @param identifiant de la personne qui beneficie de ce droit specifique
	 * @param identifiant de l'admininstrateur qui va faire la suppression
	 * @param cle mot de passe de l'administrateur
	 * @require la personne qui supprime doit etre administrateur
	 */
	public void supprimerSpecifique(String urlSpecifique, String idUtilisateur, String idAmin, String cle) throws RemoteException;

	
	/**
	 * @author Anasse
	 * @param identifiant de l'utilisateur 
	 * @param url des droits specifique 
	 * @param numero du droit a changer
	 * @param identifiant de la personne qui va faire la modification
	 * @param cle mot de passe de l'administrateur
	 * @require la personne qui ajoute les droits specifiques doit etre administrateur
	 */
	public void ajouterDroitsSpecifiques(String idUtilisateur,  String urlSpec, int numeroDroit, String idResponsable, String cle) throws ExceptionEchangeableNonExistant, RemoteException;

}

