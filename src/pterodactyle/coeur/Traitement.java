package pterodactyle.coeur;

import java.rmi.RemoteException;

import pterodactyle.rmi.ServicesRmi;
import pterodactyle.utilisateur.Utilisateur;

public class Traitement  implements ServicesRmi  {

	public Traitement() {
	}

	@Override
	public String getUSer(String nom, String prenom) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse,
			boolean admin, Utilisateur utilisateurCourant) {
<<<<<<< HEAD
		Utilisateur utilisateur = new Utilisateur(nom, prenom, loginFuturUtilisateur, motDePasse, admin);
		Utilisateurs.ajouterUtilisateur(utilisateur);
=======
>>>>>>> be4b683fcd9ecec807323a07f08d319f1ab05a0c
		
	}



}
