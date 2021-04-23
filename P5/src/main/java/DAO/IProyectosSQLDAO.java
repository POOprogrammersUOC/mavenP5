package DAO;

import java.util.List;

import com.proogramers.uoc.P5.Proyectos;

public interface IProyectosSQLDAO {

	public List<Proyectos> seleccionar();
	public int insertar(Proyectos proyectos);
	public int actualizar(Proyectos proyectos);
	public int eliminar(Proyectos proyectos);
}
