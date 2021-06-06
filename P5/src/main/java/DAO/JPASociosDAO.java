package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proogramers.uoc.P5.Socios;

public class JPASociosDAO implements ISociosJPADAO {
		static Logger log = LogManager.getRootLogger();

		@Override
		public List<Socios> seleccionar() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
			EntityManager em = emf.createEntityManager();
			
			String query = "SELECT e FROM Socios e";
			TypedQuery<Socios>tq = em.createQuery(query, Socios.class);
			List<Socios>listaSocios = null;
			try {
				
				listaSocios = tq.getResultList();
				log.debug("Resultados: " + listaSocios);
				for (Socios socios : listaSocios) {
					System.out.println(listaSocios + "\n");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return listaSocios;
		}

		@Override
		public void persist(Socios socios) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
			EntityManager em = emf.createEntityManager();
		        em.getTransaction().begin();
		        try {
		        	log.debug("Objeto no tratado: " + socios);
		            em.persist(socios);
		            em.getTransaction().commit();
		            log.debug("Objeto tratado: " + socios);
		            JOptionPane.showMessageDialog(null, "Registro insertado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, "Registro erroneo", "Registro", JOptionPane.ERROR_MESSAGE);
		            em.getTransaction().rollback();
		            
		        } finally {
		            em.close();
		        }
		}

		@Override
		public void actualizar(Socios socios) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
			EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        try {
	        	log.debug("Objeto no tratado: " + socios);
	        	em.merge(socios);
	            em.getTransaction().commit();
	            log.debug("Objeto tratado: " + socios);
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
	        Socios socios = em.find(Socios.class, id);
	        try {
	            if (socios != null) {
	            	log.debug("Objeto no Eliminado: " + socios);
	                em.getTransaction().begin();
	                em.remove(socios);
	                em.getTransaction().commit();
	                log.debug("Objeto Eliminado: " + socios);
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
		public Socios leerId(Integer id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosPU");
			EntityManager em = emf.createEntityManager();
	        try {
	            return em.find(Socios.class, id);
	        } finally {
	            em.close();
	        }
		}
		
	}


	
	

	

