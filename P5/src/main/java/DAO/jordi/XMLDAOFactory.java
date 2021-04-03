package DAO.jordi;

import javax.xml.bind.JAXBException;

public class XMLDAOFactory extends DAOFactory {

	
	public XMLSociosDAO getSociosDAO() throws JAXBException {
		
		return new XMLSociosDAO();
	}

	
	
}
