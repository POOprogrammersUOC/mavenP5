package DAO.jordi;

import javax.xml.bind.JAXBException;

public class XMLDAOFactory extends DAOFactory {

	
	public XMLSociosDAO getSociosDao() throws JAXBException {
		// TODO Auto-generated method stub
		return new XMLSociosDAO();
	}

	
	
}
