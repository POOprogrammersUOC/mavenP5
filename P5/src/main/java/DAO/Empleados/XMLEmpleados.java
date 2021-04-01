package DAO.Empleados;


import java.io.FileWriter;

import com.proogramers.uoc.P5.Ong; 
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLEmpleados {
	
	public static void main(String[] args) throws JAXBException, IOException {
		
JAXBContext context = JAXBContext.newInstance(Ong.class);
		
		Marshaller marshaller = context.createMarshaller();
		
		Ong database = new Ong();
		database.getListaSocios("Database empleados");
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(database, System.out);
		//marshaller.marshal(database, new FileWriter("socios.xml"));
	

	
	
	}