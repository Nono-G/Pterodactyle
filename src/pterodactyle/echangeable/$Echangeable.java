package pterodactyle.echangeable;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pterodactyle.utilisateur.*;

//Classe abstraite Echangeable général pour réunir les attributs communs
public abstract class $Echangeable implements _Echangeable {

	private static final long serialVersionUID = 9068503634795337620L;
	
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
		
		//Recontruire un échangeable sérializé à partir de son nom.
		public static $Echangeable charger (String nom){
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("sauv/"+nom)))){
				$Echangeable a = ($Echangeable) ois.readObject();
				return a;
			}catch(Exception e){e.printStackTrace();}
			return null;
		}
		
		//Sauvegarde l'échangeable (serialization)
		public void sauver(){
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("sauv/"+nom)))){
				oos.writeObject(this);
				oos.flush();
			}catch(IOException e){e.printStackTrace();}
		}		
}
