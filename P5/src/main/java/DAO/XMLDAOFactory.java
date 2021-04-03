
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

}
