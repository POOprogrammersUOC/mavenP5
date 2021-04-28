package DAO;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import static datosMysql.Conexion.*;

import com.proogramers.uoc.P5.Proyectos;

import datosMysql.Conexion;

public class SQLProyectosDAO implements IProyectosSQLDAO {

	private static final String SQL_SELECT = "SELECT Id_proyecto, Pais, Localizacion, LineaDeAccion, SublineaDeAccion, FechaInicio, FechaFinal, SocioLocal, Financiador, Financiacion, Acciones, Personal, VoluntariosAsignados, Ong_CIF FROM mydb.proyectos";
	private static final String SQL_INSERT = "INSERT INTO mydb.proyectos(Pais, Localizacion, LineaDeAccion, SublineaDeAccion, FechaInicio, FechaFinal, SocioLocal, Financiador, Financiacion, Acciones, Personal, VoluntariosAsignados, Ong_CIF) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	private static final String SQL_UPDATE = "UPDATE mydb.proyectos SET Pais = ?, Localizacion = ?, LineaDeAccion = ?, SublineaDeAccion = ?, FechaInicio = ?, FechaFinal = ?, SocioLocal = ?, Financiador = ?, Financiacion = ?, Acciones = ?, Personal = ?, VoluntariosAsignados = ?, Ong_CIF = ? WHERE Id_proyecto = ? ";
	private static final String SQL_DELETE = "DELETE FROM mydb.proyectos WHERE Id_proyecto = ?";
	private Connection conexiontransaccion;

	public SQLProyectosDAO() {
	}

	public SQLProyectosDAO(Connection conexiontransaccion) {		//pasamos objeto de conexion para saber si se hace el autocommit o no
		this.conexiontransaccion = conexiontransaccion;
	}

	// ******************************************************************************
	// Método seleccionar, recoge toda la información de la tabla proyectos mysql
	// ******************************************************************************

