package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	private String driver = "org.postgresql.Driver";
	private String user = "postgres";
	private String senha = "senha";
	private String url = "jdbc:postgresql://localhost:5432/petshop";

	public Connection getConection() {
		try {
			Class.forName(driver);
			Connection con = null;
			con = (Connection) DriverManager.getConnection(url, user, senha);
			return con;

		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return null;

	}
}
