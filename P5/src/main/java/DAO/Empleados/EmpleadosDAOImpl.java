package DAO.Empleados;

import javax.xml.bind.JAXBException;

public class EmpleadosDAOImpl extends DAOFactoryEmpl{
	
	public XMLEmpleados getEmpleadosDAO() throws JAXBException{
		return new XMLEmpleados();
	}
	
}
