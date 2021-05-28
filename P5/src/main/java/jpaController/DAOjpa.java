package jpaController;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.*;

import com.proogramers.uoc.P5.Proyectos;

import interfazGrafica.Principal;

public class DAOjpa {

	static Logger log = LogManager.getRootLogger();

	//public static void main(String[] args) {

		
	//}
	/*
	public void insertarJPA() {
		Principal principal = new Principal();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Date sqlDate = Date.valueOf(txtFinicio().getText());
		LocalDate fInicio = sqlDate.toLocalDate();
		Date sqlDate2 = Date.valueOf(principal.getTxtFfinal().getText());
		LocalDate fFinal = sqlDate2.toLocalDate();

		String per1 = principal.getTxtPersonal().getText();
		int personal = Integer.parseInt(per1);

		String vol = principal.getTxtVoluntarios().getText();
		int voluntarios = Integer.parseInt(vol);

		String finan = principal.getTxtFinanciacion().getText();
		double financiacion = Double.parseDouble(finan);

		Proyectos proyectos = new Proyectos(principal.getTxtPais().getText(), principal.getTxtLocalizacion().getText(), principal.getTextAreaLinea().getText(),
				principal.getTextAreaSublinea().getText(), fInicio, fFinal, principal.getTxtSocioLocal().getText(), principal.getTxtFinanciador().getText(),
				financiacion, principal.getTextAreaAccion().getText(), personal, voluntarios, principal.getTxtCifOng().getText());
		log.debug("Objeto no tratado: " + proyectos);

		em.persist(proyectos);

		tx.commit();

		log.debug("Objeto tratado: " + proyectos);
		em.close();
	}
	*/
}
