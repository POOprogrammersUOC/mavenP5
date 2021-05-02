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
		testUpdate();
		//testRollback();
		//testSelect();
		
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
		
		List<Empleados> empleados = DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().seleccionar(); 

		for (Empleados nuevoempleado : empleados) {
			System.out.println(nuevoempleado);

		}
	}
	
	private static void testInsert() throws SQLException {
		
		Empleados empleado = new Empleados("Maria", "Lopez", "Av Alicante", "65468464", "54896325", "12345b"); // Update Modificar
		 
		DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().insertar(empleado);
	}
	


	private static void testUpdate() throws SQLException {
	
	Empleados empleado = new Empleados("Sara", "JGJGhdhdhd", "kjjkhjk", "65465464", "5665465", "12345b", 8); // modificar
	DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().actualizar(empleado);
	}
	
	private static void testDelete() throws SQLException {
		Empleados empleado = new Empleados(10); // eliminar
		DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().eliminar(empleado);
	}
	
	
	private static void testRollback() {

		Connection conexion = null;								
		try {
			conexion = Conexion.getConection();					
			if (conexion.getAutoCommit()) {						
				conexion.setAutoCommit(false);
			}

			SQLEmpleadosDAO empleadosTransaccion = new SQLEmpleadosDAO(conexion);	

			Empleados empleadoInsert = new Empleados(
					"Enrique", "uoiudjsa", "jdsjsdjds", "6546546", "1231232", "12345b"); 
			
			DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().insertar(empleadoInsert); //insert desde FACTORY y DAO

			Empleados empleadoDelete = new Empleados(9);							// creamos un objeto 
			DAOFactory.getDAOFactory(2).sqlEmpleadosDAO().eliminar(empleadoDelete); //delete desde FACTORY y DAO

			conexion.commit();														
			System.out.println("Se ha ejecutado correctamente la transacción");

		} catch (SQLException e) {
			
			try {
				conexion.rollback();												// si alguna de las transacciones no es correcta
				System.out.println("Hay un problema en la transacción y ha sido anulada");
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}

	
	