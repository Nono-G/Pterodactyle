package pterodactyle.utilisateur;

public class Droits {	
	
	
	//tableau des droits dans cet ordre : 
	// 0 : lecture / 1 : modification / 2 : partage / 3 :creation / 4 : suppression
	protected boolean[] droits = new boolean[5];
	
	
	//Droit de base => tout faux
	public Droits(){
		initDroits();
	}
	
	//Creation de droit personnalise 
	public Droits(boolean[] nouveauDroits){
		setDroits(nouveauDroits);
	}
	
	/*
	 * Methode pour modifier les droits 
	 * @require : nouveauDroits.length = 5
	 * @return : le tableau des droits mis a jour avec les nouveaux
	 */
	public void setDroits(boolean[] nouveauDroits){
		for(int i = 0; i < droits.length; i++){
			droits[i] = nouveauDroits[i];
		}
	}
	
	public boolean[] getDroits(){
		return this.droits;
	}
	
	
	/*
	 * initialisation des droits a false 
	 */
	public void initDroits(){
		for(int i  =0; i< droits.length ;i++ ){
			droits[i] = false;
		}	
	}
	
	
	/*
	 * retourne un affichage en string des droits donnees ou non
	 */
	public String toString(){
		String res = "Lecture      | Modification | Partage      | Creation     | Suppression  |\n";
		for(int i = 0 ; i < this.droits.length ; i++){
			if(droits[i] == true){
				
				res = res +"Oui          | ";
			}
			else{
				res = res +"Non          | ";
			}
		}
		return res;
	}
}
