package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgres {
	
	private static ConexaoPostgres instance;
	private String url = "jdbc:postgresql://localhost/postgres";
	
	private ConexaoPostgres() {}
	
	public static ConexaoPostgres getInstance() throws SQLException{
		if(instance == null)
			instance = new ConexaoPostgres();
		return instance;
	}
	
	public Connection getConn() throws SQLException{
		Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
		return conn;
	}

}
