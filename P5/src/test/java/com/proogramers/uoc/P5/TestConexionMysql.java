package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import DAO.DAOFactory;
import DAO.SQLProyectosDAO;
import datosMysql.*;

public class TestConexionMysql {

	static SQLProyectosDAO sqlProyectosDao = new SQLProyectosDAO();

	public static void main(String[] args) {

		// *******************************************************************************************************//
		// TEST DE LAS FUNCIONALIDADES INSERT,SELECT,UPDATE,DELETE
		// *******************************************************************************************************//

		
		testDatabase();
		testSelect();
		System.out.println("***************************************");
		System.out.println("              INSERTAR");
		System.out.println("***************************************");
		testInsert();
		testSelect();
		
		System.out.println("***************************************");
		System.out.println("              ACTUALIZAR");
		System.out.println("***************************************");
		testUpdate();
		testSelect();
		
		System.out.println("***************************************");
		System.out.println("              ELIMINAR");
		System.out.println("***************************************");
		testDelete();
		testSelect();
		System.out.println("");
		System.out.println("***************************************");
		System.out.println("              SELECCIONAR");
		System.out.println("***************************************");
		testSelect();
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

	private static void testSelect() {
		// SQLProyectosDAO sqlProyectosDao = new SQLProyectosDAO();
		List<Proyectos> proyectos =  DAOFactory.getDAOFactory(2).sqlProyectosDAO().seleccionar();  //sqlProyectosDao.seleccionar();

		for (Proyectos nuevoproject : proyectos) {
			System.out.println(nuevoproject);

		}
	}

	private static void testInsert() {

		Date sqlDate = Date.valueOf("2000-01-01");
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = Date.valueOf("2001-12-12");
		LocalDate fFinal = sqlDate2.toLocalDate();
		Proyectos project = new Proyectos("PEPINO", "Amsterdam", "no hay datos", "no aplica", fInicio, fFinal, "Angel",
				"Secure", 20000.36, "Sin acciones", 10, 60, "B154896325"); // insertar
		//sqlProyectosDao.insertar(project);
		DAOFactory.getDAOFactory(2).sqlProyectosDAO().insertar(project);
	}

	private static void testUpdate() {
		Date sqlDate = Date.valueOf("2021-12-11");
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = Date.valueOf("2022-12-11");
		LocalDate fFinal = sqlDate2.toLocalDate();
		Proyectos project = new Proyectos("Polonia", "Berlin", "mod", "mod1", fInicio, fFinal, "Alberto", "ktm",
				7000.20, 3, "Incidencias encontradas", 3, 7, "B154896325"); // modificar
		//sqlProyectosDao.actualizar(project);
		DAOFactory.getDAOFactory(2).sqlProyectosDAO().actualizar(project);
	}

	private static void testDelete() {
		Proyectos project = new Proyectos(9); // eliminar
		//sqlProyectosDao.eliminar(project);
		DAOFactory.getDAOFactory(2).sqlProyectosDAO().eliminar(project);
	}
}
