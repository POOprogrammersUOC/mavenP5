package DAO;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.proogramers.uoc.P5.Proyectos;

public class XMLProyectosDAO implements IProyectosDAO{

	private JAXBContext contexto = null;
	private String nombreFichero = null;
	
	
	public XMLProyectosDAO() throws JAXBException {
		
		this.contexto = JAXBContext.newInstance(Proyectos.class);
		this.nombreFichero = "xml/Proyectos.xml";
	}

	@Override
	public void guardarProyectos(Proyectos proyectos) throws JAXBException {

		Marshaller mar = contexto.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		mar.marshal(proyectos, new File(nombreFichero));
		System.out.println("");
		System.out.println("Se ha generado el fichero " + nombreFichero + ". El contenido es el siguiente: ");
		System.out.println("");
		mar.marshal(proyectos, System.out);
		
		
		
	}

	@Override
	public Proyectos listaProyectos() throws JAXBException {
		// TODO Esbozo de método generado automáticamente
		return null;
	}
}
