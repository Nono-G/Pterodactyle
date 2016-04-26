package pterodactyle.coeur;

import java.rmi.RemoteException;

import pterodactyle.rmi.*;
import pterodactyle.utilisateur.Utilisateur;

public class VerificationDroits implements ServicesRmi{

	@Override
	public String getUSer(String nom, String prenom) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void creerUtilisateur(Utilisateur utilisateur, String login, String mdp){
		if(utilisateur.estAdmin()){
			
		}
	}
	
	
}
