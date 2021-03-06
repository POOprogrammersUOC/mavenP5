package DAO;

import java.sql.SQLException;
import java.util.List;

import com.proogramers.uoc.P5.Socios;

public interface ISociosSQLDAO {

	public List<Socios> seleccionar() throws SQLException;
	public int insertar(Socios socios) throws SQLException;
	public int actualizar(Socios socios) throws SQLException;
	public int eliminar(Socios socios) throws SQLException;
}
