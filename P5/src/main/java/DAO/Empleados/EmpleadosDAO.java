package DAO.Empleados;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Empleados;

public interface EmpleadosDAO {

	public void guardarEmpleados(Empleados empleados) throws JAXBException;
	public Empleados listaEmpleados() throws JAXBException;
	
	
	
	
}
