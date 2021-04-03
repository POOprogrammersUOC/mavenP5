package com.proogramers.uoc.P5;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import DAO.jordi.DAOFactory;
import DAO.jordi.ISociosDAO;
import DAO.jordi.XMLSociosDAO;



public class TestXmlSociosDAO {

	public static void main(String[] args) throws JAXBException {
		
		ArrayList<Socios> nuevaLista = new ArrayList<>();
		Socios socio1 = new Socios();
		
		
		socio1.setNombre("Marcos");
		socio1.setApellidos("Alonso");
		socio1.setnSocio(120);
		socio1.setDireccion("Barcelona");
		socio1.setTelefono("654569894");
		
		DAOFactory.getDAOFactory(1).getSociosDao().guardarSocios(socio1);
	

	}
	


}