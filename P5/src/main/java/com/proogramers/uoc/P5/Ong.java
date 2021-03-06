package com.proogramers.uoc.P5;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import java.util.InputMismatchException;

import java.util.Scanner;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Ong")
public class Ong {

	private String Nombre;
	private String Direccion;
	private String CIF;
	private String Pais;
	private String Telefono;
	private String Web;
	private String Email;
	private ArrayList<Empleados> ListaEmpleados;
	private ArrayList<Socios> ListaSocios;
	private ArrayList<Proyectos> ListaProyectos;

	/**
	 * @param listaEmpleados
	 * @param listaSocios
	 * @param listaProyectos
	 */
	public Ong() {

		ListaEmpleados = new ArrayList<>();
		ListaSocios = new ArrayList<>();
		ListaProyectos = new ArrayList<>();
	}

	/**
	 * @return Devuelve el nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre Establecer el nombre
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return Devuelve la dirección
	 */
	public String getDireccion() {
		return Direccion;
	}

	/**
	 * @param direccion Establecer la direccion
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	/**
	 * @return Devuelve el cIF
	 */
	public String getCIF() {
		return CIF;
	}

	/**
	 * @param cIF Establecer el cIF
	 */
	public void setCIF(String cIF) {
		CIF = cIF;
	}

	/**
	 * @return Devuelve el pais
	 */
	public String getPais() {
		return Pais;
	}

	/**
	 * @param pais Establecer el pais
	 */
	public void setPais(String pais) {
		Pais = pais;
	}

	/**
	 * @return Devuelve el telefono
	 */
	public String getTelefono() {
		return Telefono;
	}

	/**
	 * @param telefono Establecer el telefono
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	/**
	 * @return Devuelve la web
	 */
	public String getWeb() {
		return Web;
	}

	/**
	 * @param web Establecer la web
	 */
	public void setWeb(String web) {
		Web = web;
	}

	/**
	 * @return Devuelve el email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email Establecer el email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return Devuelve listaEmpleados
	 */
	public ArrayList<Empleados> getListaEmpleados() {
		return ListaEmpleados;
	}

	/**
	 * @param listaEmpleados Establecer listaEmpleados
	 */
	public void setListaEmpleados(ArrayList<Empleados> listaEmpleados) {
		ListaEmpleados = listaEmpleados;
	}

	/**
	 * @return Devuelve listaSocios
	 */
	public ArrayList<Socios> getListaSocios() {
		return ListaSocios;
	}

	/**
	 * @param listaSocios Establecer listaSocios
	 */
	public void setListaSocios(ArrayList<Socios> listaSocios) {
		ListaSocios = listaSocios;
	}

	/**
	 * @return Devuelve Lista Proyectos
	 */
	@XmlElement(name = "Proyectos")
	public ArrayList<Proyectos> getListaProyectos() {
		return ListaProyectos;
	}

	/**
	 * @param listaProyectos Establecer lista de proyectos
	 */
	// @XmlElement(name = "Proyectos")
	public void setListaProyectos(ArrayList<Proyectos> listaProyectos) {
		ListaProyectos = listaProyectos;
	}

	Scanner leer = new Scanner(System.in);

	public void addsocios() {

		ArrayList<Socios> NuevaListaSocios = this.getListaSocios();

		try {

			System.out.println("Introduce el nombre:");
			String nom = leer.nextLine();
			System.out.println("Introduce el apellido:");
			String ape = leer.nextLine();
			System.out.println("Introduce el numero de socio asignado:");
			int nsoc = leer.nextInt();
			leer.nextLine();
			System.out.println("Introduce la direccion:");
			String direc = leer.nextLine();
			leer.nextLine();
			System.out.println("Introduce el telefono:");
			String telf = leer.nextLine();

			Socios socios = new Socios(nom, ape, nsoc, direc, telf);
			NuevaListaSocios.add(socios);

		} catch (Exception e) {

			System.out.println("error");
		}

		for (Socios socios1 : NuevaListaSocios) {

			System.out.println("nombre: " + socios1.getNombre());
			System.out.println("apellidos: " + socios1.getApellidos());
			System.out.println("num. socio: " + socios1.getnSocio());
			System.out.println("direccion: " + socios1.getDireccion());
			System.out.println("telefono: " + socios1.getTelefono());
		}

	}

	public void ImprimirSocios() {

		ArrayList<Socios> NuevaListaSocios = this.getListaSocios();

		if (NuevaListaSocios.isEmpty()) {

			System.out.println("No hay socios creados\n");

		} else {

			for (Socios socios1 : NuevaListaSocios) {

				System.out.println("////////////////////////////////////////////////////");
				System.out.println("              LISTA DE SOCIOS");
				System.out.println("///////////////////////////////////////////////////");
				System.out.println("Nombre del socio: " + socios1.getNombre());
				System.out.println("Apellidos del socio: " + socios1.getApellidos());
				System.out.println("Número de socio: " + socios1.getnSocio());
				System.out.println("Dirección: " + socios1.getDireccion());
				System.out.println("Telefono: " + socios1.getTelefono());
			}

		}
	}

