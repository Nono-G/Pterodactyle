package pterodactyle.coeur2;

import java.rmi.Remote;
import java.rmi.RemoteException;

import pterodactyle.utilisateur.Utilisateur;

public interface _ServicesCoeur extends Remote {

	
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle);
	
	
	public Utilisateur utilisateurCourant(String login, String motDePasse)throws RemoteException;
	

	public String voirUtilisateur(String login, Utilisateur utilisateurCourant)throws RemoteException;

	
	public Object[] trancheFichier(String url, int n, int tailleTampon, Utilisateur utilisateurCourant) throws RemoteException;
	
}
