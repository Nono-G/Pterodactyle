package pterodactyle.echangeable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import pterodactyle.utilisateur.Autorisation;

public class Tag extends Autorisation implements Serializable{
	
	private String nom;//Le nom du tag;
	
	public Tag (String nom){
		this.nom = nom;
	}
	
	//Retourne une représentation textuelle du tag.
	@Override
	public String toString(){
		return this.nom;
	}
	
	public void sauver(){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File ("sauv/tags/"+this.nom)))){
			oos.writeObject(this);
		}catch(IOException e){e.printStackTrace();}
	}
}
