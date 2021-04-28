package DAO;

import java.sql.SQLException;
import java.util.List;

import com.proogramers.uoc.P5.Proyectos;

public interface IProyectosSQLDAO {

	public List<Proyectos> seleccionar() throws SQLException;
	public int insertar(Proyectos proyectos) throws SQLException;
	public int actualizar(Proyectos proyectos) throws SQLException;
	public int eliminar(Proyectos proyectos) throws SQLException;
}
