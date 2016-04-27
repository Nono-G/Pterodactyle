package pterodactyle.test;

import java.rmi.RemoteException;

import pterodactyle.coeur2.CoeurBase;
import pterodactyle.coeur2._ServicesCoeur;
import pterodactyle.echangeable.Tag;
import pterodactyle.utilisateur.Droits;
import pterodactyle.utilisateur.Utilisateur;
import pterodactyle.utilisateur.UtilisateurException;

public class testModificationDroitsCoeurs {
	public static boolean[] droits= new boolean[5];

	public static void main(String[] args)  {
		try{

			CoeurBase c = new CoeurBase("Petry", "abc");
			System.out.println("Coucou");

		}catch(Exception e){System.out.println("mort");}

	}
}
