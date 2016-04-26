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
	public void creerUtilisateur(Utilisateur utilisateur, String login, String mdp) {
		
	}

}
