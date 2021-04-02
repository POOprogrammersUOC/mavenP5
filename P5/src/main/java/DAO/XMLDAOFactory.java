  
package DAO;

import javax.xml.bind.JAXBException;

public class XMLDAOFactory extends DAOFactory {

	public  XMLProyectosDAO getProyectosDAO() throws JAXBException{
		return new XMLProyectosDAO();
	}
	
}