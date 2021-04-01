package com.proogramers.uoc.P5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestUnitarioProyectos {
	

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testInsert() {

		ArrayList<Proyectos> listaProyectos = new ArrayList<>();
		LocalDate iDate1 = LocalDate.parse("2000-01-01");
		LocalDate fDate1 = LocalDate.parse("2002-02-02");
		Proyectos p1 = new Proyectos("España", "Catalunya", "Nada", "Nada", iDate1, fDate1, "Antonio", "Jesus", 5000.00,
				"Nada de accions", 5, 12);

		listaProyectos.add(p1);

		assertEquals(listaProyectos.size(), 1); // verificamos que hay 1 elemento en la lista
		

	}

	@Test
	public void testDelete() {

		ArrayList<Proyectos> listaProyectos = new ArrayList<>();
		LocalDate iDate1 = LocalDate.parse("2000-01-01");
		LocalDate fDate1 = LocalDate.parse("2002-02-02");
		Proyectos p1 = new Proyectos("España", "Catalunya", "Nada", "Nada", iDate1, fDate1, "Antonio", "Jesus", 5000.00,
				"Nada de accions", 5, 12);

		listaProyectos.add(p1);
		listaProyectos.remove(0);
		assertEquals(listaProyectos.size(), 0); // verificamos que se ha eliminado de la lista

	}
	
	@Test
	public void testUpdate() {

		ArrayList<Proyectos> listaProyectos = new ArrayList<>();
		LocalDate iDate1 = LocalDate.parse("2000-01-01");
		LocalDate fDate1 = LocalDate.parse("2002-02-02");
		Proyectos p1 = new Proyectos("España", "Catalunya", "Nada", "Nada", iDate1, fDate1, "Antonio", "Jesus", 5000.00,
				"Nada de accions", 5, 12);
		System.out.println("------------P1--------------");
		System.out.println(p1.toString());
		System.out.println("----------------------------");
		listaProyectos.add(p1);
		p1.setPais("Alemania");
		System.out.println("---------P1 UPDATE----------");
		System.out.println(listaProyectos.toString());
		System.out.println("----------------------------");
		assertEquals(p1, listaProyectos.get(0) ); // verificamos que se ha actualizado de la lista

	}
}
