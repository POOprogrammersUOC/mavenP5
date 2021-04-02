package DAO.jordi;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Socios;

public interface ISociosDAO {

	public void guardarsocios(Socios socios) throws JAXBException;
	
	public Socios listarsocios() throws JAXBException;
	
	
}
