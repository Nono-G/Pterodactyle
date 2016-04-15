package pterodactyle.utilisateur;

public class Droits {	
	
	
	//tableau des droits dans cet ordre : 
	// 0 : lecture / 1 : modification / 2 : partage / 3 :creation / 4 : suppression
	private boolean[] droits = new boolean[5];
	
	
	
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
	
	
	/*
	 * initialisation des droits a false pour tous
	 */
	public void initDroits(){
		for(int i  =0; i< droits.length ;i++ ){
			droits[i] = false;
		}	
	}
}
