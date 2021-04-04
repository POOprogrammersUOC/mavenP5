package DAO;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Socios;

public interface ISociosDAO {

	// Especificamos los dos metodos que actuarán con el objeto Socios
	public void guardarSocios(Socios socios) throws JAXBException;
	
	public Socios listarSocios() throws JAXBException;
	
	
}
