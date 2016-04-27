package pterodactyle.coeur2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.*;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public class CoeurBase extends $Coeur implements _ServicesCoeur {

	private static final long serialVersionUID = -5431026872014363966L;
	protected Set<Tag> tags;
	protected Map<String, Utilisateur> utilisateurs;
	protected Map<String, _Echangeable> echangeables;

	public CoeurBase() throws RemoteException{
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashSet<Tag>();
		this.echangeables = new HashMap<String, _Echangeable>();
	}
	
	protected CoeurBase(String repertoire) throws RemoteException{
		super();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(repertoire+"/indexTags")))){
			this.tags = (Set<Tag>)ois.readObject();
		}catch(Exception e){e.printStackTrace();}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(repertoire+"/indexUtilisateurs")))){
			this.utilisateurs = (Map<String,Utilisateur>)ois.readObject();
		}catch(Exception e){e.printStackTrace();}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(repertoire+"/indexEchangeables")))){
			this.echangeables = (Map<String, _Echangeable>)ois.readObject();
		}catch(Exception e){e.printStackTrace();}
	}
	
	protected void Sauvegarder(String repertoire){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(repertoire+"/indexTags")))){
			oos.writeObject(this.tags);
		}catch(IOException e){e.printStackTrace();}
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(repertoire+"/indexUtilisateurs")))){
			oos.writeObject(this.utilisateurs);
		}catch(IOException e){e.printStackTrace();}
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(repertoire+"/indexEchangeables")))){
			oos.writeObject(this.echangeables);
		}catch(IOException e){e.printStackTrace();}
	}
	
	
	public void creerUtilisateur(Utilisateur nouveau, Utilisateur utilisateuCourant) {
		verifIdentite.estAdmin(utilisateuCourant, utilisateurs);
		if(!(utilisateurs.get(nouveau.getLogin()) != null))throw new UtilisateurException("Utilisateur existe deja");
		this.utilisateurs.put(nouveau.getLogin(), nouveau);
	}

	@Override
	public Utilisateur utilisateurCourant(String identificateur, String cle) throws RemoteException {
		if(verifIdentite.estUtilisateur(identificateur, cle, utilisateurs)) throw new UtilisateurException("est Utilisateur");
		return utilisateurs.get(identificateur);
	}

	@Override
	public Utilisateur voirUtilisateur(String identificateur, Utilisateur utilisateurCourant) throws RemoteException {
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		return utilisateurs.get(identificateur);
	}

	//Auteur : Nono
	@Override
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof Fichier)) throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		verifAutorisation.lecture((Fichier)ech, utilisateurCourant);
		
		return ((Fichier)ech).obtenirTranche(n, tailleTampon);
	}
	
	//Auteur : Nono
	public Set<$EchangeableAvecTag> listeEchangeableParTag(Tag t, Utilisateur utilisateurCourant){
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		//Verification autorisation
		if( ! verifAutorisation.lectureTag(t, utilisateurCourant))throw new ExceptionAutorisationManquante();
		
		Set<$EchangeableAvecTag> ret = new HashSet<$EchangeableAvecTag>();
		for(String s : echangeables.keySet()){
			_Echangeable ech = echangeables.get(s);
			if(ech instanceof $EchangeableAvecTag){
				$EchangeableAvecTag ech2 = ($EchangeableAvecTag)ech;
				if(ech2.getTags().contains(t)){
					ret.add(ech2);
				}
			}
		}
		return ret;
	}
	
	/**
	 * POST	
	 */
	//Auteur Fanny
	@Override
	public void creerPost(String url, String titre, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType {
		//vérification identité
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		//Ajout du post échangeable
		Post post = new Post(url,utilisateurCourant, titre);
		this.echangeables.put(url, post);
		//Sauvegarde du message 
		post.sauver();
	}
		
	//Auteur : Nono
	@Override
	public void repondrePost(String url, String contenu, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof Post)) throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		verifAutorisation.ecriture((Post)ech, utilisateurCourant);
		if( ! verifAutorisation.ecriture((Post)ech, utilisateurCourant))throw new ExceptionAutorisationManquante();
		((Post)ech).repondre(new MessagePost(utilisateurCourant, contenu));
		
	}

	
	/**
	 * MESSAGERIE INTERNE
	 */
	
	//Auteur : Fanny
	/** UNICITÉ URL ? Vérifier que l'Url ne fais pas déjà partie de la liste des MessagesInterne? 
	 * if((this.echangeables.get(url))!=null) throw new Exception 
	 * 
	 * */
	@Override
	public void envoieMessageInterne(String url, String contenu, String objet, Utilisateur utilisateurCourant,
		String identificateurDestinataire) throws RemoteException, ExceptionEchangeableMauvaisType {
		//vérification identité emetteur
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		//vérification identité destinataire
		if(!(utilisateurs.get(identificateurDestinataire)!=null))throw new RemoteException();
		Utilisateur destinataire =utilisateurs.get(identificateurDestinataire);
		verifIdentite.estUtilisateur(destinataire, utilisateurs);
		//Ajout du message échangeable
		MessageInterne messageInterne = new MessageInterne(url,utilisateurCourant, destinataire, contenu, objet);
		this.echangeables.put(url, messageInterne);
		//Sauvegarde du message 
		messageInterne.sauver();
	}
	
	//Auteur : Fanny
	@Override
	public void reponseMessageSansObjet(String url, String contenu, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType {
			//Verification identite
			verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
			//Verification sémantique
			_Echangeable ech = this.echangeables.get(url);
			if( ! (ech instanceof MessageInterne)) throw new ExceptionEchangeableMauvaisType();
			//Pas besoin de vérification d'autorisation puisque le messageInterne n'a pas de tag
			((MessageInterne)ech).reponse(contenu);
	}
	
	@Override
	public void reponseMessageAvecObjet(String url, String contenu, String objet, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(utilisateurCourant, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof MessageInterne)) throw new ExceptionEchangeableMauvaisType();
		//Pas besoin de vérification d'autorisation puisque le messageInterne n'a pas de tag
		((MessageInterne)ech).reponse(contenu, objet);	
	}
	
	@Override
	public String test() throws RemoteException {
		return "Ca marche fdp";
	}

}
