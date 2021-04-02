package DAO.Empleados;


import java.io.File;

import com.proogramers.uoc.P5.Empleados;
import com.proogramers.uoc.P5.Ong;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLEmpleados implements EmpleadosDAO {
	
	private JAXBContext contexto = null;	//Iniciamos las variables a null para evitar que se inicien con residuos
	private String nombreFichero = null;
	
	
	public XMLEmpleados() throws JAXBException {		//creamos el constructor para que cada vez que se llame a la función
		
		this.contexto = JAXBContext.newInstance(Empleados.class); //creamos la nueva instancia de proyectos
		this.nombreFichero = "xml/Empleados.xml"; //indicamos la ruta del fichero

	}
	
	@Override
	public void guardarEmpleados(Empleados empleados) throws JAXBException {

		Marshaller mar = contexto.createMarshaller(); //creamos el objeto
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // seleccionamos la propiedad de formateo en xml
		mar.marshal(empleados, new File(nombreFichero)); // se crea el fichero
		System.out.println("********************************************************************************");
		System.out.println(" Se ha generado el fichero en " + nombreFichero + ". El contenido es el siguiente: ");
		System.out.println("********************************************************************************");
		mar.marshal(empleados, System.out); // imprimimos por pantalla el xml
		
				
	}

	@Override
	public Empleados listaEmpleados() throws JAXBException {
		
		Unmarshaller unmar = contexto.createUnmarshaller(); //creamos el objeto unmarshaller
		Empleados empleados = (Empleados) unmar.unmarshal(new File(nombreFichero)); //leemos del fichero seleccionado
		//Ong ong = new Ong();
		
		System.out.println("************************************************************************");
		System.out.println(" Se van a cargar los siguientes empleados del fichero: " + nombreFichero);
		System.out.println("************************************************************************");
		
		System.out.println(empleados); //imprimimos por pantalla los resultados del XML
	
		return null;
	}
}