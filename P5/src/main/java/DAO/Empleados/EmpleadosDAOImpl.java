package DAO.jordi;

import java.util.List;

import com.proogramers.uoc.P5.Socios;

public interface SociosDAO {

	List<Socios> mostrarTodos();
	Socios mostrarId(Socios socios);
	void añadir(Socios socios);
	void actualizar(Socios socios);
	void suprimir(int idsocio);
	
	
}
