package DAO;

import java.io.File;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.proogramers.uoc.P5.Socios;

public class importXMLtoSQLSociosDAO implements SImportXMLtoSQL {

	private JAXBContext contexto = null; //
	private String nombreFichero = null;

	public importXMLtoSQLSociosDAO() throws JAXBException { // creamos el constructor

		this.contexto = JAXBContext.newInstance(Socios.class); // instancia de socios
		this.nombreFichero = "xml/Socios.xml";
	}

	@Override
	public Socios XMLtoSQL() throws JAXBException {

		Unmarshaller unmar = contexto.createUnmarshaller(); // objeto unmarshaller
		Socios socios = (Socios) unmar.unmarshal(new File(nombreFichero)); // leemos del fichero

		System.out.println(
				"*************************************************************************************************************");
		System.out.println(" Se van a cargar los siguientes socios del fichero: " + nombreFichero
				+ " en la tabla socios de MYSQL");
		System.out.println(
				"*************************************************************************************************************");

		System.out.println(socios); // imprimimos por pantalla

		SQLSociosDAO XmlToSql = new SQLSociosDAO();
		try {
			XmlToSql.insertar(socios);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}