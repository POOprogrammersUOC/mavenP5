package com.proogramers.uoc.P5;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.List;

	import javax.swing.JOptionPane;
	import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.DAOFactory;
	import datosMysql.Conexion;
	import interfazGrafica.Principal;

	public class FillOutJTable {
		
	private static final String SELECT_SOCIOS = "SELECT * FROM socios";

	public DefaultTableModel consultarBDSocios() {

		String[] cabecera = { "IdSocios", "Nombre", "Apellido", "Direccion", "Telefono", "Ong_CIF"};
		DefaultTableModel model = new DefaultTableModel(null, cabecera);
		String[] registros = new String[6];

		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			conn = Conexion.getConection();
			pstat = conn.prepareStatement(SELECT_SOCIOS); // creamos un prepareStatment y le pasamos la constante
																// SQL_SELECT
			rs = pstat.executeQuery(); // ejecutamos el prepareStatment y lo guardamos en resulset
			while (rs.next()) {
				registros[0] = String.valueOf(rs.getInt("idSocios"));
				registros[1] = rs.getString("Nombre");
				registros[2] = rs.getString("Apellido");
				registros[3] = rs.getString("Direccion");
				registros[4] = rs.getString("Telefono");
				registros[5] = rs.getString("Ong_CIF");
				model.addRow(registros);

			}
			return model;
		} catch (Exception e) {
			return null;
		}

	}

	DefaultTableModel model;

	public void crearJtablasocios() {
		Principal principal = new Principal();
		try {
			model = (new DefaultTableModel(null,
					new String[] { "IdSocios", "Nombre", "Apellido", "Direccion", "Telefono", "Ong_CIF"}) {
				Class[] types = new Class[] { 
						java.lang.Integer.class, 
						java.lang.String.class, 
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,
						java.lang.String.class,};
				boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

				@Override
				public Class getColumnClass(int columnIndex) {
					return types[columnIndex];
				}

				@Override
				public boolean isCellEditable(int rowIndex, int colIndex) {
					return canEdit[colIndex];
				}
			});
			principal.getTable().setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString() + "error2");
		}
	}

	public DefaultTableModel fillOutJTable() {
		
		String[] cabecera = { "IdSocios","Nombre","Apellido", "Direccion","Telefono","Ong_CIF"};
		DefaultTableModel model = new DefaultTableModel(null, cabecera);
		try {
			Object obj[] = null;
			List<Socios>listaSocios;
			listaSocios= DAOFactory.getDAOFactory(4).jpaSociosDAO().seleccionar();
			for (int i = 0; i < listaSocios.size(); i++) {
				model.addRow(obj);
				model.setValueAt(listaSocios.get(i).getnSocio(), i, 0);
				model.setValueAt(listaSocios.get(i).getNombre(), i, 1);
				model.setValueAt(listaSocios.get(i).getApellidos(), i, 2);
				model.setValueAt(listaSocios.get(i).getDireccion(), i, 3);
				model.setValueAt(listaSocios.get(i).getTelefono(), i, 4);
				model.setValueAt(listaSocios.get(i).getOngCif(), i, 5);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}



	}
	
	
	
	
	

