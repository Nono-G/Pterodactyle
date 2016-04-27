package pterodactyle.coeur2;

import java.io.*;
import java.rmi.RemoteException;
import java.util.*;

import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public class CoeurBase extends $Coeur implements _ServicesCoeur {

	private static final long serialVersionUID = -5431026872014363966L;
	protected Set<Tag> tags;
	protected Map<String, Utilisateur> utilisateurs;
	protected Map<String, _Echangeable> echangeables;

	public CoeurBase(String identifiantSuperAdmin, String cleSuperAdmin) throws RemoteException{
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashSet<Tag>();
		this.echangeables = new HashMap<String, _Echangeable>();
		this.utilisateurs.put(identifiantSuperAdmin, new Utilisateur("Administrateur", "Super", identifiantSuperAdmin, cleSuperAdmin, true));
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
	
	
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle) {
		if(!(verifIdentite.estAdmin(identificateur, cle, utilisateurs)))throw new AdministrateurException();
		if(!(utilisateurs.get(nouveau.getLogin()) == null))throw new UtilisateurException("Utilisateur existe deja");
		this.utilisateurs.put(nouveau.getLogin(), nouveau);
	}

	@Override
	public Utilisateur utilisateurCourant(String identificateur, String cle) throws RemoteException {
		if(! verifIdentite.estUtilisateur(identificateur, cle, utilisateurs)) throw new UtilisateurException("est Utilisateur");
		return utilisateurs.get(identificateur);
	}

	@Override
	public Utilisateur voirUtilisateur(String identificateurCible, String identificateur, String cle) throws RemoteException {
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		return utilisateurs.get(identificateurCible);
	}
	
	@Override
	public Map<String, Utilisateur> recupererToutLesUtilisateurs(String identificateur, String cle) throws RemoteException {
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		return utilisateurs;
	}

	//Auteur : Nono
	@Override
	public Object[] trancheFichier(String url, int n, int tailleTampon, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof Fichier)) throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		verifAutorisation.lecture((Fichier)ech, utilisateurs.get(identificateur));
		
		return ((Fichier)ech).obtenirTranche(n, tailleTampon);
	}
	
	//Auteur : Nono
	@Override
	public void ecrireTranche(Object[] tranche, Fichier fich, String identificateur, String cle) throws FileNotFoundException, IOException {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification autorisation
		if(! verifAutorisation.creation(fich, utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		fich.ecrireTranche(tranche);
	}
	
	public void creerFichier(String url, Dossier pere, Tag t, String identificateur, String cle) throws ExceptionEchangeablePasDeTag{
		Fichier f = Fichier.nouveauFichier(url, utilisateurs.get(identificateur), pere, t);
		this.echangeables.put(url, f);
		f.sauver();
	}
	
	//Auteur : Nono
	public Set<$EchangeableAvecTag> listeEchangeableParTag(Tag t, String identificateur, String cle){
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification autorisation
		if( ! verifAutorisation.lectureTag(t, utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
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

	public void creerPost(String url, String titre, Tag t, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeablePasDeTag {
		//vérification identité
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Ajout du post échangeable
		Post post = Post.nouveauPost(url,utilisateurs.get(identificateur), titre, t);
		if( ! verifAutorisation.creation(post, utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		this.echangeables.put(url, post);
		//Sauvegarde du post
		post.sauver();
	}
		
	//Auteur : Nono
	@Override
	public void repondrePost(String url, String contenu, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof Post)) throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		if( ! verifAutorisation.ecriture((Post)ech, utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		
		((Post)ech).repondre(new MessagePost(utilisateurs.get(identificateur), contenu));
		
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
	public void envoieMessageInterne(String url, String contenu, String objet, String identificateur, String cle,
		String identificateurDestinataire) throws RemoteException, UtilisateurException {
		//vérification identité emetteur
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//vérification identité destinataire
		if(!(utilisateurs.get(identificateurDestinataire)!=null))throw new UtilisateurException("est Utilisateur");
		Utilisateur destinataire =utilisateurs.get(identificateurDestinataire);
		if(! (destinataire != null) )throw new UtilisateurException("Destinataire inconnu");
		//Ajout du message échangeable
		MessageInterne messageInterne = new MessageInterne(url,utilisateurs.get(identificateur), destinataire, contenu, objet);
		this.echangeables.put(url, messageInterne);
		//Sauvegarde du message 
		messageInterne.sauver();
	}
	
	//Auteur : Fanny
	@Override
	public void reponseMessage(String url, String contenu, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType {
			//Verification identite
			verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
			//Verification sémantique
			_Echangeable ech = this.echangeables.get(url);
			if( ! (ech instanceof MessageInterne)) throw new ExceptionEchangeableMauvaisType();
			//Pas besoin de vérification d'autorisation puisque le messageInterne n'a pas de tag
			((MessageInterne)ech).reponse(contenu);
	}
	
	//Auteur : Fanny
	@Override
	public void reponseMessage(String url, String contenu, String objet, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof MessageInterne)) throw new ExceptionEchangeableMauvaisType();
		//Pas besoin de vérification d'autorisation puisque le messageInterne n'a pas de tag
		((MessageInterne)ech).reponse(contenu, objet);	
	}
	

	/**
	 * ADMINISTRATEUR
	 */
	//Auteur : Fanny
	@Override
	public void creerTag(String nomTag, String identificateur, String cle) throws RemoteException {
		//Vérification identité
		if(!(verifIdentite.estAdmin(identificateur, cle, utilisateurs)))throw new AdministrateurException("est Administrateur");
		//Vérification existence du tag
		Tag tag = new Tag(nomTag);
		if(this.tags.contains(tag)) throw new RemoteException("tag existe");
		//Ajout du tags dans la liste des tags
		this.tags.add(tag);
	}

	@Override
	public String test() throws RemoteException {
		return "Ca marche fdp";
	}


	@Override
	public void supprimerTag(Tag tag, String identificateur, String cle)
			throws RemoteException, AdministrateurException {
		// TODO Auto-generated method stub
		
	}

}