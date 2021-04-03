package com.proogramers.uoc.P5;


import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import DAO.ISociosDAO;
import DAO.XMLSociosDAO;
import DAO.DAOFactory;



public class TestXmlSociosDAO {

	public static void main(String[] args) throws JAXBException {
		
		ArrayList<Socios> nuevaLista = new ArrayList<>();
		Socios socio1 = new Socios();
		
		socio1.setNombre("Marcos");
		socio1.setApellidos("Alonso");
		socio1.setnSocio(120);
		socio1.setDireccion("Barcelona");
		socio1.setTelefono("654569894");
		nuevaLista.add(socio1); 
		
		DAOFactory.getDAOFactory(1).getSociosDAO().guardarSocios(socio1);
		
	

	}
	


}