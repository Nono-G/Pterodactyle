package pterodactyle.coeur;

import java.rmi.RemoteException;

import pterodactyle.rmi.*;
import pterodactyle.utilisateur.Utilisateur;

public class VerificationDroits implements ServicesRmi{

	Traitement t = new Traitement();


	
	public void creerUtilisateur(Utilisateur utilisateur, String login, String mdp){
		if( ! utilisateur.estAdmin()){
			throw new AdministrateurException("Est admin");
		}
		
	}

	@Override
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse,
			boolean admin, Utilisateur utilisateurCourant) {
		if( ! utilisateurCourant.estAdmin()){
			throw new AdministrateurException("Est admin");
		}
		t.creerUtilisateur(nom, prenom, loginFuturUtilisateur, motDePasse, admin, utilisateurCourant);
	}

	@Override
	public Utilisateur utilisateurCourant(String login, String motDePasse) throws RemoteException {
		return t.utilisateurCourant(login, motDePasse);
	}
	
	
}
