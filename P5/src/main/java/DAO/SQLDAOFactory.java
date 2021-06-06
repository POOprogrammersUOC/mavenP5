package DAO;

import javax.xml.bind.JAXBException;

public class SQLDAOFactory extends DAOFactory {

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
		return new SQLProyectosDAO();
	}

	@Override
	public importXMLtoSQLProyectosDAO setImportXMLtoSQLProyectos() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public SQLSociosDAO sqlSociosDAO() {
		// TODO Auto-generated method stub
		return new SQLSociosDAO();
	}

	@Override
	public importXMLtoSQLSociosDAO setImportXMLtoSQLSocios() throws JAXBException {
		
		return null;
	}
		// TODO Auto-generated method stub

	public SQLEmpleadosDAO sqlEmpleadosDAO() {
		// TODO Esbozo de método generado automáticamente
		return new SQLEmpleadosDAO();
	}

	@Override
	public importXMLtoSQLEmpleadosDAO setImportXMLtoSQLEmpleados() throws JAXBException {
		// TODO Esbozo de método generado automáticamente

		return null;
	}

	@Override
	public JPAProyectosDAO jpaProyectosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public JPASociosDAO jpaSociosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

}
