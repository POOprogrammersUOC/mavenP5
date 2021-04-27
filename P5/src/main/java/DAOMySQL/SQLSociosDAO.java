package DAOMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.proogramers.uoc.P5.Socios;

public class SQLSociosDAO extends Conexion implements ISociosDAOSQL {

	@Override
	public int insertar(Socios socios) throws SQLException {
		int datos = 0;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Socios (Nombre, Apellido, Direccion, Telefono, Ong_CIF)  VALUES(?,?,?,?,?)");
			st.setString(1, socios.getNombre());
			st.setString(2, socios.getApellidos());
			st.setString(3,  socios.getDireccion());
			st.setString(4, socios.getTelefono());
			st.setString(5, socios.getOngCif());
			st.executeUpdate();
		} catch(SQLException e) {
		} finally {
			this.cerrar();
		}
		return datos;
	}

	

	@Override
	public int modificar(Socios socios) throws SQLException {
		int datos = 0;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("UPDATE mydb.socios SET Nombre = ?, Apellido = ?, Direccion = ?, Telefono = ?, Ong_CIF = ? WHERE IdSocios = ? ");
			st.setString(1, socios.getNombre());
			st.setString(2, socios.getApellidos());
			st.setString(3,  socios.getDireccion());
			st.setString(4, socios.getTelefono());
			st.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
		return datos;
	}
	
	
	public int eliminar(Socios socios) throws SQLException {
		int datos = 0;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("DELETE FROM mydb.socios WHERE IdSocios = ?");
			st.setString(1, socios.getNombre());
			st.setString(2, socios.getApellidos());
			st.setString(3,  socios.getDireccion());
			st.setString(4, socios.getTelefono());
			st.executeUpdate();
		} catch(SQLException e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
		return datos;
	}
	
	
	
	
	
	
	@Override
	public List<Socios> seleccionar() throws SQLException {
		
		try {
			
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Socios");
			
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Socios socios = new Socios();
				socios.setnSocio(rs.getInt("idSocios"));
				socios.setNombre(rs.getString("Nombre"));
				socios.setApellidos(rs.getString("Apellido"));
				socios.setDireccion(rs.getString("Direccion"));
				socios.setTelefono(rs.getString("Telefono"));
				String ong_Cif = rs.getString("Ong_Cif");
			}	
			rs.close();
			st.close();
				
		} catch(SQLException e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
	
		
		return null;
	}







	

}