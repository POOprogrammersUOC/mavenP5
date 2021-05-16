package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import DAO.DAOFactory;
import DAO.SQLProyectosDAO;
import datosMysql.*;

public class TestSQLProyectosDAO {

	static SQLProyectosDAO sqlProyectosDao = new SQLProyectosDAO();

	public static void main(String[] args) throws SQLException {

		// *******************************************************************************************************//
		// TEST DE LAS FUNCIONALIDADES INSERT,SELECT,UPDATE,DELETE,COMMIT & ROLLBACK
		// *******************************************************************************************************//

		//testRollback();
		testSelect();
		testInsert();
		/*
		 * testDatabase(); testSelect();
		 * System.out.println("***************************************");
		 * System.out.println("              INSERTAR");
		 * System.out.println("***************************************"); 
		 
		 * testSelect();
		 * 
		 * System.out.println("***************************************");
		 * System.out.println("              ACTUALIZAR");
		 * System.out.println("***************************************"); testUpdate();
		 * testSelect();
		 * 
		 * System.out.println("***************************************");
		 * System.out.println("              ELIMINAR");
		 * System.out.println("***************************************"); testDelete();
		 * testSelect(); System.out.println("");
		 * System.out.println("***************************************");
		 * System.out.println("              SELECCIONAR");
		 * System.out.println("***************************************"); testSelect();
		 */
		/*
		 * 
		 * 
		 * 
		 * Date sqlDate = Date.valueOf("2021-12-12"); LocalDate fInicio =
		 * sqlDate.toLocalDate(); Date sqlDate2 = Date.valueOf("2022-12-12"); LocalDate
		 * fFinal = sqlDate2.toLocalDate(); //Proyectos project = new
		 * Proyectos("congo3", "conga4", "mod", "mod1", fInicio, fFinal,
		 * "Alberto","ktm", 7000.20, 11, "nada2", 3, 7,"B154896325"); //modificar
		 * 
		 * Proyectos project = new Proyectos(12); //eliminar
		 * sqlProyectosDao.eliminar(project);
		 * 
		 */
	}

	private static void testDatabase() {
		try {
			Connection conn = null;
			if (conn != Conexion.getConection()) {
				System.out.println("*********************************");
				System.out.println("    Conexión establecida!!");
				System.out.println("*********************************");
			}
		} catch (SQLException e) {
			System.out.println("***********************************************");
			System.out.println("  La conexióna a la base de datos ha fallado");
			System.out.println("***********************************************");
		}
	}

	private static void testSelect() throws SQLException {
		// SQLProyectosDAO sqlProyectosDao = new SQLProyectosDAO();
		List<Proyectos> proyectos = DAOFactory.getDAOFactory(2).sqlProyectosDAO().seleccionar(); // sqlProyectosDao.seleccionar();

		for (Proyectos nuevoproject : proyectos) {
			System.out.println(nuevoproject);

		}
	}

	private static void testInsert() throws SQLException {

		Date sqlDate = Date.valueOf("2000-01-01");
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = Date.valueOf("2001-12-12");
		LocalDate fFinal = sqlDate2.toLocalDate();
		Proyectos project = new Proyectos("PEPINO", "Amsterdam", "no hay datos", "no aplica", fInicio, fFinal, "Angel",
				"Secure", 20000.36, "Sin acciones", 10, 60, "B154896325"); // insertar
		// sqlProyectosDao.insertar(project);
		System.out.println(project);
		DAOFactory.getDAOFactory(2).sqlProyectosDAO().insertar(project);
	}

	private static void testUpdate() throws SQLException {
		Date sqlDate = Date.valueOf("2021-12-11");
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = Date.valueOf("2022-12-11");
		LocalDate fFinal = sqlDate2.toLocalDate();
		Proyectos project = new Proyectos("Polonia", "Berlin", "mod", "mod1", fInicio, fFinal, "Alberto", "ktm",
				7000.20, 3, "Incidencias encontradas", 3, 7, "B154896325"); // modificar
		// sqlProyectosDao.actualizar(project);
		DAOFactory.getDAOFactory(2).sqlProyectosDAO().actualizar(project);
	}

	private static void testDelete() throws SQLException {
		Proyectos project = new Proyectos(9); // eliminar
		// sqlProyectosDao.eliminar(project);
		DAOFactory.getDAOFactory(2).sqlProyectosDAO().eliminar(project);
	}

	private static void testRollback() {

		// *******************************************************************************************************************************************************/
		// Para generar el rollback se ha utilizado el campo PAIS que tiene un VARCHAR(45) en la base de datos, de este modo generamos una excepción
		// porque sobrepasamos los caracteres permitidos, de este modo podemos ver que la sifuiente instrucción que es eliminar un registro no lo ha efectuado
		// com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column 'Pais' at row 1
		// *******************************************************************************************************************************************************/

		Connection conexion = null;								// ponemos conexion a null para poder utilizar la variable fuera del try/catch
		try {
			conexion = Conexion.getConection();					//guardos la cadena de conexión en la variable conexion
			if (conexion.getAutoCommit()) {						// si conexion usa autocommit es decir true lo seteamos a false
				conexion.setAutoCommit(false);
			}

			SQLProyectosDAO proyectosTransaccion = new SQLProyectosDAO(conexion);	//creamos un objeto para recibir la conexion

			Date sqlDate = Date.valueOf("2020-01-01");		// guardamos la fecha de string a date
			LocalDate fInicio = sqlDate.toLocalDate();		// convertimos la fecha de sql a localdate
			Date sqlDate2 = Date.valueOf("2021-12-12");
			LocalDate fFinal = sqlDate2.toLocalDate();
			Proyectos projectInsert = new Proyectos(
					"BCN",
					"BCN", "BCN", "BCN", fInicio, fFinal, "Angel", "BCN", 20000.36, "BCN", 10, 60, "B154896325"); // creamos objeto proyectos para insertar en la base de datos
			
			DAOFactory.getDAOFactory(2).sqlProyectosDAO().insertar(projectInsert); //ejecutamos el insert desde FACTORY y DAO

			Proyectos projectDelete = new Proyectos(13);							// creamos un objeto de proyectos
			DAOFactory.getDAOFactory(2).sqlProyectosDAO().eliminar(projectDelete); //ejecutamos el delete desde FACTORY y DAO

			conexion.commit();														// se ejecutan todas las transacciones
			System.out.println("Se ha ejecutado correctamente la transacción");

		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			try {
				conexion.rollback();												// se ejectuta el rollback si alguna de las transacciones no es correcta
				System.out.println("Hay un problema en la transacción y ha sido anulada");
			} catch (SQLException e1) {
				// TODO Bloque catch generado automáticamente
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
