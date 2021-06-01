package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT e FROM Proyectos e";
		TypedQuery<Proyectos>tq = em.createQuery(query, Proyectos.class);
		List<Proyectos>listaProyectos = null;
		try {
			
			listaProyectos = tq.getResultList();
			log.debug("Resultados: " + listaProyectos);
			for (Proyectos proyectos : listaProyectos) {
				System.out.println(listaProyectos + "\n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaProyectos;
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        	log.debug("Objeto no tratado: " + proyectos);
        	em.merge(proyectos);
            em.getTransaction().commit();
            log.debug("Objeto tratado: " + proyectos);
            JOptionPane.showMessageDialog(null, "Registro modificado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Registro no modificado", "Registro", JOptionPane.ERROR_MESSAGE);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
	
	}

	@Override
	public void eliminar(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
        Proyectos proyectos = em.find(Proyectos.class, id);
        try {
            if (proyectos != null) {
            	log.debug("Objeto no Eliminado: " + proyectos);
                em.getTransaction().begin();
                em.remove(proyectos);
                em.getTransaction().commit();
                log.debug("Objeto Eliminado: " + proyectos);
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Registro no borrado", "Registro", JOptionPane.ERROR_MESSAGE);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
		
	}

	@Override
	public Proyectos leerId(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
        try {
            return em.find(Proyectos.class, id);
        } finally {
            em.close();
        }
	}

}
