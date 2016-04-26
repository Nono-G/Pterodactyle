package pterodactyle.echangeable;

import java.util.List;

import pterodactyle.utilisateur.Utilisateur;

public class Dossier extends $DossierOuFichier{

	private static final long serialVersionUID = 7776681461125288220L;
	
	//les fichiers et les dossiers contenus dans ce dossier
	protected List<$DossierOuFichier> contenu;
	
	public Dossier(String nom, Utilisateur ut, Dossier pere) {
		super(nom, ut, pere);
		// TODO Auto-generated constructor stub
	}
	
	//Renvoie true car l'objet est un dossier
	@Override
	public boolean estDossier() {
		return true;
	}
	
	

}
