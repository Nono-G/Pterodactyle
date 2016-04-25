package pterodactyle.coeur;

import java.util.HashMap;

import pterodactyle.utilisateur.Utilisateur;


public class Traitement {
	
	private static HashMap< String , Utilisateur > listeUtilisateurs = new HashMap< String , Utilisateur >();
	
	
	public Traitement(){}
	
	public boolean estUtilisateur(String login, String mdp){
		Utilisateur utilisateur = listeUtilisateurs.get(login);
		if( utilisateur != null){
			return mdp == utilisateur.getMdp();
		}
		return false;
	}
}
