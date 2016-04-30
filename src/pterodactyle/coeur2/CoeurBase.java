package pterodactyle.coeur2;

import java.io.*;
import java.rmi.RemoteException;
import java.util.*;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.*;

public class CoeurBase extends $Coeur implements _ServicesCoeur {

	private static final long serialVersionUID = -5431026872014363966L;
	protected Map<String, Tag> tags;
	protected Map<String, Utilisateur> utilisateurs;
	protected Map<String, _Echangeable> echangeables;

	public CoeurBase(String identifiantSuperAdmin, String cleSuperAdmin) throws RemoteException{
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashMap<String, Tag>();
		this.echangeables = new HashMap<String, _Echangeable>();
		Utilisateur admin = new Utilisateur("Administrateur", "Super", identifiantSuperAdmin, cleSuperAdmin, true);
		this.utilisateurs.put(identifiantSuperAdmin, admin);
		new File("sauv/tags").mkdirs();
		new File("sauv/echangeables").mkdir();
		new File("sauv/utilisateurs").mkdir();
		new File("sauv/fichiers").mkdir();
		admin.sauver();
		
	}
	
	public CoeurBase() throws RemoteException, ClassNotFoundException{
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashMap<String, Tag>();
		this.echangeables = new HashMap<String, _Echangeable>();
		File rep; File[] objets; String adresse;
		//UTILISATEURS
		adresse = "sauv/utilisateurs";
		rep = new File(adresse);
		objets = rep.listFiles();
		for(File u : objets){
			System.out.println(u.getName());
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(adresse+"/"+u.getName())))){
				this.utilisateurs.put(u.getName(), (Utilisateur)ois.readObject());
			}catch(IOException e){e.printStackTrace();}
		}
		//TAGS
		adresse = "sauv/tags";
		rep = new File(adresse);
		objets = rep.listFiles();
		for(File u : objets){
			System.out.println(u.getName());
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(adresse+"/"+u.getName())))){
				this.tags.put(u.getName(), (Tag)ois.readObject());
			}catch(IOException e){e.printStackTrace();}
		}
		//ECHANGEABLES
		adresse = "sauv/echangeables";
		rep = new File(adresse);
		objets = rep.listFiles();
		for(File u : objets){
			System.out.println(u.getName());
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(adresse+"/"+u.getName())))){
				this.echangeables.put(u.getName(), (_Echangeable)ois.readObject());
			}catch(IOException e){e.printStackTrace();}
		}
	}
	
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle) {
		if(!(verifIdentite.estAdmin(identificateur, cle, utilisateurs)))throw new AdministrateurException();
		if(!(utilisateurs.get(nouveau.getLogin()) == null))throw new UtilisateurException("Utilisateur existe deja");
		this.utilisateurs.put(nouveau.getLogin(), nouveau);
		nouveau.sauver();
	}

	@Override
	public boolean seConnecter(String identificateur, String cle) throws RemoteException {
		return verifIdentite.estUtilisateur(identificateur, cle, utilisateurs);
		
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
	public void ecrireTranche(Object[] tranche, String fich, String identificateur, String cle) throws FileNotFoundException, IOException, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification fichier existe
		_Echangeable fichier = this.echangeables.get(fich);
		if( ! (fichier != null && this.echangeables.get(fich) instanceof Fichier))throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		if(! verifAutorisation.creation((Fichier)fichier, utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		((Fichier)fichier).ecrireTranche(tranche);
	}
	
	public void creerFichier(String url, Dossier pere, String t, String identificateur, String cle) throws ExceptionEchangeablePasDeTag{
		Fichier f = Fichier.nouveauFichier(url, utilisateurs.get(identificateur), pere, this.tags.get(t));
		this.echangeables.put(url, f);
		f.sauver();
	}
	
	//Auteur : Nono
	public Set<$EchangeableAvecTag> listeEchangeableParTag(String urlTag, String identificateur, String cle)throws RemoteException{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification autorisation
		if( ! verifAutorisation.lectureTag(tags.get(urlTag), utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		Set<$EchangeableAvecTag> ret = new HashSet<$EchangeableAvecTag>();
		for(String s : echangeables.keySet()){
			_Echangeable ech = echangeables.get(s);
			if(ech instanceof $EchangeableAvecTag){
				$EchangeableAvecTag ech2 = ($EchangeableAvecTag)ech;
				if(ech2.getTags().contains(tags.get(urlTag))){
					ret.add(ech2);
				}
			}
		}
		return ret;
	}
	
	private Set<_Echangeable> getContenu(Class cl, String identificateur, String cle){
		Set<_Echangeable> ret = new HashSet<_Echangeable>();
		for(String url : this.echangeables.keySet()){
			_Echangeable ech = this.echangeables.get(url);
			if(cl.isInstance(ech) && verifAutorisation.lecture((($EchangeableAvecTag)ech), this.utilisateurs.get(identificateur))){
				ret.add(ech);
			}
		}
		return ret;
	}
	
	//Auteur : Nono
	public Set<Post> getPosts(String identificateur, String cle) throws RemoteException{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<Post> ret = (Set)getContenu(Post.class, identificateur, cle);
		return ret;
	}
	
	//Auteur : Nono
	public Set<Fichier> getFichier(String identificateur, String cle) throws RemoteException{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set<Fichier> ret = (Set)getContenu(Fichier.class, identificateur, cle);
		return ret;
	}
	
	public Set<Tag> getTagsDroitCreation(String identificateur, String cle) throws RemoteException{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);

		Set<Tag> ret = new HashSet<Tag>();
		for(String tag : this.tags.keySet()){
			Tag t = this.tags.get(tag);
			if(verifAutorisation.creationTag(t, this.utilisateurs.get(identificateur))){
				ret.add(t);
			}
		}
		return ret;
	}
	
	public _Echangeable getEchangeable(String url, String identificateur, String cle) throws RemoteException, ExceptionEchangeableInexistant{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		Utilisateur utilisateur = utilisateurs.get(identificateur);
		//VerifExistance
		_Echangeable ech = this.echangeables.get(url);
		if(! (ech !=null)){throw new ExceptionEchangeableInexistant();}
		//VerifAutorisation
		if(! (ech instanceof $EchangeableAvecTag && verifAutorisation.lecture(($EchangeableAvecTag)ech, utilisateur))){throw new ExceptionAutorisationManquante();}
		if(! (ech instanceof MessageInterne && ((MessageInterne)ech).getDestinataire().equals(utilisateur))){throw new ExceptionAutorisationManquante();}
		
		return ech;
	}
	
	
	@Override
	public void enleverTag(String url, String tag, String identificateur, String cle) throws ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		_Echangeable ech = this.echangeables.get(url);
		if (! (ech instanceof $EchangeableAvecTag)){throw new ExceptionEchangeableMauvaisType();}
		//Verification autorisation
		if( ! verifAutorisation.suppressionTag(tags.get(tag), utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		try{
		(($EchangeableAvecTag)ech).enleverTag(this.tags.get(tag));
		(($EchangeableAvecTag)ech).sauver();
		}catch(ExceptionEchangeablePasDeTag e){
			(($EchangeableAvecTag)ech).detruireSauvegarde();
			this.echangeables.remove(url);
		}
	}
	
	public void ajouterTagSurEchangeable(String urlEch, String urlTag, String identificateur, String cle) throws RemoteException, ExceptionEchangeableMauvaisType, ExceptionEchangeablePasDeTag{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verif sémantique
		_Echangeable ech = this.echangeables.get(urlEch);
		if (! (ech instanceof $EchangeableAvecTag)){throw new ExceptionEchangeableMauvaisType();}
		//Verif sémantique 2
		if( ! (this.tags.get(urlTag) != null)){throw new ExceptionEchangeablePasDeTag();}
		//Verification autorisation
		if( ! verifAutorisation.creationTag(tags.get(urlTag), utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		(($EchangeableAvecTag)ech).ajouterTag(this.tags.get(urlTag));
	}
	
	/**
	 * POST	
	 */
	//Auteur Fanny
	@Override

	public void creerPost(String url, String titre, String urlTag, String identificateur, String cle)
			throws RemoteException, ExceptionEchangeablePasDeTag {
		//vérification identité
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Ajout du post échangeable
		Tag t = tags.get(urlTag);
	
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
		if( ! verifAutorisation.modification((Post)ech, utilisateurs.get(identificateur)))throw new ExceptionAutorisationManquante();
		
		
		((Post)ech).repondre(new MessagePost(utilisateurs.get(identificateur), contenu));
		ech.sauver();
		
	}
	
	public void supprimerEchangeable(String url, String identificateur, String cle) throws RemoteException{
		//Verification identite
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//Verification Droit
		if ( ! verifAutorisation.aSpecifiqueSuppression(url, this.utilisateurs.get(identificateur))){
			throw new ExceptionAutorisationManquante();
		};
		
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech==null)){
			ech.detruireSauvegarde();
			this.echangeables.remove(url);
		}
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
	public void envoieMessageInterne(String contenu, String objet, String identificateur, String cle,
		String identificateurDestinataire) throws RemoteException, UtilisateurException {
		//vérification identité emetteur
		verifIdentite.verificationIdentiteUtilisateur(identificateur, cle, utilisateurs);
		//vérification identité destinataire
		Utilisateur destinataire =utilisateurs.get(identificateurDestinataire);
		if(!(destinataire !=null))throw new UtilisateurException("est Utilisateur");
		//Ajout du message échangeable
		String url = ""+System.currentTimeMillis()+objet+identificateur+identificateurDestinataire;
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
			MessageInterne message = ((MessageInterne)ech).reponse(contenu);
			message.sauver();
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
		MessageInterne message = ((MessageInterne)ech).reponse(contenu);
		message.sauver();	
	}
	

	/**
	 * ADMINISTRATEUR
	 */
	//Auteur : Fanny
	@Override
	public void creerTag(String nomTag, String identificateur, String cle) throws RemoteException, ExceptionEchangeableTagExistant {
		//Vérification identité
		if(!(verifIdentite.estAdmin(identificateur, cle, utilisateurs)))throw new AdministrateurException("est Administrateur");
		//Vérification existence du tag
		Tag tag = new Tag(nomTag);
		if(this.tags.containsKey(nomTag)) throw new ExceptionEchangeableTagExistant();
		//Ajout du tags dans la liste des tags
		this.tags.put(nomTag,tag);
		tag.sauver();
	}

	@Override
	public String test() throws RemoteException {
		return "Ca marche fdp";
	}


	@Override
	public void supprimerTag(String tag, String identificateur, String cle)throws RemoteException, AdministrateurException {
		//Vérification identité
		if(!(verifIdentite.estAdmin(identificateur, cle, utilisateurs)))throw new AdministrateurException("est Administrateur");
		//Vérification existence du tag
		Tag t = this.tags.get(tag);
		if(t!=null) {
			for(String url : this.echangeables.keySet()){
				_Echangeable ech = this.echangeables.get(url);
				if( ech instanceof $EchangeableAvecTag && (($EchangeableAvecTag)ech).aLeTag(t)){
					try {
						this.enleverTag(url, tag, identificateur, cle);
					} catch (ExceptionEchangeableMauvaisType e) {}
				}
			}
			this.tags.remove(tag);
		}
		
	}
	
	
	/*
	 * @author : Anasse
	 * Permet d'ajouter des droits aux utilisateus
	 */
	@Override
	public void partageDroits(String idVictime,  String tag, int numeroDroit, String idResponsable, String cle){
		if( !(verifIdentite.estUtilisateur(idResponsable, cle, utilisateurs)) ) throw new UtilisateurException();
		Utilisateur victime   = utilisateurs.get(idVictime);
		Utilisateur responsable = utilisateurs.get(idResponsable);
		if( ! (victime != null)) throw new UtilisateurException("Bonjour");
		if( ! (verifAutorisation.droitTag(tags.get(tag), responsable, 2) && (verifAutorisation.droitTag(tags.get(tag), responsable, numeroDroit) ))) throw new ExceptionAutorisationManquante();
		if( ! victime.aAutorisation(tags.get(tag))){
			victime.ajouterAut(tags.get(tag));
			victime.getDroits(tags.get(tag)).ajouterDroits(numeroDroit);

		}else{
		victime.getDroits(tags.get(tag)).ajouterDroits(numeroDroit);}
		victime.sauver();
	}

	@Override
	public void supprimerDroits(String idVictime, String tag, int numeroDroit, String idResponsable,
			String cle) {
		if( ! (verifIdentite.estAdmin(idResponsable, cle, utilisateurs))) throw new AdministrateurException();
		Utilisateur victime = utilisateurs.get(idVictime);
		if( ! (victime != null)) throw new UtilisateurException("Utilisateur inexistant");
		victime.getDroits(tags.get(tag)).supprimerDroits(numeroDroit);
		victime.sauver();
	}
	
	public void supprimerUtilisateur(String idSupprime, String idResponsable, String cle){
		if( ! (verifIdentite.estAdmin(idResponsable, cle, utilisateurs))) throw new AdministrateurException();
		Utilisateur victime = utilisateurs.get(idSupprime);
		if( ! (victime != null)) throw new UtilisateurException("Utilisateur inexistant");
		utilisateurs.remove(idSupprime);
	}


	public Set<MessageInterne> releverMessages(String identificateur , String cle ){
		Set<MessageInterne> messages = new HashSet<MessageInterne>() ; 
		if( ! (verifIdentite.estUtilisateur(identificateur, cle, utilisateurs))) throw new UtilisateurException();
		for(_Echangeable e : echangeables.values()){
			if(e.getClass().getName() == "pterodactyle.echangeable.MessageInterne"){
				messages.add((MessageInterne) e);
			}
		}
		return messages;
	}

	
	
	public void creerSpecifique(String urlEchangeable, String idBeneficiant , String identificateur , String cle) throws ExceptionEchangeableNonExistant {
		 if( ! (verifIdentite.estAdmin(identificateur, cle, utilisateurs))) throw new AdministrateurException();
		 Utilisateur beneficiant = utilisateurs.get(idBeneficiant);
		if( ! (beneficiant  != null)) throw new UtilisateurException("Bonjour");
		 if ( ! echangeables.containsKey(urlEchangeable)) throw new ExceptionEchangeableNonExistant();
		 Specifique specifique = new Specifique(urlEchangeable);
		 utilisateurs.get(idBeneficiant).ajouterAut(specifique);
	}
	
	
	public void supprimerSpecifique(String urlSpecifique, String idUtilisateur, String idAmin, String cle){
		 if( ! (verifIdentite.estAdmin(idAmin, cle, utilisateurs))) throw new AdministrateurException();
		 if( ! (verifIdentite.estUtilisateur(idUtilisateur, cle, utilisateurs))) throw new UtilisateurException();
		 utilisateurs.get(idUtilisateur).supprimerSpec(urlSpecifique);
	}
	
	
	
	public void ajouterDroitsSpecifiques(String idUtilisateur,  String urlSpec, int numeroDroit, String idResponsable, String cle) throws ExceptionEchangeableNonExistant{
		if(! verifIdentite.estAdmin(idResponsable, cle, utilisateurs)) throw new AdministrateurException();
		Utilisateur utilisateur = utilisateurs.get(idUtilisateur);
		if( ! (utilisateur  != null)) throw new UtilisateurException("Bonjour");
		if( ! utilisateur.aSpecifique(urlSpec)){
			this.creerSpecifique(urlSpec, idUtilisateur, idResponsable, cle);
			System.out.println("Il ne l'a pas ");
			utilisateur.getDroits(utilisateur.getSpecifique(urlSpec)).ajouterDroits(numeroDroit);
		}else{
			utilisateur.getDroits(utilisateur.getSpecifique(urlSpec)).ajouterDroits(numeroDroit);
		}
		
	}
	
	

}

