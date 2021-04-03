package DAO.jordi;

import javax.xml.bind.JAXBException;

import DAO.XMLDAOFactory;

public abstract class DAOFactory {

	// Lista de tipos DAO soportado por la factoria.
		public static final int XML = 1;
		public static final int SQL = 2;
		
		//Para cada clase tenemos un DAO que es creado
		public abstract XMLSociosDAO getSociosDAO() throws JAXBException;
		
				
		public static XMLDAOFactory getDAOFactory(int whichFactory) {
			
			switch (whichFactory) {
				case 1: 
					return new XMLDAOFactory();
		        case 2: 
		           // return new SQLDAOFactory();
		        default: 
		            return null;
		    }
			
		}
}
