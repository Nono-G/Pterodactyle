package pterodactyle.echangeable;

import java.util.ArrayList;
import java.util.List;

import pterodactyle.utilisateur.Utilisateur;

public class Post extends $EchangeableAvecTag {
	
	private static final long serialVersionUID = 9122133390678416634L;
	
	protected List<MessagePost> messages;
	protected String titre;
	
	//Constructeur d'un post
	private Post(String nom, Utilisateur ut, String titre, Tag t){
		super(nom,ut,t);
		this.titre = titre;
		this.messages = new ArrayList<MessagePost>();
	}
	
	//Constructeur
	public static Post nouveauPost(String nom, Utilisateur ut, String titre, Tag t) throws ExceptionEchangeablePasDeTag {
		if( ! (t != null))throw new ExceptionEchangeablePasDeTag();
		return new Post(nom, ut,titre, t);
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
	public Dossier getPere(){
		return null;
	}

}
