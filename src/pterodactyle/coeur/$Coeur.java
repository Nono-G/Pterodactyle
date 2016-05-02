package pterodactyle.coeur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class $Coeur extends UnicastRemoteObject implements _ServicesCoeur {

	private static final long serialVersionUID = -4144701292144837298L;
	protected _VerifIdentite verifIdentite;
	protected _VerifAutorisation verifAutorisation;
	
	protected $Coeur() throws RemoteException{
		super();
		this.verifIdentite = new VerifIdentiteLogMdp();
		this.verifAutorisation = new VerifAutorisation();
	}

}
