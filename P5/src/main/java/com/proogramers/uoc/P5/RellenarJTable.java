package com.proogramers.uoc.P5;

import static datosMysql.Conexion.getConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.DAOFactory;
import datosMysql.Conexion;
import interfazGrafica.Principal;

public class RellenarJTable {

	private static final String SELECT_PROYECTOS = "SELECT * FROM proyectos";

	public DefaultTableModel consultarBDProyectos() {

		String[] cabecera = { "Id", "Pais", "Localización", "L.Acción", "S.L.Acción", "F.Inicio", "F.Final", "Socio",
				"Financiador", "Financiación", "Acciones", "Personal", "Voluntarios", "CIF Ong" };
		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
		String[] registros = new String[14];

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		try {
			conn = Conexion.getConection();
			pstat = conn.prepareStatement(SELECT_PROYECTOS); // creamos un prepareStatment y le pasamos la constante
																// SQL_SELECT
			rs = pstat.executeQuery(); // ejecutamos el prepareStatment y lo guardamos en resulset
			while (rs.next()) {
				registros[0] = String.valueOf(rs.getInt("Id_proyecto"));
				registros[1] = rs.getString("Pais");
				registros[2] = rs.getNString("Localizacion");
				registros[3] = rs.getString("LineaDeAccion");
				registros[4] = rs.getString("SublineaDeAccion");
				registros[5] = rs.getString("FechaInicio"); // LocalDate.parse(rs.getString("FechaInicio"));
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

	DefaultTableModel modelo;

	public void crearJtable() {
		Principal principal = new Principal();
		try {
			modelo = (new DefaultTableModel(null,
					new String[] { "Id", "Pais", "Localización", "L.Acción", "S.L.Acción", "F.Inicio", "F.Final",
							"Socio", "Financiador", "Financiación", "Acciones", "Personal", "Voluntarios",
							"CIF Ong" }) {
				Class[] types = new Class[] { 
						java.lang.Integer.class, 
						java.lang.String.class, 
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.Double.class,
						java.lang.String.class,
						java.lang.Integer.class,
						java.lang.Integer.class,
						java.lang.String.class,};
				boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false };

				@Override
				public Class getColumnClass(int columnIndex) {
					return types[columnIndex];
				}

				@Override
				public boolean isCellEditable(int rowIndex, int colIndex) {
					return canEdit[colIndex];
				}
			});
			principal.getTable().setModel(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString() + "error2");
		}
	}
	public DefaultTableModel rellenarJtable() {
		
		String[] cabecera = { "Id", "Pais", "Localización", "L.Acción", "S.L.Acción", "F.Inicio", "F.Final", "Socio",
				"Financiador", "Financiación", "Acciones", "Personal", "Voluntarios", "CIF Ong" };
		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
		try {
			Object obj[] = null;
			List<Proyectos>listaProyectos;
			listaProyectos= DAOFactory.getDAOFactory(4).jpaProyectosDAO().seleccionar();
			for (int i = 0; i < listaProyectos.size(); i++) {
				modelo.addRow(obj);
				modelo.setValueAt(listaProyectos.get(i).getNumProyecto(), i, 0);
				modelo.setValueAt(listaProyectos.get(i).getPais(), i, 1);
				modelo.setValueAt(listaProyectos.get(i).getLocalizacion(), i, 2);
				modelo.setValueAt(listaProyectos.get(i).getLineaDeAccion(), i, 3);
				modelo.setValueAt(listaProyectos.get(i).getSublineaDeAccion(), i, 4);
				modelo.setValueAt(listaProyectos.get(i).getFechaInicio(), i, 5);
				modelo.setValueAt(listaProyectos.get(i).getFechaFinal(), i, 6);
				modelo.setValueAt(listaProyectos.get(i).getSocioLocal(), i, 7);
				modelo.setValueAt(listaProyectos.get(i).getFinanciador(), i, 8);
				modelo.setValueAt(listaProyectos.get(i).getFinanciacion(), i, 9);
				modelo.setValueAt(listaProyectos.get(i).getAcciones(), i, 10);
				modelo.setValueAt(listaProyectos.get(i).getPersonal(), i, 11);
				modelo.setValueAt(listaProyectos.get(i).getVoluntariosAsignados(), i, 12);
				modelo.setValueAt(listaProyectos.get(i).getOngCif(), i, 13);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modelo;
	}
}
