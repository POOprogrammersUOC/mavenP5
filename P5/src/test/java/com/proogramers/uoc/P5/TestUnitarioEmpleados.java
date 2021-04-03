package com.proogramers.uoc.P5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestUnitarioEmpleados {

	ArrayList<Empleados> listaEmpleados = new ArrayList<>();


	Empleados p1 = new Empleados("Jose", "rodriguez", "Calle Mayor 21", "1235485", "3216548s");

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testInsert() {

		listaEmpleados.add(p1);
		assertEquals(listaEmpleados.size(), 1); // verificamos que hay 1 elemento en la lista

	}

	@Test
	public void testDelete() {

		listaEmpleados.add(p1);
		listaEmpleados.remove(0);
		assertEquals(listaEmpleados.size(), 0); // verificamos que se ha eliminado de la lista

	}

	@Test
	public void testUpdate() {

		System.out.println("------------P1--------------");
		System.out.println(p1.toString());
		System.out.println("----------------------------");
		listaEmpleados.add(p1);
		p1.setNombre("Jose");
		System.out.println("---------P1 UPDATE----------");
		System.out.println(listaEmpleados.toString());
		System.out.println("----------------------------");
		assertEquals(p1, listaEmpleados.get(0)); // verificamos que se ha actualizado de la lista

	}
}
