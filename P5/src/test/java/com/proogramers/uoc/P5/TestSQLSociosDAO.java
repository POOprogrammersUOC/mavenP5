package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.SQLSociosDAO;
import datosMysql.Conexion;
import DAO.DAOFactory;

public class TestSQLSociosDAO {

	static SQLSociosDAO sqlSociosDao = new SQLSociosDAO();

	public static void main(String[] args) throws SQLException {

		// *******************************************************************************************************//
		// TEST DE LAS FUNCIONALIDADES INSERT,SELECT,UPDATE,DELETE,COMMIT & ROLLBACK
		// *******************************************************************************************************//
		// testRollback();
		testInsert();
		testSelect();
		// testDelete();
		// testUpdate();

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
			System.out.println("  La conexión a a la base de datos ha fallado");
			System.out.println("***********************************************");
		}
	}

	private static void testSelect() throws SQLException {

		List<Socios> socios = DAOFactory.getDAOFactory(2).sqlSociosDAO().seleccionar();

		for (Socios nuevosocio : socios) {
			System.out.println(nuevosocio);

		}
	}

	private static void testInsert() throws SQLException {

		Socios socio = new Socios("Jose", "Martin", "Valencia", "fsdd", "12345b"); // insertar
		//
		System.out.println(socio);
		DAOFactory.getDAOFactory(2).sqlSociosDAO().insertar(socio);

	}

	private static void testUpdate() throws SQLException {

		Socios socio = new Socios(1, "Javier", "Gomez", "Girona", "6346343", "12345b"); // modificar
		DAOFactory.getDAOFactory(2).sqlSociosDAO().actualizar(socio);
	}

	private static void testDelete() throws SQLException {
		Socios socio = new Socios(5); // eliminar
		DAOFactory.getDAOFactory(2).sqlSociosDAO().eliminar(socio);
	}

	private static void testRollback() {

		Connection conexion = null;
		try {
			conexion = Conexion.getConection();
			if (conexion.getAutoCommit()) {
				conexion.setAutoCommit(false);
			}

			SQLSociosDAO sociosTransaccion = new SQLSociosDAO(conexion);

			Socios sociosInsert = new Socios("Enrique", "uoiudjsa", "jdsjsdjds", "6546546", "12345b");

			DAOFactory.getDAOFactory(2).sqlSociosDAO().insertar(sociosInsert); // insert desde FACTORY y DAO

			Socios sociosDelete = new Socios(); // creamos un objeto
			DAOFactory.getDAOFactory(2).sqlSociosDAO().eliminar(sociosDelete); // delete desde FACTORY y DAO

			conexion.commit();
			System.out.println("Se ha ejecutado correctamente la transacción");

		} catch (SQLException e) {

			try {
				conexion.rollback(); // si alguna de las transacciones no es correcta
				System.out.println("Hay un problema en la transacción y ha sido anulada");
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}
