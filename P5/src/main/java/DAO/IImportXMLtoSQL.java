package DAO;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Proyectos;
import com.proogramers.uoc.P5.Socios;

public interface IImportXMLtoSQL {

	Proyectos XMLtoSQL() throws JAXBException;
	

}
