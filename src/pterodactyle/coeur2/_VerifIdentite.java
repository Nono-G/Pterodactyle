package pterodactyle.coeur2;

import java.util.*;

import pterodactyle.utilisateur.Utilisateur;

public interface _VerifIdentite {
	
	public void verificationIdentiteUtilisateur(Utilisateur utilisateurCourant,Map<String, Utilisateur> utilisateurs);
	
	public boolean estUtilisateur(Utilisateur utilisateur, Map<String, Utilisateur> utilisateurs);
	
	public boolean estUtilisateur(String identificateur, String cle, Map<String, Utilisateur> utilisateurs);
	
	public boolean estAdmin(Utilisateur utilisateur, Map<String, Utilisateur> utilisateurs);
}
