package pterodactyle.coeur;

/**
 * LispException est une classe d'exception crée pour le langage Lisp
 * elle hérite de la classe RuntimeException
 */
public class AdministrateurExecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7563423113881964089L;

	public AdministrateurExecption() {
		// TODO Auto-generated constructor stub
	}

	public AdministrateurExecption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AdministrateurExecption(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AdministrateurExecption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AdministrateurExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}