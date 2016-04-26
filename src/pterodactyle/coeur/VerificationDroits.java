package pterodactyle.coeur;

import java.rmi.RemoteException;

import pterodactyle.rmi.*;
import pterodactyle.utilisateur.Utilisateur;

public class VerificationDroits implements ServicesRmi{
<<<<<<< HEAD
	Traitement t ;

=======
	Traitement t = new Traitement();
	@Override
	public String getUSer(String nom, String prenom) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
>>>>>>> 3596e1e02af2c6370bc89534be93a8ea21f7ca98
	
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
