package pterodactyle.serveur;

import java.sql.*;
import java.lang.reflect.*;

public class Bdd {
	private Connection c = null;
	private static Statement stmt = null;

	public Bdd(String nomTable) throws ClassNotFoundException, SQLException {
		if (stmt == null) {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nomTable + ".db");
			stmt = c.createStatement();
		}
	}

	public void createTableUser() throws SQLException {
		String sql = "Create table Utilisateurs (";
		Field[] fields = Utilisateur.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			sql += fields[i].getName() + " ";
			switch (fields[i].getType().getName()) {
			case "int":
				if(fields[i].getName() == "id"){sql += " INT PRIMARY KEY NOT NULL ";}
				else{sql += "int";}
				break;
			case "java.lang.String":
				sql += "varchar(255) ";
				break;
			}
			if(i < fields.length-1){sql += " ,";}
		}
		sql += ");";
		stmt.executeUpdate(sql);
	}

}