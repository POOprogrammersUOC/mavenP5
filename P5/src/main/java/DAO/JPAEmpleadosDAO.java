package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proogramers.uoc.P5.Empleados;

public class JPAEmpleadosDAO implements IEmpleadosJPADAO{
	static Logger log = LogManager.getRootLogger();

	@Override
	public List<Empleados> seleccionar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
		
		String query = "SELECT e FROM Empleados e";
		TypedQuery<Empleados>tq = em.createQuery(query, Empleados.class);
		List<Empleados>listaEmpleados = null;
		try {
			
			listaEmpleados = tq.getResultList();
			log.debug("Resultados: " + listaEmpleados);
			for (Empleados empleados : listaEmpleados) {
				System.out.println(listaEmpleados + "\n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listaEmpleados;
	}

	@Override
	public void persist(Empleados empleados) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        try {
	        	log.debug("Objeto no tratado: " + empleados);
	            em.persist(empleados);
	            em.getTransaction().commit();
	            log.debug("Objeto tratado: " + empleados);
	            JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Registro erroneo", "Registro", JOptionPane.ERROR_MESSAGE);
	            em.getTransaction().rollback();
	            
	        } finally {
	            em.close();
	        }
	}

	@Override
	public void actualizar(Empleados empleados) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        	log.debug("Objeto no tratado: " + empleados);
        	em.merge(empleados);
            em.getTransaction().commit();
            log.debug("Objeto tratado: " + empleados);
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
        Empleados empleados = em.find(Empleados.class, id);
        try {
            if (empleados != null) {
            	log.debug("Objeto no Eliminado: " + empleados);
                em.getTransaction().begin();
                em.remove(empleados);
                em.getTransaction().commit();
                log.debug("Objeto Eliminado: " + empleados);
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
	public Empleados leerId(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
		EntityManager em = emf.createEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
	}
	
}

