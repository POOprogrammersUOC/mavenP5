package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.SQLEmpleadosDAO;
import datosMysql.Conexion;
import DAO.DAOFactory;

public class TestSQLEmpleadosDAO {
	
	static SQLEmpleadosDAO sqlEmpleadosDao = new SQLEmpleadosDAO();

	public static void main(String[] args) throws SQLException {

		// *******************************************************************************************************//
		// TEST DE LAS FUNCIONALIDADES INSERT,SELECT,UPDATE,DELETE,COMMIT & ROLLBACK
		// *******************************************************************************************************//
		testRollback();
		testSelect();
		
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
		// SQLEmpleadosDAO sqlProyectosDao = new SQLProyectosDAO();
		List<Empleados> empleados = DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().seleccionar(); // sqlProyectosDao.seleccionar();

		for (Empleados nuevoempleado : empleados) {
			System.out.println(nuevoempleado);

		}
	}
	
	private static void testInsert() throws SQLException {
		
		Empleados empleado = new Empleados("David", "Luna", "Av Alicante", "65468464", "54896325", "12345b"); // Update Modificar
		// 
		DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().insertar(empleado);
	}
	


	private static void testUpdate() throws SQLException {
	
	Empleados empleado = new Empleados("Jaime", "hdhdhd", "kjjkhjk", "65465464", "5665465468", "12345b"); // modificar
	DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().actualizar(empleado);
	}
	
	private static void testDelete() throws SQLException {
		Empleados empleado = new Empleados(9); // eliminar
		DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().eliminar(empleado);
	}
	
	
	private static void testRollback() {

		Connection conexion = null;								// ponemos conexion a null para poder utilizar la variable fuera del try/catch
		try {
			conexion = Conexion.getConection();					//guardos la cadena de conexión en la variable conexion
			if (conexion.getAutoCommit()) {						// si conexion usa autocommit es decir true lo seteamos a false
				conexion.setAutoCommit(false);
			}

			SQLEmpleadosDAO empleadosTransaccion = new SQLEmpleadosDAO(conexion);	//creamos un objeto para recibir la conexion

			Empleados empleadoInsert = new Empleados(
					"Enrique", "uoiudjsa", "jdsjsdjds", "6546546", "1231232", "12345b"); // creamos objeto proyectos para insertar en la base de datos
			
			DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().insertar(empleadoInsert); //ejecutamos el insert desde FACTORY y DAO

			Empleados empleadoDelete = new Empleados();							// creamos un objeto de proyectos
			DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().eliminar(empleadoDelete); //ejecutamos el delete desde FACTORY y DAO

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

	
	