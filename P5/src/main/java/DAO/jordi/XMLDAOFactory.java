package DAO.jordi;

import javax.xml.bind.JAXBException;

public class XMLDAOFactory extends DAOFactory {

	
	public XMLSocios getSociosDao() throws JAXBException {
		// TODO Auto-generated method stub
		return new XMLSocios();
	}

	
	
}
