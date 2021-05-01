package com.proogramers.uoc.P5;

import javax.xml.bind.JAXBException;

import DAO.DAOFactory;

public class TestImportXMLtoSQLEmpleados {
	
	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		try {
			DAOFactory.getDAOFactory(3).setImportXMLtoSQLEmpleados().XMLtoSQL();
			
		} catch (JAXBException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
