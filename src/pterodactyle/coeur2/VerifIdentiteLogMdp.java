package pterodactyle.coeur2;

import java.util.Map;

import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.utilisateur.UtilisateurException;

public class VerifIdentiteLogMdp implements _VerifIdentite{

	public void verificationIdentiteUtilisateur(String identificateur, String cle,Map<String, Utilisateur> utilisateurs){
		if( ! estUtilisateur(identificateur, cle, utilisateurs)) throw new UtilisateurException("est Utilisateur");
	}
	
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
			return utilisateur.getCle().equals(cle) && utilisateur.estAdmin();
		}
		return false;
	}
	
}
