package DAO;


import java.util.List;

import com.proogramers.uoc.P5.Proyectos;

public interface IProyectosJPADAO {

	public List<Proyectos> seleccionar(); 
	public void persist(Proyectos proyectos); 
	public void actualizar(Proyectos proyectos); 
	public void eliminar(Integer id); 
}
