package pterodactyle.test;

import java.rmi.RemoteException;
import java.util.Set;

import pterodactyle.coeur.*;
import pterodactyle.echangeable.*;
import pterodactyle.utilisateur.AdministrateurException;

public class Test1 {

	public static void main (String[] args) throws RemoteException, AdministrateurException, ExceptionEchangeableTagExistant, ExceptionEchangeablePasDeTag, ExceptionEchangeableMauvaisType{
		System.out.println("Parce que c'est plus rapide qu'un pigeon voyageur.");
		_Echangeable e = $Echangeable.charger("echangeables/1461922248620vivaldic'estdelamerde");
		System.out.println((($EchangeableAvecTag)e).voirTags());
		

	}
}
