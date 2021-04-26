package DAO;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Proyectos;

public interface IImportXMLtoSQL {

	Proyectos XMLtoSQL() throws JAXBException;

}
