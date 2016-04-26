package pterodactyle.echangeable;

import pterodactyle.utilisateur.Utilisateur;

public class MessageInterne extends $EchangeableSansTag {

	protected Utilisateur destinataire;
	protected String texte;
	protected String objet;
	
	public MessageInterne(String nom, Utilisateur ut, Utilisateur dest, String texte, String objet) {
		super(nom, ut);
		this.destinataire = dest;
		this.texte = texte;
		this.objet = objet;
	}
	
	public String voirTexte(){
		return new String(this.texte);
	}
	
	public String voirObjet(){
		return new String(this.objet);
	}
	
	@Override
	public String toString(){
		return "[ "+this.nom + " - "+this.dateCreation + "\n\tDe : "+this.auteur+"\n\tA : "+this.destinataire+"\n\tObjet : "+this.objet+"\n\t"+this.texte+"\n]";
		
	}
	
	public MessageInterne reponse(String t){
		return new MessageInterne(("Rep"+this.nom), this.destinataire, this.auteur, t,("Réponse : "+this.objet));
	}

}
