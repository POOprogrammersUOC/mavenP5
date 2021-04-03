package com.proogramers.uoc.P5;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="socios")
@XmlType(propOrder={"nombre", "apellidos", "nSocio", "direccion", "telefono"})
  
public class Socios {

	private String Nombre;
	private String Apellidos;
	private int nSocio;
	private String Direccion;
	private String Telefono;
	
	/**
	 * @param nombre Nombre del socio
	 * @param apellidos Apellidos del socio
	 * @param nSocio N�mero de socio
	 * @param direccion direcci�n del socio
	 * @param telefono teleono del socio
	 */
	public Socios(String nombre, String apellidos, int nSocio, String direccion, String telefono) {
		Nombre = nombre;
		Apellidos = apellidos;
		this.nSocio = nSocio;
		Direccion = direccion;
		Telefono = telefono;
	}


	/**
	 * @return Devuelve Nombre del socio
	 */
	@XmlElement(name="nombre")
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
	@XmlElement(name="Apellidos")
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
	@XmlElement(name="nSocio")
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
	@XmlElement(name="Direccion")
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
	@XmlElement(name="Telefono")
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
	
	

	
	
}
