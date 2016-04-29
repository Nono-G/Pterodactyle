package pterodactyle.echangeable;

import java.io.Serializable;

import pterodactyle.utilisateur.Utilisateur;

//Interface définissant les méthodes attendues sur un échangeable
public interface _Echangeable extends Serializable{
	
	//Sauvegarde l'échangeable
	public void sauver();
	
	public void detruireSauvegarde();
	
	public String getUrl();
	
	public Utilisateur getAuteur();
	
}
