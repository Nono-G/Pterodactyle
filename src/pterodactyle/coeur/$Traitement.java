package pterodactyle.coeur;

import pterodactyle.rmi.ServicesRmi;
import pterodactyle.utilisateur.Utilisateur;

import java.rmi.RemoteException;
import java.util.Set;

import pterodactyle.echangeable.*;

public abstract class $Traitement implements ServicesRmi{
	
	protected Set<_Echangeable> lesEchangeables;

	public Utilisateur voirUtlisateur(String login, Utilisateur utilisateurCourant) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
