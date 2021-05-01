package DAO;

import java.sql.SQLException;
import java.util.List;

import com.proogramers.uoc.P5.Empleados;

public interface IEmpleadosSQLDAO {
	
	public List<Empleados> seleccionar() throws SQLException;
	public int insertar(Empleados empleados) throws SQLException;
	public int actualizar(Empleados empleados) throws SQLException;
	public int eliminar(Empleados empleados) throws SQLException;

}
