package pterodactyle.rmi;

import java.rmi.*;

import pterodactyle.utilisateur.Utilisateur;


public interface ServicesRmi extends Remote{
	
	public String getUSer(String nom, String prenom) throws RemoteException;
	
	public void creerUtilisateur(Utilisateur utilisateur, String login, String mdp);

}
