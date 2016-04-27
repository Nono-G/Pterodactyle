package pterodactyle.test;

import java.rmi.*;

import pterodactyle.coeur2.*;
import pterodactyle.utilisateur.*;

public class TestFichierCoeur {

	public static void main (String[] args){
	try{
		_ServicesCoeur c = new CoeurBase("Petry", "abc");
		try{
			Utilisateur moi = c.utilisateurCourant("Petry", "abc");
			tr(moi.toString());
			c.creerTag("Tag1", "Petry", "abc");
			Utilisateur moi2 = new Utilisateur("Goudian", "Noé", "goudn", "arg", false);
			
			try {
				c.creerUtilisateur(moi2, "Petry", "abc");
			} catch (Exception e) {e.printStackTrace();}
			
			
			tr("etape1");
		}catch(UtilisateurException e){tr("Inconnu");}
		
	}catch(RemoteException e){}
	
	
	}
	
	private static void tr (String t){
		System.out.println(t);
	}
}
