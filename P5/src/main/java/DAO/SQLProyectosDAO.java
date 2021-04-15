package DAO;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import static datosMysql.Conexion.*;

import com.proogramers.uoc.P5.Proyectos;

import datosMysql.Conexion;

public class SQLProyectosDAO {

	private static final String SQL_SELECT = "SELECT Id_proyecto, Pais, Localizacion, LineaDeAccion, FechaInicio, FechaFinal, SocioLocal, Financiador, Financiacion, Acciones, Personal, VoluntariosAsignados, Ong_CIF FROM mydb.proyectos";
	private static final String SQL_INSERT = "INSERT INTO mydb.proyectos(Pais, Localizacion, LineaDeAccion, FechaInicio, FechaFinal, SocioLocal, Financiador, Financiacion, Acciones, Personal, VoluntariosAsignados, Ong_CIF) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	

	
	//******************************************************************************
	// Método seleccionar, recoge toda la información de la tabla proyectos mysql
	//******************************************************************************
	
	public List<Proyectos> seleccionar(){
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		Proyectos proyectos = null;
		List<Proyectos> listaProyectos = new ArrayList<>();
		try {
			conn = getConection();
			pstat = conn.prepareStatement(SQL_SELECT);
			rs = pstat.executeQuery();
			while (rs.next()) {
				int numProyecto 		= rs.getInt("Id_proyecto");
				String pais 			= rs.getString("Pais");
				String localizacion 	= rs.getString("Localizacion");
				String lineaDeAccion 	= rs.getString("LineaDeAccion");
				LocalDate fechaInicio = null;									//********************REVISAR*********************\\
				if(rs.getString("FechaInicio") != null) {
					fechaInicio = LocalDate.parse(rs.getString("FechaInicio"));
				}
				LocalDate fechaFinal = null;
				if(rs.getString("FechaFinal") != null) {
					fechaFinal = LocalDate.parse(rs.getString("FechaFinal"));	//********************REVISAR*********************\\
				}
				String socioLocal		= rs.getString("SocioLocal");
				String financiador		= rs.getString("Financiador");
				Double financiacion		= rs.getDouble("Financiacion");
				String acciones			= rs.getString("Acciones");
				int personal			= rs.getInt("Personal");
				int voluntariosAsignados= rs.getInt("VoluntariosAsignados");
				//String ongCif			= rs.getString("Ong_CIF");
				
				proyectos = new Proyectos(pais, localizacion, lineaDeAccion, lineaDeAccion, fechaInicio, fechaFinal, socioLocal, financiador, financiacion, numProyecto, acciones, personal, voluntariosAsignados);
				
				listaProyectos.add(proyectos);
			}
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			System.out.println("La conexión no es correcta revisa el log" + e);
		}
		finally {
			
			try {
				close(rs);
				close(pstat);
				close(conn);
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace(System.out);
			}
			
			
		}
		return listaProyectos;
	}
	
	//******************************************************************************
	// Método Insertar, inserta la información indicada a la base de datos
	//******************************************************************************
	
	public int insertar(Proyectos proyectos) {
		Connection conn = null;
		PreparedStatement pstat = null;
		int registros = 0;
		try {
			conn = getConection();
			pstat = conn.prepareStatement(SQL_INSERT);
			pstat.setString(1, proyectos.getPais());
			pstat.setString(2, proyectos.getLocalizacion());
			pstat.setString(3, proyectos.getLineaDeAccion());
			pstat.setString(4, proyectos.getSublineaDeAccion());
			//LocalDate fechaInicio = null;
			//if (proyectos.getFechaInicio() != null) {						//*********REVISAR*********\\
			pstat.setObject(5,proyectos.getFechaInicio());
			pstat.setObject(6,proyectos.getFechaFinal());
			pstat.setString(6, proyectos.getSocioLocal());
			pstat.setString(7, proyectos.getFinanciador());
			pstat.setDouble(8, proyectos.getFinanciacion());
			pstat.setString(9, proyectos.getAcciones());
			pstat.setInt(10, proyectos.getPersonal());
			pstat.setInt(11, proyectos.getVoluntariosAsignados());
			//pstat.setString(12, proyectos.getOngCif)); falta incluirla en la clase proyectos
			//}
			registros = pstat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}finally {
			try {
				close(pstat);
				close(conn);
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
		return registros;
	}
}
