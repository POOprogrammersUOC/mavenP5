package datosMysql;

import java.sql.*;

public class Conexion {

	private static final String URL_JDBC ="jdbc:mysql://localhost:3306/mydb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER_JDBC ="root";
	private static final String PASSWORD_JDBC ="admin";
	
	public static Connection getConection() throws SQLException {				//creamos el metodo getconection() para que nos devuelva el driverManager montado con  su cadena use y passw
		
		return DriverManager.getConnection(URL_JDBC, USER_JDBC, PASSWORD_JDBC);
	}
	
	//*********************************************************/
	// Sobrecargamos el metodo close
	//*********************************************************/
	
	
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void close(PreparedStatement pstat) throws SQLException {
		pstat.close();
	}
	
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
}
