package pterodactyle.echangeable;

import java.util.ArrayList;
import java.util.List;

import pterodactyle.utilisateur.Utilisateur;

public class Dossier extends $DossierOuFichier{

	//les fichiers et les dossiers contenus dans ce dossier
	protected List<$DossierOuFichier> contenu;
	
	private Dossier(String nom, Utilisateur ut, Dossier pere, Tag t) {
		super(nom, ut, pere, t);
		this.contenu = new ArrayList<$DossierOuFichier>();
	}
	
	//Contructeur
	public static Dossier nouveauDossier(String nom, Utilisateur ut, Dossier pere, Tag t) throws ExceptionEchangeablePasDeTag {
		if( ! (t != null))throw new ExceptionEchangeablePasDeTag();
		return new Dossier(nom, ut, pere, t);
	}
	
	//Renvoie true car l'objet est un dossier
	@Override
	public boolean estDossier() {
		return true;
	}

	//Permet de rajouter un élément dans le fichier
	public void ajouterDans ($DossierOuFichier nouveau){
		this.contenu.add(nouveau);
		for(Tag t : this.tags){
			nouveau.ajouterTag(t);
		}
	}
	
	//Retire un élément du dossier sil il y est présent, rien sinon
	public void retirerDe ($DossierOuFichier dof){
		this.contenu.remove(dof);
	}
	
	//Récupère l'élément i du dossier
	public $DossierOuFichier get(int i){
		return this.contenu.get(i);
	}
	
	


}
