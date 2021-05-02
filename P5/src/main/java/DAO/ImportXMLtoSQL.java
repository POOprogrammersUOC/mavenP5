package DAO;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Empleados;

public interface ImportXMLtoSQL {
	
	Empleados XMLtoSQL() throws JAXBException;

}
