package DAOMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	protected Connection conexion;
	

	private final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	
	// DB credenciales
	
	private final String USER = "root";
	private final String PASS = "admin";
	
	public void conectar() throws Exception {
		try {
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	public void cerrar() throws SQLException {
		if(conexion != null) {
			if(conexion.isClosed()) {
				conexion.close();
			}
		}
	}
	
	