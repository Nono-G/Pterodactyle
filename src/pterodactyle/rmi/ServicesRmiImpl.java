package pterodactyle.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pterodactyle.coeur.Utilisateurs;
import pterodactyle.coeur.VerificationDroits;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.utilisateur.UtilisateurException;

public class ServicesRmiImpl extends UnicastRemoteObject implements ServicesRmi {

	VerificationDroits droit = new VerificationDroits();

	private static final long serialVersionUID = 958097467225680669L;

	public ServicesRmiImpl() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}

	public void verification(Utilisateur utilisateurCourant ){
		if(!Utilisateurs.estUtilisateur(utilisateurCourant.getLogin(), utilisateurCourant.getCle())) throw new UtilisateurException("Est utilisateur");
	}
	
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse, boolean admin, Utilisateur utilisateurCourant) throws RemoteException{
		verification(utilisateurCourant);
		droit.creerUtilisateur(nom,prenom,loginFuturUtilisateur,motDePasse,admin,utilisateurCourant);		
	}


	@Override
	public Utilisateur utilisateurCourant(String login, String motDePasse) throws RemoteException {
		if(!Utilisateurs.estUtilisateur(login, motDePasse)) throw new UtilisateurException("Est utilisateur");
		return droit.utilisateurCourant(login, motDePasse);
	}

	@Override
	public String voirUtilisateur(String login, Utilisateur utilisateurCourant) throws RemoteException {
		verification(utilisateurCourant);
		return droit.voirUtilisateur(login, utilisateurCourant);
	}
	
	public void creerPost(Utilisateur auteur, String login , String motDePasse, Post post){
		verification(auteur);
	}

	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant) throws RemoteException{
		verification(utilisateurCourant);
		return droit.trancheFichier(url, n, tailleTampon, utilisateurCourant);
		
	}


}
