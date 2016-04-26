package pterodactyle.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pterodactyle.coeur.UtilisateurException;
import pterodactyle.coeur.Utilisateurs;
import pterodactyle.coeur.VerificationDroits;
import pterodactyle.utilisateur.Utilisateur;

public class ServicesRmiImpl extends UnicastRemoteObject implements ServicesRmi {

	VerificationDroits droit = new VerificationDroits();

	private static final long serialVersionUID = 958097467225680669L;

	public ServicesRmiImpl() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}

	public void verifaication(String login, String motDePasse){}
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse, boolean admin, Utilisateur utilisateurCourant){
		if(!Utilisateurs.estUtilisateur(utilisateurCourant.getLogin(), utilisateurCourant.getMdp())) throw new UtilisateurException("Est utilisateur");
<<<<<<< HEAD
		droit.creerUtilisateur(nom,prenom,loginFuturUtilisateur,motDePasse,admin,utilisateurCourant);
=======
		a.creerUtilisateur(nom,prenom,loginFuturUtilisateur,motDePasse,admin,utilisateurCourant);
>>>>>>> 3596e1e02af2c6370bc89534be93a8ea21f7ca98
		
	}


	@Override
	public Utilisateur utilisateurCourant(String login, String motDePasse) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
