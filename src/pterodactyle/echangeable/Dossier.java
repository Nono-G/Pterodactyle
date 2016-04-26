package pterodactyle.echangeable;

import java.util.ArrayList;
import java.util.List;

import pterodactyle.utilisateur.Utilisateur;

public class Dossier extends $DossierOuFichier{

	private static final long serialVersionUID = 7776681461125288220L;
	
	//les fichiers et les dossiers contenus dans ce dossier
	protected List<$DossierOuFichier> contenu;
	
	public Dossier(String nom, Utilisateur ut, Dossier pere) {
		super(nom, ut, pere);
		this.contenu = new ArrayList<$DossierOuFichier>();
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
	
	@Override
	public void ajouterTag( Tag t){
		this.tags.add(t);
		for($DossierOuFichier d : contenu){
			d.ajouterTag(t);
		}
	}

}
