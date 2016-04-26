package pterodactyle.coeur;

import java.util.HashMap;

import pterodactyle.rmi.ServicesRmi;
import pterodactyle.utilisateur.Utilisateur;

public  class Utilisateurs {
	
	private static HashMap< String , Utilisateur > listeUtilisateurs = new HashMap< String , Utilisateur >();
	
	public static boolean estUtilisateur(String login, String mdp){
		Utilisateur utilisateur = listeUtilisateurs.get(login);
		if( utilisateur != null){
			return mdp == utilisateur.getMdp();
		}
		return false;
	}
	
	public static void ajouterUtilisateur(Utilisateur utilisateur) {
		listeUtilisateurs.put(utilisateur.getLogin(), utilisateur);
	}
	
	public static Utilisateur getUtilisateur(String login, String motDePasse){
		if(! Utilisateurs.estUtilisateur(login, motDePasse)) throw new UtilisateurException("est Utilisateur");
		if(! listeUtilisateurs.get(login).estAdmin()) throw new AdministrateurException("est Admin");
		return listeUtilisateurs.get(login);
	}

}
