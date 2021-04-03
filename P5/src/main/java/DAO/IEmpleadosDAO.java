package DAO;



import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Empleados;

public interface IEmpleadosDAO {

	public void guardarEmpleados(Empleados empleados) throws JAXBException;
	public Empleados listaEmpleados() throws JAXBException;
	
	
}
