package com.proogramers.uoc.P5;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.*;

public class TestProyectosJPA {
	
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Date sqlDate = Date.valueOf("2050-01-01");
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = Date.valueOf("2051-12-12");
		LocalDate fFinal = sqlDate2.toLocalDate();
		Proyectos proyectos = new Proyectos("JPA","JPA1","JPA2","JPA3",fInicio,fFinal,"JPA4","JPA5",25000.00,"JPA6",50,20,"B154896325");
		log.debug("Objeto no tratado: " + proyectos);
		
		em.persist(proyectos);
		
		tx.commit();
		
		log.debug("Objeto tratado: " + proyectos);
		em.close();
	}

}