	public void EliminarSocio() {

		ArrayList<Socios> EliminarListaSocios = this.getListaSocios();

		if (EliminarListaSocios.isEmpty()) {
			System.out.println("No hay socios a eliminar\n");
		} else {

			for (int i = 0; i < EliminarListaSocios.size(); i++) {

				System.out.println("Número de socio: " + EliminarListaSocios.get(i).getnSocio());
			}
			try {
				System.out.println("¿Que socio quiere eliminar? Indique la posición: ");
				int eliminar = leer.nextInt();
				leer.nextLine();
				EliminarListaSocios.remove(eliminar - 1);
			} catch (Exception e) {
				System.out.println("El valor introducido no se encuentra en la lista\n");
			}
		}

	}

	/**
	 * Función añadir proyecto
	 * 
	 * @author Isaac Tutusaus
	 * @version 1.0
	 * 
	 */

	public void AddProyectos() {

		ArrayList<Proyectos> NuevaListaProyectos = this.getListaProyectos(); // Creamos un arrayList de proyectos para
																				// que recoja los proyectos con la
																				// NuevaListaProyectos

		try { // Aplicamos el try catch porque parseamos las fechas, doubles y enteros

			System.out.println("Introduzca el Pais: "); // Pedimos los datos de todos los atributos de la clase
														// proyectos
			String Pais = leer.nextLine();
			System.out.println("Introduzca la Localización: ");
			String Localizacion = leer.nextLine();
			System.out.println("Introduzca la línea de acción: ");
			String LineaDeAccion = leer.nextLine();
			System.out.println("Introduzca la sub línea de acción: ");
			String SublineaDeAccion = leer.nextLine();
			System.out.println("Introduzca la fecha de inicio del proyecto con el formato [YYYY-MM-DD]: ");
			String FechaInicio = leer.nextLine();
			System.out.println("Introduzca la fecha final del proyecto con el formato [YYYY-MM-DD]: ");
			String FechaFinal = leer.nextLine();
			LocalDate fInicio = LocalDate.parse(FechaInicio); // parseamos la fecha
			LocalDate fFinal = LocalDate.parse(FechaFinal);

			while (fFinal.isBefore(fInicio)) { // Mientras la fecha final sea antes que la de inicio se preguntara de
												// nuevo
				System.out.println( // Nunca podrá ser 2021-03-15 de inicio y la fecha final 2021-02-15
						"La fecha no se valida o no se ha introducido correctamente, use el método [YYYY-MM-DD] ");
				System.out.println("Introduzca la fecha de inicio del proyecto: ");
				FechaInicio = leer.nextLine();
				System.out.println("Introduzca la fecha final del proyecto: ");
				FechaFinal = leer.nextLine();
				fInicio = LocalDate.parse(FechaInicio);
				fFinal = LocalDate.parse(FechaFinal);
			}

			System.out.println("Introduzca el Socio local: ");
			String SocioLocal = leer.nextLine();
			System.out.println("Indique el financiador: ");
			String Financiador = leer.nextLine();
			System.out.println("Cantidad a financiar: ");
			Double Financiacion = leer.nextDouble();
			leer.nextLine();
			System.out.println("Acciones: ");
			String Acciones = leer.nextLine();
			System.out.println("Indicar Nº de personas del proyecto: ");
			int Personal = leer.nextInt();
			leer.nextLine(); // Estamos obligados a ponerla para que no interprete un valor
			System.out.println("Indicar Nº de personal voluntario: ");
			int VoluntariosAsignados = leer.nextInt();
			leer.nextLine();

			Proyectos proyecto = new Proyectos(Pais, Localizacion, LineaDeAccion, SublineaDeAccion, fInicio, fFinal, // finalmente
																														// creamos
																														// el
																														// objeto
					SocioLocal, Financiador, Financiacion, Acciones, Personal, VoluntariosAsignados);
			NuevaListaProyectos.add(proyecto); // Añadimos los valores al ArrayList

		} catch (DateTimeParseException e) { // controlamos la excepción personalizada para la fecha
			System.out.println(
					"La fecha introducida no es correcta o no se corresponde con el formato indicado [YYYY-MM-DD]");

		} catch (InputMismatchException e) { // controlamos la excepción personalizada para la introducción de string en
												// variables enteras o double
			System.out.println("El valor introducido no es númerico.\n");
			// AddProyectos();
		}

	}

	/**
	 * Función Imprimir proyecto
	 * 
	 * @author Isaac Tutusaus
	 * @version 1.0
	 * 
	 */

