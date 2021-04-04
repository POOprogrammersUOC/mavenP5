package com.proogramers.uoc.P5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestUnitarioSocios {

	// Añadimos datos a la arraylist de Socios para comprobar que funciona bien
	ArrayList<Socios> listaSocios = new ArrayList<>();

	Socios s1 = new Socios("Juan", "Valdes", 123, "Barcelona", "965698986");

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testInsert() {

		listaSocios.add(s1);
		assertEquals(listaSocios.size(), 1);

	}

	@Test
	public void testDelete() {

		listaSocios.add(s1);
		listaSocios.remove(0);
		assertEquals(listaSocios.size(), 0);

	}

	@Test
	public void testUpdate() {

		System.out.println("------------S1--------------");
		System.out.println(s1.toString());
		System.out.println("----------------------------");
		listaSocios.add(s1);
		s1.setNombre("Luis");
		System.out.println("---------S1 UPDATE----------");
		System.out.println(listaSocios.toString());
		System.out.println("----------------------------");
		assertEquals(s1, listaSocios.get(0));

	}
}