
package DAO;

import javax.xml.bind.JAXBException;

public class XMLDAOFactory extends DAOFactory {

	public XMLProyectosDAO getProyectosDAO() throws JAXBException {
		return new XMLProyectosDAO();
	}

	public XMLSociosDAO getSociosDAO() throws JAXBException {

		return new XMLSociosDAO();
	}

	public XMLEmpleadosDAO getEmpleadosDAO() throws JAXBException {
		return new XMLEmpleadosDAO();

	}

	@Override
	public SQLProyectosDAO sqlProyectosDAO() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public importXMLtoSQLProyectosDAO setImportXMLtoSQLProyectos() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public SQLSociosDAO sqlSociosDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public importXMLtoSQLSociosDAO setImportXMLtoSQLSocios() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
