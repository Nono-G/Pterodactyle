package pterodactyle.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pterodactyle.coeur.UtilisateurException;
import pterodactyle.coeur.Utilisateurs;
import pterodactyle.coeur.VerificationDroits;
import pterodactyle.utilisateur.Utilisateur;

public class ServicesRmiImpl extends UnicastRemoteObject implements ServicesRmi {

	VerificationDroits a;

	private static final long serialVersionUID = 958097467225680669L;

	public ServicesRmiImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUSer(String nom, String prenom) throws RemoteException {

		return nom + " " + prenom;
	}

	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse, boolean admin, Utilisateur utilisateurCourant){
		if(!Utilisateurs.estUtilisateur(utilisateurCourant.getLogin(), utilisateurCourant.getMdp())) throw new UtilisateurException("Est utilisateur");
		a.creerUtilisateur(nom,prenom,loginFuturUtilisateur,motDePasse,admin,utilisateurCourant.getLogin(),utilisateurCourant.getMdp());
		
	}

}
