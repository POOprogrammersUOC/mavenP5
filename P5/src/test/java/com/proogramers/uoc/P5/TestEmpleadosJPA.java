package com.proogramers.uoc.P5;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.*;


public class TestEmpleadosJPA {
	
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
	
		Empleados empleados = new Empleados ("Marian", "fsdfs", "fsdf", "53434", "fsdfsf", "12345b");
		log.debug("Objeto no tratado: " + empleados);
		
		em.persist(empleados);
		tx.commit();
		
		log.debug("Objeto tratado: " + empleados);
		em.close();*/
		
		consultaJPA();
		
	}
	
public static void consultaJPA() {
		
		EntityManagerFactory emf = Persistence
	            .createEntityManagerFactory("ProyectosPU");
	      EntityManager em = emf.createEntityManager();
	    
	      List<Empleados> resultList = em.createQuery(
	    	         "Select a From Empleados a", Empleados.class).getResultList();
	    	   System.out.println("num of employess:" + resultList.size());
	    	   for (Empleados next : resultList) {
	    	      System.out.println("next employee: " + next);
	 
	      em.close();
	      }
	}

}
