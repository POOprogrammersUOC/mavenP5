package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.SQLException;

import datosMysql.*;

public class TestConexionMysql {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			conn = Conexion.getConection();
		System.out.println(conn);
				
			
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

}
