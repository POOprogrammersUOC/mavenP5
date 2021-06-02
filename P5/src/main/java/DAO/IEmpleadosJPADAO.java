package DAO;

import java.util.List;

import com.proogramers.uoc.P5.Empleados;

public interface IEmpleadosJPADAO {
	
	public List<Empleados> seleccionar(); 
	public void persist(Empleados empleados); 
	public void actualizar(Empleados empleados); 
	public void eliminar(Integer id); 
	public Empleados leerId(Integer id);

}
