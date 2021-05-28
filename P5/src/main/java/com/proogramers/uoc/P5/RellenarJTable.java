package com.proogramers.uoc.P5;

import static datosMysql.Conexion.getConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

import datosMysql.Conexion;

public class RellenarJTable {
	
	private static final String SELECT_PROYECTOS ="SELECT * FROM proyectos";

	public DefaultTableModel consultarBDProyectos() {
		
		String[] cabecera= {"Id","Pais","Localización","L.Acción","S.L.Acción","F.Inicio","F.Final","Socio","Financiador","Financiación","Acciones","Personal","Voluntarios","CIF Ong"};
		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
		String[] registros = new String[14];
		
		Connection conn = null;					
		PreparedStatement pstat = null;			
		ResultSet rs = null;
		
		try {
			conn = Conexion.getConection();
			pstat = conn.prepareStatement(SELECT_PROYECTOS);			//creamos un prepareStatment y le pasamos la constante SQL_SELECT
			rs = pstat.executeQuery();							// ejecutamos el prepareStatment y lo guardamos en resulset
			while(rs.next()) {
				registros[0] = String.valueOf(rs.getInt("Id_proyecto"));
				registros[1] = rs.getString("Pais");
				registros[2] = rs.getNString("Localizacion");
				registros[3] = rs.getString("LineaDeAccion");
				registros[4] = rs.getString("SublineaDeAccion");
				registros[5] = rs.getString("FechaInicio");											//LocalDate.parse(rs.getString("FechaInicio"));
				registros[6] = rs.getString("FechaFinal");
				registros[7] = rs.getString("SocioLocal");
				registros[8] = rs.getString("Financiador");
				registros[9] = String.valueOf(rs.getDouble("Financiacion"));
				registros[10] = rs.getString("Acciones");
				registros[11] = String.valueOf(rs.getInt("Personal"));
				registros[12] = String.valueOf(rs.getInt("VoluntariosAsignados"));
				registros[13] = rs.getString("Ong_CIF");
				modelo.addRow(registros);
						
			}
			return modelo;
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	
}
