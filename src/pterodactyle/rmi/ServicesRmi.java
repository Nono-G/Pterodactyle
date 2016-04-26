package pterodactyle.rmi;

import java.rmi.*;

import pterodactyle.utilisateur.Utilisateur;


public interface ServicesRmi extends Remote{
	
	
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse, boolean admin, Utilisateur utilisateurCourant)throws RemoteException;
	
	public Utilisateur utilisateurCourant(String login, String motDePasse)throws RemoteException;

}
