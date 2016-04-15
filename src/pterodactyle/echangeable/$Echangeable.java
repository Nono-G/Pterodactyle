package pterodactyle.echangeable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pterodactyle.utilisateur.*;

//Classe abstraite Echangeable général pour réunir les attributs communs
public abstract class $Echangeable implements _Echangeable {

		protected Date dateCreation;//Date a laquelle un échangeable à été mis en ligne sur le serveur
		protected String nom;//Nom sous lequel l'échangeable est connu sur le serveur
		protected Utilisateur auteur;//Utilisateur qui est l'auteur de cet échangeable
		protected List<Utilisateur> modifieurs;//Liste des utilisateurs ayant apporté des modifications au fichier
		
		public $Echangeable(String nom, Utilisateur ut){
			this.modifieurs = new ArrayList<Utilisateur>();
			this.dateCreation = new Date(System.currentTimeMillis());
			this.nom = nom;
			this.auteur = ut;
		}
		
}
