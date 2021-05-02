package DAO;

import static datosMysql.Conexion.close;
import static datosMysql.Conexion.getConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proogramers.uoc.P5.Socios;

public class SQLSociosDAO implements ISociosSQLDAO {

	private static final String SQL_SELECT = "SELECT idSocios, Nombre, Apellido, Direccion, Telefono, Ong_CIF FROM mydb.socios";
	private static final String SQL_INSERT = "INSERT INTO mydb.socios(Nombre, Apellido, Direccion, Telefono, Ong_CIF) VALUES(?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE mydb.socios SET Nombre = ?, Apellido = ?, Direccion = ?, Telefono = ?, Ong_CIF = ? WHERE idSocios = ? ";
	private static final String SQL_DELETE = "DELETE FROM mydb.socios WHERE IdSocios = ?";
	private Connection conexiontransaccion;

	public SQLSociosDAO() {
	}

	public SQLSociosDAO(Connection conexiontransaccion) {
		this.conexiontransaccion = conexiontransaccion;
	}

	@Override
	public List<Socios> seleccionar() throws SQLException {

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		Socios socios = null;
		List<Socios> listaSocios = new ArrayList<>();
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_SELECT);
			rs = pstat.executeQuery();
			while (rs.next()) {
				String Nombre = rs.getString("Nombre");
				String Apellidos = rs.getString("Apellido");
				int nSocio = rs.getInt("idSocios");
				String Direccion = rs.getString("Direccion");
				String Telefono = rs.getString("Telefono");
				String OngCif = rs.getString("Ong_Cif");

				socios = new Socios(nSocio, Nombre, Apellidos, Direccion, Telefono, OngCif);
				listaSocios.add(socios);
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
		return listaSocios;
	}

	// Metodo para insertar en la tabla socios

	@Override
	public int insertar(Socios socios) throws SQLException {

		Connection conn = null;
		PreparedStatement pstat = null;
		int registro = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_INSERT);
			pstat.setString(1, socios.getNombre());
			pstat.setString(2, socios.getApellidos());
			pstat.setString(3, socios.getDireccion());
			pstat.setString(4, socios.getTelefono());
			pstat.setString(5, socios.getOngCif());
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
		return registro;
	}

	// Metodo que actualiza los datos de la tabla socios

	@Override
	public int actualizar(Socios socios) throws SQLException {

		Connection conn = null;
		PreparedStatement pstat = null;
		int registro = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_UPDATE);
			pstat.setInt(1, socios.getNumSocio());
			pstat.setString(2, socios.getNombre());
			pstat.setString(3, socios.getApellidos());
			pstat.setString(4, socios.getDireccion());
			pstat.setString(5, socios.getTelefono());
			pstat.setString(6, socios.getOngCif());

			// }
			registro = pstat.executeUpdate();
			System.out.println(
					"Se ha(n) actualizado " + registro + " registro(s) " + "del Socio numero: " + socios.getNumSocio());

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

	// Metodo que elimina una fila de la tabla socios

	@Override
	public int eliminar(Socios socios) throws SQLException {

		Connection conn = null;
		PreparedStatement pstat = null;
		int registro = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_DELETE);
			pstat.setInt(1, socios.getNumSocio());

			// }
			registro = pstat.executeUpdate();
			System.out.println("Se ha(n) eliminado " + registro + " socio(s) con numero: " + socios.getNumSocio());

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