package DAO;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.proogramers.uoc.P5.Ong;
import com.proogramers.uoc.P5.Proyectos;


public class XMLProyectosDAO implements IProyectosDAO{

	private JAXBContext contexto = null;	//Iniciamos las variables a null para evitar que se inicien con residuos
	private String nombreFichero = null;
	
	
	public XMLProyectosDAO() throws JAXBException {		//creamos el constructor para que cada vez que se llame a la función se ejecute
		
		this.contexto = JAXBContext.newInstance(Proyectos.class); //creamos la nueva instancia de proyectos
		this.nombreFichero = "xml/Proyectos.xml"; //indicamos la ruta del fichero
	}

	@Override
	public void guardarProyectos(Proyectos proyectos) throws JAXBException {

		Marshaller mar = contexto.createMarshaller(); //creamos el objeto
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // seleccionamos la propiedad de formateo en xml
		mar.marshal(proyectos, new File(nombreFichero)); // se crea el fichero
		System.out.println("********************************************************************************");
		System.out.println(" Se ha generado el fichero en " + nombreFichero + ". El contenido es el siguiente: ");
		System.out.println("********************************************************************************");
		mar.marshal(proyectos, System.out); // imprimimos por pantalla el xml
		
		
		
	}

	@Override
	public Proyectos listaProyectos() throws JAXBException {
		
		Unmarshaller unmar = contexto.createUnmarshaller(); //creamos el objeto unmarshaller
		Proyectos proyectos = (Proyectos) unmar.unmarshal(new File(nombreFichero)); //leemos del fichero seleccionado
		
		
		System.out.println("************************************************************************");
		System.out.println(" Se van a cargar los siguientes proyectos del fichero: " + nombreFichero);
		System.out.println("************************************************************************");
		
		System.out.println(proyectos); //imprimimos por pantalla los resultados del XML
		
		/*
		for (Proyectos proyectosunm : new Ong().getListaProyectos()) {
			
			System.out.println("*****************************************");
			System.out.println("           LISTA DE PROYECTOS            ");
			System.out.println("*****************************************");
			
			System.out.println("Acciones: " + proyectosunm.getAcciones());
			System.out.println("Fecha Inicio: " + proyectosunm.getFechaInicio());
			System.out.println("Fecha Final: " + proyectosunm.getFechaFinal());
			System.out.println("Financiación: " + proyectosunm.getFinanciacion());
			System.out.println("Financiador: " + proyectosunm.getFinanciador());
			System.out.println("Línea de acción: " + proyectosunm.getLineaDeAccion());
			System.out.println("Localización: " + proyectosunm.getLocalizacion());
			System.out.println("Número de proyecto: " + proyectosunm.getNumProyecto());
			System.out.println("Pais: " + proyectosunm.getPais());
			System.out.println("Personal: " + proyectosunm.getPersonal());
			System.out.println("Socio Local: " + proyectosunm.getSocioLocal());
			System.out.println("Sublínea de acción: " + proyectosunm.getSublineaDeAccion());
			System.out.println("Voluntarios: " + proyectosunm.getVoluntariosAsignados());
			
		}
		*/
		return null;
	}

}
