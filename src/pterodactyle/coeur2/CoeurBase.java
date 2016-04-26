package pterodactyle.coeur2;

import java.rmi.RemoteException;
import java.util.*;

import pterodactyle.coeur.Utilisateurs;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.Utilisateur;

public class CoeurBase extends $Coeur {
	
	protected Set<Tag> tags;
	protected Map<String, Utilisateur> utilisateurs;
	protected Set<_Echangeable> echangeables;

	protected CoeurBase() throws RemoteException {
		super();
		this.utilisateurs = new HashMap<String, Utilisateur>();
		this.tags = new HashSet<Tag>();
		this.echangeables = new HashSet<_Echangeable>();
		
	}
	
	public void creerUtilisateur(Utilisateur nouveau, String identificateur, String cle) {
		verifIdentite.estAdmin(identificateur, cle, utilisateurs);
		this.utilisateurs.put(nouveau.getLogin(), nouveau);
	}
	
}
