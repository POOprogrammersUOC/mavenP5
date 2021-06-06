package com.proogramers.uoc.P5;

import javax.xml.bind.annotation.*;
import javax.persistence.*;
import java.io.Serializable;

@XmlRootElement(name = "socios")
@XmlType(propOrder = { "nombre", "apellidos", "nSocio", "direccion", "telefono", "ongCif" })
@Entity


public class Socios implements Serializable {

private static final long serialVersionUID = 1L;
	
@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Apellido")
	private String Apellidos;
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSocios")
	private int nSocio;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@Column(name="Telefono")
	private String Telefono;
	
	@Column(name="Ong_CIF")
	private String ongCif;

	/**
	 * @param nombre    Nombre del socio
	 * @param apellidos Apellidos del socio
	 * @param nSocio    N�mero de socio
	 * @param direccion direcci�n del socio
	 * @param telefono  teleono del socio
	 */
	public Socios(String nombre, String apellidos, int nSocio, String direccion, String telefono) {
		Nombre = nombre;
		Apellidos = apellidos;
		this.nSocio = nSocio;
		Direccion = direccion;
		Telefono = telefono;
	}

	public Socios() {
		// TODO Esbozo de constructor generado automáticamente
	}

	// CONSTRUCTOR PARA METODO SELECCIONAR SQL
	public Socios(int nSocio, String Nombre, String Apellido, String Direccion, String Telefono, String OngCif) {

		this.nSocio = nSocio;
		this.Nombre = Nombre;
		this.Apellidos = Apellido;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.ongCif = OngCif;
	}

	// Constructor para eliminar en SQL

	public Socios(int nSocio) {
		this.nSocio = nSocio;
	}

	// Constructor para metodo insertar

	public Socios(String Nombre, String Apellidos, String Direccion, String Telefono, String OngCif) {
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.ongCif = OngCif;

	}

	// Metodo actualizar SQL

	public Socios(String nombre, String apellidos, int nSocio, String direccion, String telefono, String ongCif) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		this.nSocio = nSocio;
		Direccion = direccion;
		Telefono = telefono;
		this.ongCif = ongCif;
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
				+ Direccion + ", Telefono=" + Telefono + ", ongCif=" + ongCif + "]";
	}

	public int getNumSocio() {
		// TODO Esbozo de método generado automáticamente
		return nSocio;
	}

	@XmlElement(name = "OngCif")
	public String getOngCif() {
		// TODO Auto-generated method stub
		return ongCif;
	}

	/**
	 * @param ongCif Establece el cif en la base de datos sql
	 */
	public void setOngCif(String ongCif) {
		this.ongCif = ongCif;
	}

}
