package pterodactyle.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.util.Set;

import pterodactyle.coeur.*;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.AdministrateurException;
import pterodactyle.utilisateur.Utilisateur;

public class Test1 {

	public static void main (String[] args) throws AdministrateurException, ExceptionEchangeableTagExistant, ExceptionEchangeablePasDeTag, ExceptionEchangeableMauvaisType, ClassNotFoundException, FileNotFoundException, IOException{
		System.out.println("Parce que c'est plus rapide qu'un pigeon voyageur.");
		//_Echangeable e = $Echangeable.charger("echangeables/1461922248620vivaldic'estdelamerde");
		//System.out.println((($EchangeableAvecTag)e).voirTags());
		
		Utilisateur u = (Utilisateur)(new ObjectInputStream(new FileInputStream(new File("sauv/utilisateurs/max"))).readObject());
		System.out.println(u.toStringDroits());
		
		_Echangeable i = $Echangeable.charger("echangeables/1462283738778abcd");
		System.out.println((($EchangeableAvecTag)i).voirTags());
	}
}
