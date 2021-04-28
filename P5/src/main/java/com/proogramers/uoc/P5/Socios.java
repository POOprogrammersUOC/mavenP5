package com.proogramers.uoc.P5;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "socios")
@XmlType(propOrder = { "nombre", "apellidos", "nSocio", "direccion", "telefono", "ongCif" })

public class Socios {

	private String Nombre;
	private String Apellidos;
	private int nSocio;
	private String Direccion;
	private String Telefono;
	private String ongCif;
	private static int contador = 0;

	/**
	 * @param nombre    Nombre del socio
	 * @param apellidos Apellidos del socio
	 * @param nSocio    Numero de socio
	 * @param direccion direccion del socio
	 * @param telefono  telefono del socio
	 * @param contador  inicia numero de socio a 0 para incrementar
	 */
	public Socios(String nombre, String apellidos, int nSocio, String direccion, String telefono) {
		Nombre = nombre;
		Apellidos = apellidos;
		this.nSocio = ++contador;
		Direccion = direccion;
		Telefono = telefono;

	}

	// constructor para metodo modificar SQL

	public Socios(String nombre, String apellidos, int nSocio, String direccion, String telefono, String ongCif) {
		Nombre = nombre;
		Apellidos = apellidos;
		this.nSocio = nSocio;
		Direccion = direccion;
		Telefono = telefono;
		this.ongCif = ongCif;
	}

	// Constructor para eliminar desde SQL

	public Socios(int nSocio) {
		super();
		this.nSocio = nSocio;
	}

	// constructor para metodo insertar SQL

	public Socios(String nombre, String apellidos, String direccion, String telefono, String ongCif) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
		this.ongCif = ongCif;
	}

	public Socios() {
		super();
	}

	/**
	 * @return Devuelve Nombre del socio
	 */
	@XmlElement(name = "nombre")
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre Establece el nombre del socio
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * @return Devuelve apellidos del socio
	 */
	@XmlElement(name = "Apellidos")
	public String getApellidos() {
		return Apellidos;
	}

	/**
	 * @param apellidos Establece los apellidos del socio
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	/**
	 * @return Devuelve Numero del socio
	 */
	@XmlElement(name = "nSocio")
	public int getnSocio() {
		return nSocio;
	}

	/**
	 * @param nSocio Establece el numero de socio
	 */
	public void setnSocio(int nSocio) {
		this.nSocio = nSocio;
	}

	/**
	 * @return Devuelve direccion del socio
	 */
	@XmlElement(name = "Direccion")
	public String getDireccion() {
		return Direccion;
	}

	/**
	 * @param direccion Establece la direcci�n del socio
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	/**
	 * @return Devuelve telefono del socio
	 */
	@XmlElement(name = "Telefono")
	public String getTelefono() {
		return Telefono;
	}

	/**
	 * @param telefono Establece telefono del socio
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Socios [Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", nSocio=" + nSocio + ", Direccion="
				+ Direccion + ", Telefono=" + Telefono + "]";
	}

	public String getNumSocio() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	/**
	 * @return retorna el ongCif
	 */
	@XmlElement
	public String getOngCif() {
		return ongCif;
	}

	/**
	 * @param ongCif Establece el cif en la base de datos sql
	 */
	public void setOngCif(String ongCif) {
		this.ongCif = ongCif;

	}

}
