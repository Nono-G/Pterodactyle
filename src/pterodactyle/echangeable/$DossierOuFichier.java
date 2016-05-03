package pterodactyle.echangeable;

import pterodactyle.utilisateur.Utilisateur;

public abstract class $DossierOuFichier extends $EchangeableAvecTag {
	
	/*
	 * Invariant de classe : Mon nom doit commencer par mon arborescence (séparés par des '/') ???
	 */
	
	//Dossier dans lequel se trouve l'élément, null si il est a la racine. (= ..)
	protected Dossier pere;

	public $DossierOuFichier(String nom, Utilisateur ut, Dossier d, Tag t) {
		super(nom, ut, t);
		this.pere = d;
	}
	
	public abstract boolean estDossier();
	
	public  Dossier getPere(){
		return this.pere;
	};

}
