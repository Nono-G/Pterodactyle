package pterodactyle.coeur2;

import java.util.Map;

import pterodactyle.utilisateur.Utilisateur;

public class VerifIdentiteLogMdp implements _VerifIdentite{

	@Override
	public boolean estUtilisateur(String identificateur, String cle, Map<String, Utilisateur> utilisateurs) {
		Utilisateur utilisateur = utilisateurs.get(identificateur);
		if( utilisateur != null){
			return cle.equals(utilisateur.getCle());
		}
		return false;
	}
	
	public boolean estAdmin(String identificateur, String cle, Map<String, Utilisateur> utilisateurs) {
		Utilisateur utilisateur = utilisateurs.get(identificateur);
		if( utilisateur != null){
			return cle.equals(utilisateur.getCle()) && utilisateur.estAdmin();
		}
		return false;
	}
	
}
