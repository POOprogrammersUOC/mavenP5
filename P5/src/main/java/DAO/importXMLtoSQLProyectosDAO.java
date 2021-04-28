package DAO;

import java.io.File;
import java.sql.SQLException;

import DAO.SQLProyectosDAO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.proogramers.uoc.P5.Proyectos;

public class importXMLtoSQLProyectosDAO implements IImportXMLtoSQL{

	private JAXBContext contexto = null; // Iniciamos las variables a null para evitar que se inicien con residuos
	private String nombreFichero = null;

	public importXMLtoSQLProyectosDAO() throws JAXBException { // creamos el constructor para que cada vez que se llame a la
													// función se ejecute

		this.contexto = JAXBContext.newInstance(Proyectos.class); // creamos la nueva instancia de proyectos
		this.nombreFichero = "xml/Proyectos.xml"; // indicamos la ruta del fichero
	}
	
	@Override
	public Proyectos XMLtoSQL() throws JAXBException {

		Unmarshaller unmar = contexto.createUnmarshaller(); // creamos el objeto unmarshaller
		Proyectos proyectos = (Proyectos) unmar.unmarshal(new File(nombreFichero)); // leemos del fichero seleccionado

		System.out.println("*************************************************************************************************************");
		System.out.println(" Se van a cargar los siguientes proyectos del fichero: " + nombreFichero + " en la tabla proyectos de MYSQL");
		System.out.println("*************************************************************************************************************");

		System.out.println(proyectos); // imprimimos por pantalla los resultados del XML

		SQLProyectosDAO XmlToSql = new SQLProyectosDAO();
		try {
			XmlToSql.insertar(proyectos);
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return null;
	}
}
