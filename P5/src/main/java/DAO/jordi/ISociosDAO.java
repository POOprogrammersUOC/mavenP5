package DAO.jordi;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Socios;

public interface ISociosDAO {

	public void guardarSocios(Socios socios) throws JAXBException;
	
	public Socios listarSocios() throws JAXBException;
	
	
}
