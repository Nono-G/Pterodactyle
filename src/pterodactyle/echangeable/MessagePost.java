package pterodactyle.echangeable;

import pterodactyle.utilisateur.*;

import java.io.Serializable;
import java.util.Date;

public class MessagePost implements Serializable {
	
	private Utilisateur auteur; //L'auteur du message
	private Date dateAjout;     //La date de l'ajout de la réponse
	private String texte;       //Le contenu du message, non vide
	
	public MessagePost(Utilisateur user, String text){
		this.dateAjout = new Date(System.currentTimeMillis());
		this.auteur = user;
		this.texte = text;
	}
	
	
	public String toString(){
		return "[ "+auteur.toString()+" - "+dateAjout.toString()+"\n"+this.texte+"\n\t]\n";
	}

	public String affichage2(){
		return "[ "+auteur.toString()+" - "+dateAjout.toString()+"\n"+tabuler(1)+"\n\t]\n";
	}
	
	public String tabuler(int n){
		String tab = "";
		int j = 0;
		while(j<n){
			tab+="\t";
			j++;
		}
		String ret = tab+this.texte;
		int index = n;
		while(index < ret.length()-1){
			if(ret.charAt(index) == '\n'){
				String deb = ret.substring(0, index);
				String fin = ret.substring(index, ret.length());
				ret = deb+tab+fin;
				index += n;
			}
			index++;
		}
		return ret;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

}
