package pterodactyle.coeur2;

import java.util.*;

import pterodactyle.utilisateur.Utilisateur;

public interface _VerifIdentite {
	
	public boolean estUtilisateur(String identificateur, String cle, Map<String, Utilisateur> utilisateurs);
	
	public boolean estAdmin(String identificateur, String cle, Map<String, Utilisateur> utilisateurs);
}
