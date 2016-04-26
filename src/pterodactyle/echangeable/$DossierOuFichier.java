package pterodactyle.echangeable;

import pterodactyle.utilisateur.Utilisateur;

public abstract class $DossierOuFichier extends $EchangeableAvecTag {

	private static final long serialVersionUID = -6482599174615139559L;
	
	//Dossier dans lequel se trouve l'élément, null si il est a la racine. (= ..)
	protected Dossier pere;

	public $DossierOuFichier(String nom, Utilisateur ut, Dossier d) {
		super(nom, ut);
		this.pere = d;
	}
	
	public abstract boolean estDossier();

}