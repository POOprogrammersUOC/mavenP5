package DAO;

import javax.xml.bind.JAXBException;

public class JPADAOFactory extends DAOFactory {

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
	public SQLEmpleadosDAO sqlEmpleadosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public importXMLtoSQLProyectosDAO setImportXMLtoSQLProyectos() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public importXMLtoSQLEmpleadosDAO setImportXMLtoSQLEmpleados() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public SQLSociosDAO sqlSociosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public importXMLtoSQLSociosDAO setImportXMLtoSQLSocios() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public JPAProyectosDAO jpaProyectosDAO() {
		// TODO Esbozo de método generado automáticamente
		return new JPAProyectosDAO();
	}

	@Override
	public JPASociosDAO jpaSociosDAO() {
		// TODO Esbozo de método generado automáticamente
		return new JPASociosDAO();
	
	}	
}
