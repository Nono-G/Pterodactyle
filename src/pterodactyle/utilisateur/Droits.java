package pterodactyle.utilisateur;

public class Droits {	
	
	
	//tableau des droits dans cet ordre : 
	// 0 : lecture / 1 : modification / 2 : partage / 3 :creation / 4 : suppression
	private boolean[] droits = new boolean[5];
	private int nbDroits = 5; 
	private int lecture = 0;
	private int modification = 1;
	private int partage = 2;
	private int creation = 3;
	private int suppression = 4;
	
	
	/*
	 * Methode pour modifier les droits 
	 */
	public void setDroits(int [] t ){
		initDroits();
		
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
