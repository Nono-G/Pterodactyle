package pterodactyle.serveur;

import java.sql.SQLException;
import java.text.Format.Field;

public class testMax {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Bdd bd = new Bdd("Pterodactyle");
		bd.createTableUser();		
	}
}
