package DAO;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.proogramers.uoc.P5.Socios;


public class XMLSociosDAO implements ISociosDAO{

	private JAXBContext contexto = null;	//Iniciamos las variables a null para evitar que se inicien con residuos
	private String nombreFichero = null;
	
	
	public XMLSociosDAO() throws JAXBException {		//creamos el constructor para que cada vez que se llame a la función
		
		this.contexto = JAXBContext.newInstance(Socios.class); //creamos la nueva instancia de proyectos
		this.nombreFichero = "xml/Socios.xml"; //indicamos la ruta del fichero
	}

	@Override
	public void guardarSocios(Socios socios) throws JAXBException {

		Marshaller mar = contexto.createMarshaller(); //creamos el objeto
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // seleccionamos la propiedad de formateo en xml
		mar.marshal(socios, new File(nombreFichero)); // se crea el fichero
		System.out.println("********************************************************************************");
		System.out.println(" Se ha generado el fichero en " + nombreFichero + ". El contenido es el siguiente: ");
		System.out.println("********************************************************************************");
		mar.marshal(socios, System.out); // imprimimos por pantalla el xml
		
		
		
	}

	@Override
	public Socios listarSocios() throws JAXBException {
		
		Unmarshaller unmar = contexto.createUnmarshaller(); //creamos el objeto unmarshaller
		Socios socios = (Socios) unmar.unmarshal(new File(nombreFichero)); //leemos del fichero seleccionado
		
		
		System.out.println("************************************************************************");
		System.out.println(" Se van a cargar los siguientes socios del fichero: " + nombreFichero);
		System.out.println("************************************************************************");
		
		System.out.println(socios); //imprimimos por pantalla los resultados del XML
		
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