	public void ImprimirProyectos() {

		ArrayList<Proyectos> NuevaListaProyectos = this.getListaProyectos(); // Creamos un arrayList de proyectos para
																				// poder recorrer la lista

		if (NuevaListaProyectos.isEmpty()) { // Sí no hay proyectos en la ArrayList, se informa

			System.out.println("No hay proyectos creados\n");

		} else {

			for (Proyectos proyectos : NuevaListaProyectos) { // recorremos la lista con un forEach y mostramos el
																// contenido
				System.out.println("***************************************************");
				System.out.println("              LISTADO DE PROYECTOS");
				System.out.println("***************************************************");
				System.out.println("Código del proyecto: " + proyectos.getNumProyecto());
				System.out.println("Pais: " + proyectos.getPais());
				System.out.println("Localización: " + proyectos.getLocalizacion());
				System.out.println("Línea de acción: " + proyectos.getLineaDeAccion());
				System.out.println("Sublínea de acción: " + proyectos.getSublineaDeAccion());
				System.out.println("Fecha de inicio: " + proyectos.getFechaInicio());
				System.out.println("Fecha final: " + proyectos.getFechaFinal());
				System.out.println("Socio local: " + proyectos.getSocioLocal());
				System.out.println("Financiador: " + proyectos.getFinanciador());
				System.out.println("Financiación aportada: " + proyectos.getFinanciacion());
				System.out.println("Acciones a realizar: " + proyectos.getAcciones());
				System.out.println("Personal: " + proyectos.getPersonal());
				System.out.println("Voluntarios asignados: " + proyectos.getVoluntariosAsignados());
				System.out.println("");

			}
		}
	}

	public void EliminarProyecto() {

		ArrayList<Proyectos> EliminarListaProyectos = this.getListaProyectos();

		if (EliminarListaProyectos.isEmpty()) {
			System.out.println("No hay lista de proyectos a eliminar\n");
		} else {

			for (int i = 0; i < EliminarListaProyectos.size(); i++) {

				System.out.println("Código del proyecto: " + EliminarListaProyectos.get(i).getNumProyecto());
			}
			try {
				System.out.println("¿Que proyecto quiere eliminar? Indique el número: ");
				int eliminar = leer.nextInt();
				leer.nextLine();
				EliminarListaProyectos.remove(eliminar - 1); // Hay que ponerle un try catch IndexOutOfBoundsException
																// fuera de indice
			} catch (Exception e) {
				System.out.println("El valor introducido no se encuentra en la lista\n");
			}
		}

	}

	public void AgregarEmpleado() { // Este metodo pide los datos de un empleado, y los agrega en array a la lista
									// de empleados

		ArrayList<Empleados> NuevaListaEmpleados = this.getListaEmpleados(); // Se crea un arrayList de empleados para
																				// poder recorrer la lista

		System.out.println("Introduce nombre");

		String Nombre = leer.nextLine();

		System.out.println("Introduce apellido");

		String Apellidos = leer.nextLine();

		System.out.println("Introduce numero");

		int Numero = leer.nextInt();

		leer.nextLine();

		System.out.println("Introduce direccion");

		String Direccion = leer.nextLine();

		System.out.println("Introduce telefono");

		String Telefono = leer.nextLine();

		System.out.println("Introduce dni");

		String DNI = leer.nextLine();
		
		String OngCif = leer.nextLine();

		Empleados empleado = new Empleados(Nombre, Numero, Apellidos, Direccion, Telefono, DNI, OngCif);
		NuevaListaEmpleados.add(empleado);

	}

	public void imprimirEmpleados() { // Imprime por consola los datos de empleado del array

		ArrayList<Empleados> NuevaListaEmpleados = this.getListaEmpleados();

		for (Empleados aux : NuevaListaEmpleados) {
			System.out.println("***************************************************");
			System.out.println("              LISTADO DE EMPLEADOS ");
			System.out.println("***************************************************");
			System.out.println(" Hay " + NuevaListaEmpleados.size() + " empleados almacenados.");
			System.out.println("Nombre del empleado: " + aux.getNombre());
			System.out.println("Apellidos del empleado: " + aux.getApellidos());
			System.out.println("DNI del empleado: " + aux.getDNI());
			System.out.println("Direccion del empleado: " + aux.getDireccion());

		}

	}

	public void EliminarEmpleado() { // Busca el nombre ingrsado en el array de empleados y lo elimina de este

		ArrayList<Empleados> EliminarListaEmpleados = this.getListaEmpleados();

		if (EliminarListaEmpleados.isEmpty()) {
			System.out.println("No hay empleados a eliminar\n");
		} else {

			for (int i = 0; i < EliminarListaEmpleados.size(); i++) {

				System.out.println("Nombre del empleado: " + EliminarListaEmpleados.get(i).getNumero());
			}
			try {
				System.out.println("Indique el numero del empleado a eliminar: ");
				int eliminar = leer.nextInt();

				EliminarListaEmpleados.remove(eliminar - 1);

			} catch (Exception e) {
				System.out.println("El empleado no se encuentra en la lista\n");
			}
		}

	}

	public void getListaSocios(String string) {
		// TODO Auto-generated method stub

	}
}
