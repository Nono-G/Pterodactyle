package pterodactyle.rmi;

import java.rmi.*;

import pterodactyle.utilisateur.Utilisateur;


public interface ServicesRmi extends Remote{
	
	public String getUSer(String nom, String prenom) throws RemoteException;
	
	public void creerUtilisateur(String nom, String prenom, String loginFuturUtilisateur, String motDePasse, boolean admin, Utilisateur utilisateurCourant);

}
