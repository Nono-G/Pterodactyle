package pterodactyle.echangeable;

import java.util.ArrayList;
import java.util.List;

import pterodactyle.utilisateur.Utilisateur;

public class Post extends $EchangeableAvecTag {
	
	protected List<MessagePost> messages;
	protected String titre;
	
	//Constructeur d'un post
	public Post(String nom, Utilisateur ut, String titre){
		super(nom,ut);
		this.titre = titre;
		this.messages = new ArrayList<MessagePost>();
	}
	
	//Constructeur pour charger un post depuis un fichier
	/*
	public Post(String chemin){
		
	}
	*/
	
	//Ajouter une réponse à la suite dans le post
	public void repondre(MessagePost m){
		this.messages.add(m);
		this.modifieurs.add(m.getAuteur());
	}
	
	//Représentation textuelle du post.	
	public String toString(){
		String ret = "[ "+titre+" - "+auteur.toString()+" - "+dateCreation.toString()+"\n";
		for(MessagePost m : messages ){
			ret += m.toString();
		}
		ret +="]\n";
		return ret;
	}

	@Override
	//Sauver un post dans un fichier texte dont le nom est le nom d'échangeable du post
	public void sauver() {
		// TODO Auto-generated method stub
		
	}

}
