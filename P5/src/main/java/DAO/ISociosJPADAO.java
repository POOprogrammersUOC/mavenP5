package DAO;

import java.util.List;

import com.proogramers.uoc.P5.Socios;

public interface ISociosJPADAO {

	public List<Socios> seleccionar(); 
	public void persist(Socios socios); 
	public void actualizar(Socios socios); 
	public void eliminar(Integer id); 
	public Socios leerId(Integer id);
	
	
	
	
}
