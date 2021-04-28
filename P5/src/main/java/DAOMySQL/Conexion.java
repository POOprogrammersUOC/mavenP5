package DAOMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {


	private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	
	// DB credenciales
	
	private static final String USER = "root";
	private static final String PASS = "admin";
	
	public static Connection getConnection() throws SQLException {
		
			return DriverManager.getConnection(DB_URL, USER, PASS);
			
		
		
	}
	
	public static void close(ResultSet rs) throws SQLException {
		
	rs.close();
		
	}

	public static void close(PreparedStatement st) throws SQLException {
		
		st.close();
	}

	public static void close(Connection conn) throws SQLException {
		
		conn.close();
	}



}
	
	
	
	