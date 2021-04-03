package com.proogramers.uoc.P5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;



public class SociosTestListado {

	List<Socios> listadoSocios = new ArrayList<Socios>();
	
	@Test
	public void AddSociosTest() throws JAXBException {
		
		Socios soc1 = new Socios("Jose", "Martinez", 121, "Barcelona", "654859698");
		Socios soc2 = new Socios("Anotnio", "Gonzalez", 122, "Granollers", "698745256");
				
		assertEquals(0, listadoSocios.size());
		listadoSocios.add(soc1); 
		assertEquals(1, listadoSocios.size()); 
		listadoSocios.add(soc2);
		
	}
	
	@Test 
	public void EliminarSociosTest() throws JAXBException {
		
		
		
	}

}