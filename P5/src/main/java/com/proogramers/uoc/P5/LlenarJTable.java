package com.proogramers.uoc.P5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.DAOFactory;
import datosMysql.Conexion;
import interfazGrafica.Principal;

public class LlenarJTable {
	
private static final String SELECT_EMPLEADOS = "SELECT * FROM empleados";

public DefaultTableModel consultarBDEmpleados() {

	String[] cabecera = { "Id Empleado", "Nombre", "Apellido_1", "Direccion", "Telefono", "Dni", "Ong_CIF"};
	DefaultTableModel model = new DefaultTableModel(null, cabecera);
	String[] registros = new String[7];

	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	try {
		conn = Conexion.getConection();
		pstat = conn.prepareStatement(SELECT_EMPLEADOS); // creamos un prepareStatment y le pasamos la constante
															// SQL_SELECT
		rs = pstat.executeQuery(); // ejecutamos el prepareStatment y lo guardamos en resulset
		while (rs.next()) {
			registros[0] = String.valueOf(rs.getInt("Numero"));
			registros[1] = rs.getString("Nombre");
			registros[2] = rs.getNString("Apellido_1");
			registros[3] = rs.getString("Direccion");
			registros[4] = rs.getString("Telefono");
			registros[5] = rs.getString("Dni");
			registros[6] = rs.getString("Ong_CIF");
			model.addRow(registros);

		}
		return model;
	} catch (Exception e) {
		return null;
	}

}

DefaultTableModel model;

public void crearJtabla() {
	Principal principal = new Principal();
	try {
		model = (new DefaultTableModel(null,
				new String[] { "Id Empleado", "Nombre", "Apellido", "Direccion", "Telefono", "Dni", "Ong_CIF"}) {
			Class[] types = new Class[] { 
					java.lang.Integer.class, 
					java.lang.String.class, 
					java.lang.String.class,
					java.lang.String.class,
					java.lang.String.class,
					java.lang.String.class,
					java.lang.String.class,};
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

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

public DefaultTableModel llenarJtable() {
	
	String[] cabecera = { "Id Empleado", "Nombre", "Apellido", "Direccion", "Telefono", "Dni", "Ong_CIF" };
	DefaultTableModel model = new DefaultTableModel(null, cabecera);
	try {
		Object obj[] = null;
		List<Empleados>listaEmpleados;
		listaEmpleados= DAOFactory.getDAOFactory(4).jpaEmpleadosDAO().seleccionar();
		for (int i = 0; i < listaEmpleados.size(); i++) {
			model.addRow(obj);
			model.setValueAt(listaEmpleados.get(i).getNumero(), i, 0);
			model.setValueAt(listaEmpleados.get(i).getNombre(), i, 1);
			model.setValueAt(listaEmpleados.get(i).getApellidos(), i, 2);
			model.setValueAt(listaEmpleados.get(i).getDireccion(), i, 3);
			model.setValueAt(listaEmpleados.get(i).getTelefono(), i, 4);
			model.setValueAt(listaEmpleados.get(i).getDNI(), i, 5);
			model.setValueAt(listaEmpleados.get(i).getOngCif(), i, 6);
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return model;
}

}
