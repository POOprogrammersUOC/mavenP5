package com.proogramers.uoc.P5;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import DAO.DAOFactory;
import DAO.IProyectosDAO;
import DAO.XMLProyectosDAO;

/***
 * 
 * @author Isaac tutusaus
 * @version 1.0
 */


public class TestXmlProyectosDAO {

	public static void main(String[] args) throws JAXBException {
		
		ArrayList<Proyectos> nuevaLista = new ArrayList<>();
		Proyectos p1 = new Proyectos();
		Proyectos p2 = new Proyectos();
		
		p1.setPais("España");
		p1.setLocalizacion("Barcelona");
		p1.setLineaDeAccion("Nada");
		p1.setSublineaDeAccion("Nada");;
		LocalDate fInicio = LocalDate.parse("2000-01-01");
		p1.setFechaInicio(fInicio);
		LocalDate fFinal = LocalDate.parse("2001-01-01");
		p1.setFechaFinal(fFinal);
		p1.setSocioLocal("Pedro Martinez");
		p1.setFinanciador("Daniel carrillo");;
		p1.setFinanciacion(2000.00);
		p1.setNumProyecto(0);
		p1.setAcciones("Sin observaciones");
		p1.setPersonal(30);
		p1.setVoluntariosAsignados(20);
		
		p2.setPais("Polonia");
		p2.setLocalizacion("Barcelona");
		p2.setLineaDeAccion("Nada");
		p2.setSublineaDeAccion("Nada");;
		LocalDate f2Inicio = LocalDate.parse("2000-01-01");
		p2.setFechaInicio(f2Inicio);
		LocalDate f2Final = LocalDate.parse("2001-01-01");
		p2.setFechaFinal(f2Final);
		p2.setSocioLocal("Pedro Martinez");
		p2.setFinanciador("Daniel carrillo");;
		p2.setFinanciacion(2000.00);
		p2.setNumProyecto(0);
		p2.setAcciones("Sin observaciones");
		p2.setPersonal(30);
		p2.setVoluntariosAsignados(20);
		nuevaLista.add(p1);
		nuevaLista.add(p2);
		
		
		
		DAOFactory.getDAOFactory(1).getProyectosDAO().guardarProyectos(p2);
		//DAOFactory.getDAOFactory(1).getProyectosDAO().listaProyectos();

	}
	


}
