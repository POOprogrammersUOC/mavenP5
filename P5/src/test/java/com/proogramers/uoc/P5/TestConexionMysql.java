package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import DAO.SQLProyectosDAO;
import datosMysql.*;

public class TestConexionMysql {

	public static void main(String[] args) {
		/*
		Connection conn = null;
		
		try {
			conn = Conexion.getConection();
		System.out.println(conn);
				
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}*/
		
		SQLProyectosDAO sqlProyectosDao = new SQLProyectosDAO();
		
		
		Date sqlDate = new Date(2021, 5, 10);
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = new Date(2022, 5, 10);
		LocalDate fFinal = sqlDate2.toLocalDate();
		Proyectos project = new Proyectos("Belgica","Belgium","nada","nada",fInicio,fFinal,"Pedro","Financer",200.36,"nada",2,6,"B154896325");
		sqlProyectosDao.insertar(project);
		
		List<Proyectos> proyectos = sqlProyectosDao.seleccionar();
		
		for(Proyectos nuevoproject: proyectos) {
			System.out.println("project = " + nuevoproject);
		}
	}

}