	@Override
	public List<Proyectos> seleccionar() throws SQLException {

		Connection conn = null;					
		PreparedStatement pstat = null;			
		ResultSet rs = null;
		Proyectos proyectos = null;
		List<Proyectos> listaProyectos = new ArrayList<>();
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();  //usamos una operacion ternaria para saber el tipo de conexion que tenemos
			pstat = conn.prepareStatement(SQL_SELECT);			//creamos un prepareStatment y le pasamos la constante SQL_SELECT
			rs = pstat.executeQuery();							// ejecutamos el prepareStatment y lo guardamos en resulset
			while (rs.next()) {									// mientras resulset tenga datos es true
				int numProyecto = rs.getInt("Id_proyecto");		// con resulset recogemos de la base de datos la columna Id_proyecto que se le asignara a la variable de la clase proyecto
				String pais = rs.getString("Pais");
				String localizacion = rs.getString("Localizacion");
				String lineaDeAccion = rs.getString("LineaDeAccion");
				String sublineaDeAcion = rs.getString("SublineaDeAccion");
				LocalDate fechaInicio = null; 										//ponemos la fecha a null
				if (rs.getString("FechaInicio") != null) {							// si resulset no es igual anull
					fechaInicio = LocalDate.parse(rs.getString("FechaInicio"));		// recoge la columna fechaInicio de la base de datos y la parseamos en una variable de LocalDate de la clase proyecto
				}
				LocalDate fechaFinal = null;
				if (rs.getString("FechaFinal") != null) {
					fechaFinal = LocalDate.parse(rs.getString("FechaFinal")); 
				}
				String socioLocal = rs.getString("SocioLocal");
				String financiador = rs.getString("Financiador");
				Double financiacion = rs.getDouble("Financiacion");
				String acciones = rs.getString("Acciones");
				int personal = rs.getInt("Personal");
				int voluntariosAsignados = rs.getInt("VoluntariosAsignados");
				String ongCif = rs.getString("Ong_CIF");

				proyectos = new Proyectos(pais, localizacion, lineaDeAccion, sublineaDeAcion, fechaInicio, fechaFinal,		// creamos el constructor y lo añadimos a la lista
						socioLocal, financiador, financiacion, numProyecto, acciones, personal, voluntariosAsignados,
						ongCif);

				listaProyectos.add(proyectos);

			}

		} finally {

			try {
				close(rs);		//cerramos conexion ResulSet
				close(pstat);	//cerramos el preparedStatment
				if (this.conexiontransaccion == null) {		// si la conexión que le pasamos es igual null cerramos la base de datos
					close(conn);
				}

			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace(System.out);
			}

		}
		return listaProyectos; //retornamos listaproyectos
	}

	// ******************************************************************************
	// Método Insertar, inserta la información indicada a la base de datos
	// ******************************************************************************

	@Override
	public int insertar(Proyectos proyectos) throws SQLException {
		Connection conn = null;
		PreparedStatement pstat = null;
		int registros = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_INSERT);
			pstat.setString(1, proyectos.getPais());
			pstat.setString(2, proyectos.getLocalizacion());
			pstat.setString(3, proyectos.getLineaDeAccion());
			pstat.setString(4, proyectos.getSublineaDeAccion());
			pstat.setObject(5, proyectos.getFechaInicio());			//pasamos las fechas como objetos
			pstat.setObject(6, proyectos.getFechaFinal());			//pasamos las fechas como objetos
			pstat.setString(7, proyectos.getSocioLocal());
			pstat.setString(8, proyectos.getFinanciador());
			pstat.setDouble(9, proyectos.getFinanciacion());
			pstat.setString(10, proyectos.getAcciones());
			pstat.setInt(11, proyectos.getPersonal());
			pstat.setInt(12, proyectos.getVoluntariosAsignados());
			pstat.setString(13, proyectos.getOngCif());

			// }
			registros = pstat.executeUpdate();
			System.out.println("Se ha(n) insertado(s) " + registros + " registro(s) correctamente"); // printamos los registros que se han efectuado

		} finally {
			try {
				close(pstat);
				if (this.conexiontransaccion == null) {
					close(conn);
				}
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace(System.out);
			}
		}
		return registros;
	}

	// ******************************************************************************
	// Método Update, Actualiza la información indicada a la base de datos
	// ******************************************************************************

	@Override
	public int actualizar(Proyectos proyectos) throws SQLException {
		Connection conn = null;
		PreparedStatement pstat = null;
		int registros = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_UPDATE);
			pstat.setString(1, proyectos.getPais());
			pstat.setString(2, proyectos.getLocalizacion());
			pstat.setString(3, proyectos.getLineaDeAccion());
			pstat.setString(4, proyectos.getSublineaDeAccion());
			pstat.setObject(5, proyectos.getFechaInicio());
			pstat.setObject(6, proyectos.getFechaFinal());
			pstat.setString(7, proyectos.getSocioLocal());
			pstat.setString(8, proyectos.getFinanciador());
			pstat.setDouble(9, proyectos.getFinanciacion());
			pstat.setString(10, proyectos.getAcciones());
			pstat.setInt(11, proyectos.getPersonal());
			pstat.setInt(12, proyectos.getVoluntariosAsignados());
			pstat.setString(13, proyectos.getOngCif());
			pstat.setInt(14, proyectos.getNumProyecto());

			// }
			registros = pstat.executeUpdate();
			System.out.println(
					"Se ha(n) actualizado " + registros + " registro(s) " + "del ID: " + proyectos.getNumProyecto());

		} finally {
			try {
				close(pstat);
				if (this.conexiontransaccion == null) {
					close(conn);
				}
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace(System.out);
			}
		}

		return registros;
	}

	// ******************************************************************************
	// Método Eliminar, eliminar la información indicada a la base de datos mediante
	// ID
	// ******************************************************************************

	@Override
	public int eliminar(Proyectos proyectos) throws SQLException {
		Connection conn = null;
		PreparedStatement pstat = null;
		int registros = 0;
		try {
			conn = this.conexiontransaccion != null ? this.conexiontransaccion : getConection();
			pstat = conn.prepareStatement(SQL_DELETE);
			pstat.setInt(1, proyectos.getNumProyecto());

			// }
			registros = pstat.executeUpdate();
			System.out.println("Se ha(n) eliminado " + registros + " registro(s) con ID: " + proyectos.getNumProyecto());

		} finally {
			try {
				close(pstat);
				if (this.conexiontransaccion == null) {
					close(conn);
				}
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace(System.out);
			}
		}
		return registros;
	}

}
