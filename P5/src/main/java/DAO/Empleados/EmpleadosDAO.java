package DAO.Empleados;

import java.util.List;

import com.proogramers.uoc.P5.Empleados;

public interface EmpleadosDAO {

	List<Empleados> mostrarTodos();
	Socios mostrarId(Empleados empleados);
	void añadir(Empleados empleados);
	void actualizar(Empleados empleados);
	void suprimir(int idempleado);
	
	
}
