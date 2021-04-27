package DAOMySQL;


	import java.sql.SQLException;
	import java.util.List;

	import com.proogramers.uoc.P5.Socios;

	public interface ISociosDAOSQL {

		
		public int insertar(Socios socios) throws SQLException;
		public int modificar(Socios socios) throws SQLException;
		public int eliminar(Socios socios) throws SQLException;
		public List<Socios> seleccionar() throws SQLException;
}
