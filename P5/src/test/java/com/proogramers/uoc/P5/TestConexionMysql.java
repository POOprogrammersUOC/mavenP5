package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.SQLException;
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
		List<Proyectos> proyectos = sqlProyectosDao.seleccionar();
		
		for(Proyectos project: proyectos) {
			System.out.println("project = " + project);
		}
		
	}

}
