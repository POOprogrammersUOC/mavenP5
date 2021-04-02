package DAO.Empleados;

import javax.xml.bind.JAXBException;

public abstract class DAOFactoryEmpl {

	// Lista de tipos DAO soportado por la factoria.
		public static final int XML = 1;
		public static final int SQL = 2;
		
		//Para cada clase tenemos un DAO que es creado
		public abstract XMLEmpleados getEmpleadosDAO() throws JAXBException;
		
		
		public static DAOFactoryEmpl getDAOFactoryEmpl(int whichFactory) {
			
			switch (whichFactory) {
				case 1: 
					return new EmpleadosDAOImpl();
		        case 2: 
		           // return new SQLDAOFactory();
		        default: 
		            return null;
		    }
			
		}
}
