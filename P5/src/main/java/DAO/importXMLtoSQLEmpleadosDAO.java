package DAO;

import java.io.File;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.proogramers.uoc.P5.Empleados;


public class importXMLtoSQLEmpleadosDAO implements ImportXMLtoSQL {

	private JAXBContext contexto = null; // 
	private String nombreFichero = null;

	public importXMLtoSQLEmpleadosDAO() throws JAXBException { // creamos el constructor

		this.contexto = JAXBContext.newInstance(Empleados.class); // instancia de empleados
		this.nombreFichero = "xml/Empleados.xml";
	}
	
	@Override
	public Empleados XMLtoSQL() throws JAXBException {
		
		Unmarshaller unmar = contexto.createUnmarshaller(); // objeto unmarshaller
		Empleados empleados = (Empleados) unmar.unmarshal(new File(nombreFichero)); // leemos del fichero
		
		System.out.println("*************************************************************************************************************");
		System.out.println(" Se van a cargar los siguientes empleados del fichero: " + nombreFichero + " en la tabla empleados de MYSQL");
		System.out.println("*************************************************************************************************************");

		System.out.println(empleados); // imprimimos por pantalla

		SQLEmpleadosDAO XmlToSql = new SQLEmpleadosDAO();
		try {
			XmlToSql.insertar(empleados);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
