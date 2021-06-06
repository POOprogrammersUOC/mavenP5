package DAO;

import javax.xml.bind.JAXBException;

public class ImportXMLtoSQLFactory extends DAOFactory {

	@Override
	public XMLProyectosDAO getProyectosDAO() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public XMLEmpleadosDAO getEmpleadosDAO() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public XMLSociosDAO getSociosDAO() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public SQLProyectosDAO sqlProyectosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public importXMLtoSQLProyectosDAO setImportXMLtoSQLProyectos() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return new importXMLtoSQLProyectosDAO();
	}

	@Override

	public SQLSociosDAO sqlSociosDAO() {
		// TODO Esbozo de método generado automáticamente
		return new SQLSociosDAO();
	}

	@Override
	public importXMLtoSQLSociosDAO setImportXMLtoSQLSocios() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	public SQLEmpleadosDAO sqlEmpleadosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public importXMLtoSQLEmpleadosDAO setImportXMLtoSQLEmpleados() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return new importXMLtoSQLEmpleadosDAO();
	}

	@Override
	public JPAProyectosDAO jpaProyectosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}
	
	public JPAEmpleadosDAO jpaEmpleadosDAO() {
		return null;
	}
	
	@Override
	public JPASociosDAO jpaSociosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	
	}
	
	
	
	
}
