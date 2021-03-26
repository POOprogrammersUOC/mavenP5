package DAO;

import javax.xml.bind.JAXBException;

public abstract class DAOFactory {

	// Lista de tipos DAO soportado por la factoria.
		public static final int XML = 1;
		public static final int SQL = 2;
		
		//Para cada clase tenemos un DAO que es creado
		public abstract XMLProyectosDAO getProyectosDAO() throws JAXBException;
		
		
		public static DAOFactory getDAOFactory(int whichFactory) {
			
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
