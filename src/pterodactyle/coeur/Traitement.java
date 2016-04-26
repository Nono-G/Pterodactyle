package pterodactyle.coeur;

import java.rmi.RemoteException;

import pterodactyle.rmi.ServicesRmi;
import pterodactyle.utilisateur.Utilisateur;

public class Traitement  implements ServicesRmi  {

	public Traitement() {
	}



	@Override
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse,
			boolean admin, Utilisateur utilisateurCourant) {
		Utilisateur utilisateur = new Utilisateur(nom, prenom, loginFuturUtilisateur, motDePasse, admin);
		Utilisateurs.ajouterUtilisateur(utilisateur);
		
	}



	@Override
	public Utilisateur utilisateurCourant(String login, String motDePasse) throws RemoteException {
		return Utilisateurs.getUtilisateur(login, motDePasse);
	}



	@Override
	public Utilisateur voirUtlisateur(String login, Utilisateur utilisateurCourant) throws RemoteException {		
		return Utilisateurs.voirUtilisateur(login);
	}



}
