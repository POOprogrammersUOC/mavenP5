package com.proogramers.uoc.P5;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import DAO.DAOFactory;

public class TestXmlEmpleadosDAO {
	

		public static void main(String[] args) throws JAXBException {
			
			ArrayList<Empleados> nuevaLista = new ArrayList<>();
			Empleados p1 = new Empleados();
			Empleados p2 = new Empleados();
			
			p1.setNombre("Alfonso");
			p1.setApellidos("aaaaa");
			p1.setDireccion("Calle Mayor 26");
			p1.setTelefono("456786");;
			p1.setDNI("6549874");
			p1.setOngCif("12345b");
			
			p2.setNombre("Manolo");
			p2.setApellidos("Sanchez");
			p2.setDireccion("Av España");
			p2.setTelefono("3216548");;
			p2.setDNI("65498722");
			p2.setOngCif("12345b");
			nuevaLista.add(p1);
			nuevaLista.add(p2);
			
			
			
			DAOFactory.getDAOFactory(1).getEmpleadosDAO().guardarEmpleados(p2);
			//DAOFactory.getDAOFactory(1).getProyectosDAO().listaProyectos();

		}
		
}
