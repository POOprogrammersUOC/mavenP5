package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proogramers.uoc.P5.Proyectos;

public class JPAProyectosDAO implements IProyectosJPADAO {

	//private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
	//private static EntityManager em = emf.createEntityManager();
	//private static EntityTransaction tx = em.getTransaction();
	static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<Proyectos> seleccionar() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public void persist(Proyectos proyectos) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        try {
	        	log.debug("Objeto no tratado: " + proyectos);
	            em.persist(proyectos);
	            em.getTransaction().commit();
	            log.debug("Objeto tratado: " + proyectos);
	            JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Registro erroneo", "Registro", JOptionPane.ERROR_MESSAGE);
	            em.getTransaction().rollback();
	            
	        } finally {
	            em.close();
	        }
		
	}

	@Override
	public void actualizar(Proyectos proyectos) {
		// TODO Esbozo de método generado automáticamente
	
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Esbozo de método generado automáticamente
		
	}

}
