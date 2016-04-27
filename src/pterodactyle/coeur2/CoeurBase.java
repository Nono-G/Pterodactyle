package pterodactyle.coeur2;

import java.rmi.RemoteException;
import java.util.*;

import pterodactyle.coeur.Utilisateurs;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;

public class CoeurBase extends $Coeur {
	
	protected Set<Tag> tags;
	protected Map<String, Utilisateur> utilisateurs;
	protected Map<String, _Echangeable> echangeables;

	protected CoeurBase() throws RemoteException {
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashSet<Tag>();
		this.echangeables = new HashMap<String, _Echangeable>();
		
	}
	
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle) {
		verifIdentite.estAdmin(identificateur, cle, utilisateurs);
		this.utilisateurs.put(nouveau.getLogin(), nouveau);
	}

	@Override
	public Utilisateur utilisateurCourant(String login, String motDePasse) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String voirUtilisateur(String login, Utilisateur utilisateurCourant) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableFichierFini, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.estUtilisateur(utilisateurCourant, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof Fichier)) throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		verifAutorisation.lecture((Fichier)ech, utilisateurCourant);
		
		return ((Fichier)ech).obtenirTranche(n, tailleTampon);
	}

	@Override
	public void repondrePost(String url, String contenu, Utilisateur utilisateurCourant)
			throws RemoteException, ExceptionEchangeableMauvaisType {
		//Verification identite
		verifIdentite.estUtilisateur(utilisateurCourant, utilisateurs);
		//Verification sémantique
		_Echangeable ech = this.echangeables.get(url);
		if( ! (ech instanceof Post)) throw new ExceptionEchangeableMauvaisType();
		//Verification autorisation
		verifAutorisation.ecriture((Post)ech, utilisateurCourant);
		
		((Post)ech).repondre(new MessagePost(utilisateurCourant, contenu));
		
	}
	//A FINIR
	@Override
	public void envoieMessageInterne(String url, String contenu, String objet, Utilisateur utilisateurCourant,
			String identificateurDestinataire) throws RemoteException, ExceptionEchangeableMauvaisType {
			//vérification identité emetteur
			verifIdentite.estUtilisateur(utilisateurCourant, utilisateurs);
			//vérification identité destinataire
			if(!(utilisateurs.get(identificateurDestinataire)!=null))throw new RemoteException();
			Utilisateur destinataire =utilisateurs.get(identificateurDestinataire);
			verifIdentite.estUtilisateur(destinataire, utilisateurs);
			//Ajout du message échangeable
			this.echangeables.put(url, new MessageInterne(url, utilisateurCourant, destinataire, contenu, objet));
		
	}
	
}
