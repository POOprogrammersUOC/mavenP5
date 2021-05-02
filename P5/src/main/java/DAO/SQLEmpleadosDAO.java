package DAO;

import static datosMysql.Conexion.close;
import static datosMysql.Conexion.getConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proogramers.uoc.P5.Empleados;

public class SQLEmpleadosDAO implements IEmpleadosSQLDAO{
	
	private static final String SQL_SELECT = "SELECT Numero, Nombre, Apellido_1, Direccion, Telefono, Dni, Ong_CIF FROM mydb.empleados";
	private static final String SQL_INSERT = "INSERT INTO mydb.empleados(Nombre, Apellido_1, Direccion, Telefono, Dni, Ong_CIF) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE mydb.empleados SET Nombre = ?, Apellido_1 = ?, Direccion = ?, Telefono = ?, Dni = ?, Ong_CIF = ? WHERE Numero = ? ";
	private static final String SQL_DELETE = "DELETE FROM mydb.empleados WHERE Numero = ?";
	private Connection conexiontransaccion;
	
	public SQLEmpleadosDAO() {
	}

	public SQLEmpleadosDAO(Connection conexiontransaccion) {
		this.conexiontransaccion = conexiontransaccion;
	}

	@Override
	public List<Empleados> seleccionar() throws SQLException {
		
		Connection conn = null;					
		PreparedStatement pstat = null;			
		ResultSet rs = null;
		Empleados empleados = null;
		List<Empleados> listaEmpleados = new ArrayList<>();
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();  
			pstat = conn.prepareStatement(SQL_SELECT);			
			rs = pstat.executeQuery();							
			while (rs.next()) {									
				int Numero = rs.getInt("Numero");		
				String Nombre = rs.getString("Nombre");
				String Apellido_1 = rs.getString("Apellido_1");
				String Direccion = rs.getString("Direccion");
				String Telefono = rs.getString("Telefono");
				String Dni = rs.getString("Dni");
				String OngCif = rs.getString("Ong_Cif");
				empleados = new Empleados(Numero, Nombre, Apellido_1, Direccion, Telefono, Dni, OngCif);
				listaEmpleados.add(empleados);
			}

		} finally {

			try {
				close(rs);		
				close(pstat);	
				if (this.conexiontransaccion == null) {		
					close(conn);
				}

			} catch (SQLException e) {
				
				e.printStackTrace(System.out);
			}

		}
		return listaEmpleados;
	}

	//Metodo para insertar en la tabla empleados
	
	@Override
	public int insertar(Empleados empleados) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		int registro = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_INSERT);
			pstat.setString(1, empleados.getNombre());
			pstat.setString(2, empleados.getApellidos());
			pstat.setString(3, empleados.getDireccion());
			pstat.setString(4, empleados.getTelefono());
			pstat.setString(5, empleados.getDNI());	
			pstat.setString(6, empleados.getOngCif());			
			registro = pstat.executeUpdate();
			System.out.println("Se ha(n) insertado(s) " + registro + " registro(s) correctamente");

		} finally {
			try {
				close(pstat);
				if (this.conexiontransaccion == null) {
					close(conn);
				}
			} catch (SQLException e) {
					e.printStackTrace(System.out);
			}
		}
		return registro ;
	}

	
	//Metodo que actualiza los datos de la tabla empleados
	
	@Override
	public int actualizar(Empleados empleados) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		int registro = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_UPDATE);
			pstat.setString(1, empleados.getNombre());
			pstat.setString(2, empleados.getApellidos());
			pstat.setString(3, empleados.getDireccion());
			pstat.setString(4, empleados.getTelefono());
			pstat.setString(5, empleados.getDNI());
			pstat.setString(6, empleados.getOngCif());
			pstat.setInt(7, empleados.getNumero());

			registro = pstat.executeUpdate();
			System.out.println(
					"Se ha(n) actualizado " + registro + " registro(s) " + "del Empleado numero: " + empleados.getNumero());

		} finally {
			try {
				close(pstat);
				if (this.conexiontransaccion == null) {
					close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}

		return registro;
	}

	//Metodo que elimina una fila de la tabla empleados
	
	@Override
	public int eliminar(Empleados empleados) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		int registro = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_DELETE);
			pstat.setInt(1, empleados.getNumero());

			// }
			registro = pstat.executeUpdate();
			System.out.println("Se ha(n) eliminado " + registro + " empleado(s) con numero: " + empleados.getNumero());

		} finally {
			try {
				close(pstat);
				if (this.conexiontransaccion == null) {
					close(conn);
				}
			} catch (SQLException e) {
				
				e.printStackTrace(System.out);
			}
		}
		return registro;
	}

}
