  
package DAO;

import javax.xml.bind.JAXBException;

import DAO.jordi.ISociosDAO;

public class XMLDAOFactory extends DAOFactory {

	public  XMLProyectosDAO getProyectosDAO() throws JAXBException{
		return new XMLProyectosDAO();
	}

}
