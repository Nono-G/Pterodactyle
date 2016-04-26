package pterodactyle.coeur2;

import java.rmi.RemoteException;
import java.util.*;

import pterodactyle.coeur.UtilisateurException;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;

public class CoeurBase extends $Coeur {

	private static final long serialVersionUID = -5431026872014363966L;
	protected Set<Tag> tags;
	protected Map<String, Utilisateur> utilisateurs;
	protected Map<String, _Echangeable> echangeables;

	protected CoeurBase() throws RemoteException {
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashSet<Tag>();
		this.echangeables = new HashMap<String, _Echangeable>();
		
	}
	
	public void verificationIdentiteUtilisateur(Utilisateur utilisateurCourant){
		if(verifIdentite.estUtilisateur(utilisateurCourant, utilisateurs)) throw new UtilisateurException("est Utilisateur");
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
		verificationIdentiteUtilisateur(utilisateurCourant);
		return utilisateurs.get(identificateur);
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
	
}
