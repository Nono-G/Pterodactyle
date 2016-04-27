package pterodactyle.coeur;

import java.util.HashMap;

import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.utilisateur.UtilisateurException;

public  class Utilisateurs {
	
	private static HashMap< String , Utilisateur > listeUtilisateurs = new HashMap< String , Utilisateur >();
	
	public static void admin(){
		Utilisateur admin = new Utilisateur("maxime", "silvestre", "silvemax", "12345", false);
		listeUtilisateurs.put("silvemax", admin);
	}
	
	public static boolean estUtilisateur(String login, String mdp){
		Utilisateur utilisateur = listeUtilisateurs.get(login);
		if( utilisateur != null){
			return mdp.equals(utilisateur.getCle());
		}
		return false;
	}
	
	public static void ajouterUtilisateur(Utilisateur utilisateur) {
		listeUtilisateurs.put(utilisateur.getLogin(), utilisateur);
	}
	

	public static Utilisateur voirUtilisateur(String login){
		return listeUtilisateurs.get(login);
	}

	public static Utilisateur getUtilisateur(String login, String motDePasse){
		if(! Utilisateurs.estUtilisateur(login, motDePasse)) throw new UtilisateurException("est Utilisateur");
		return listeUtilisateurs.get(login);
	}

}
