package DAO;

import javax.xml.bind.JAXBException;

import com.proogramers.uoc.P5.Proyectos;

public interface IProyectosDAO {

	public void guardarProyectos(Proyectos proyectos) throws JAXBException;
	public Proyectos listaProyectos() throws JAXBException;
	
}
