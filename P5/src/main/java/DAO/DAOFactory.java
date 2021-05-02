package DAO;

import javax.xml.bind.JAXBException;

public abstract class DAOFactory {

	// Lista de tipos DAO soportado por la factoria.

	public static final int XML = 1;
	public static final int SQL = 2;
	public static final int IMPORTXMLTOSQL = 3;

	// Para cada clase tenemos un DAO que es creado
	public abstract XMLProyectosDAO getProyectosDAO() throws JAXBException;

	public abstract XMLEmpleadosDAO getEmpleadosDAO() throws JAXBException;

	public abstract XMLSociosDAO getSociosDAO() throws JAXBException;

	public abstract SQLProyectosDAO sqlProyectosDAO();

	public abstract SQLEmpleadosDAO sqlEmpleadosDAO();
	
	public abstract importXMLtoSQLProyectosDAO setImportXMLtoSQLProyectos() throws JAXBException;
	
	public abstract importXMLtoSQLEmpleadosDAO setImportXMLtoSQLEmpleados() throws JAXBException;

	public abstract SQLSociosDAO sqlSociosDAO();

	public abstract importXMLtoSQLSociosDAO setImportXMLtoSQLSocios() throws JAXBException;

	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {
		case 1:
			return new XMLDAOFactory();
		case 2:
			return new SQLDAOFactory();
		case 3:
			return new ImportXMLtoSQLFactory();
		default:
			return null;

		}

	}
}