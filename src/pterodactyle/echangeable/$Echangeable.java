package pterodactyle.echangeable;

import java.util.Date;
import java.util.List;


//Classe abstraite Echangeable général pour réunir les attributs communs
public abstract class $Echangeable implements _Echangeable {

		private Date dateCreation;//Date a laquelle un échangeable à été mis en ligne sur le serveur
		private String nom;//Nom sous lequel l'échangeable est connu sur le serveur
		private Utilisateur auteur;//Utilisateur qui est l'auteur de cet échangeable
		private List<Utilisateur> modifieurs;//Liste des utilisateurs ayant apporté des modifications au fichier
		
}
