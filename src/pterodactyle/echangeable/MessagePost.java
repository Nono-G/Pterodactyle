package pterodactyle.echangeable;

import pterodactyle.utilisateur.*;

import java.io.Serializable;
import java.util.Date;

public class MessagePost implements Serializable {
	
	private static final long serialVersionUID = -2438769035031697711L;
	
	private Utilisateur auteur; //L'auteur du message
	private Date dateAjout;     //La date de l'ajout de la réponse
	private String texte;       //Le contenu du message
	
	public MessagePost(Utilisateur user, String text){
		this.dateAjout = new Date(System.currentTimeMillis());
		this.auteur = user;
		this.texte = text;
	}
	
	
	public String toString(){
		return "[ "+auteur.toString()+" - "+dateAjout.toString()+"\n"+this.texte+"\n\t]\n";
	}


	public Utilisateur getAuteur() {
		return auteur;
	}

}
