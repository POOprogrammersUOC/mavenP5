package DAO;

import java.io.File;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.proogramers.uoc.P5.Empleados;


public class importXMLtoSQLEmpleadosDAO implements ImportXMLtoSQL {

	private JAXBContext contexto = null; // Iniciamos las variables a null para evitar que se inicien con residuos
	private String nombreFichero = null;

	public importXMLtoSQLEmpleadosDAO() throws JAXBException { // creamos el constructor para que cada vez que se llame a la
													// función se ejecute

		this.contexto = JAXBContext.newInstance(Empleados.class); // creamos la nueva instancia de proyectos
		this.nombreFichero = "xml/Empleados.xml";
	}
	
	@Override
	public Empleados XMLtoSQL() throws JAXBException {
		
		Unmarshaller unmar = contexto.createUnmarshaller(); // creamos el objeto unmarshaller
		Empleados empleados = (Empleados) unmar.unmarshal(new File(nombreFichero)); // leemos del fichero seleccionado

		System.out.println("*************************************************************************************************************");
		System.out.println(" Se van a cargar los siguientes empleados del fichero: " + nombreFichero + " en la tabla empleados de MYSQL");
		System.out.println("*************************************************************************************************************");

		System.out.println(empleados); // imprimimos por pantalla los resultados del XML

		SQLEmpleadosDAO XmlToSql = new SQLEmpleadosDAO();
		try {
			XmlToSql.insertar(empleados);
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
		return null;
	}

}
