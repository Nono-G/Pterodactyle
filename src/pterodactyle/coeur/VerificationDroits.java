package pterodactyle.coeur;

import java.rmi.RemoteException;

import pterodactyle.rmi.*;
import pterodactyle.utilisateur.Utilisateur;

public class VerificationDroits implements ServicesRmi{

	$Traitement t = new TraitementJava();


	
	public void creerUtilisateur(Utilisateur utilisateur, String login, String mdp){
		if( ! utilisateur.estAdmin()){
			throw new AdministrateurException("Est admin");
		}
		
	}

	@Override
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse,
			boolean admin, Utilisateur utilisateurCourant) throws RemoteException {
		if( ! utilisateurCourant.estAdmin()){
			throw new AdministrateurException("Est admin");
		}
		t.creerUtilisateur(nom, prenom, loginFuturUtilisateur, motDePasse, admin, utilisateurCourant);
	}

	@Override
	public Utilisateur utilisateurCourant(String login, String motDePasse) throws RemoteException {
		return t.utilisateurCourant(login, motDePasse);
	}

	@Override
	public Utilisateur voirUtlisateur(String login, Utilisateur utilisateurCourant) throws RemoteException {
		
		return t.voirUtlisateur(login, utilisateurCourant);
	}
	
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant) throws RemoteException{
		if(! droitLecture(url, utilisateurCourant))throw new RuntimeException();
		return t.trancheFichier(url, n, tailleTampon, utilisateurCourant);
	}
	
	public boolean droitLecture(String url, Utilisateur utilisateurCourant){
		return false;
	}
	
	public boolean droitModification(String url, Utilisateur utilisateurCourant){
		return false;
	}
	
	public boolean droitPartage(String url, Utilisateur utilisateurCourant){
		return false;
	}
	
	public boolean droitCreation(String url, Utilisateur utilisateurCourant){
		return false;
	}
	
	public boolean droitSuppression(String url, Utilisateur utilisateurCourant){
		return false;
	}
}
