package DAO.jordi;
import java.io.File;
import java.io.FileWriter;

import com.proogramers.uoc.P5.Ong;
import com.proogramers.uoc.P5.Socios;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLSocios implements ISociosDAO {
	
	private JAXBContext contexto = null;
	private String nombreFichero= null;
	
	public XMLSocios() throws JAXBException {
		
		this.contexto= JAXBContext.newInstance(Socios.class);
		this.nombreFichero= "xml/socios.xml";
	}
		

	@Override
	public void guardarsocios(Socios socios) throws JAXBException {
		
		
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(socios, new File(nombreFichero));
		marshaller.marshal(socios, System.out);
	}

	@Override
	public Socios listarsocios() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}
}

