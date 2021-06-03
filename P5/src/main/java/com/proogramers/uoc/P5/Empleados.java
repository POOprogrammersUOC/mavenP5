package com.proogramers.uoc.P5;

import java.io.Serializable;

import javax.persistence.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Empleados")
@XmlType(propOrder = {"Numero", "Nombre", "Apellidos", "Direccion", "Telefono", "DNI"})

@Entity
public class Empleados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Numero")
	private int Numero;
	
	@Column(name="Apellido_1")
	private String Apellidos;
	
	@Column(name="Direccion")
	private String Direccion;
	
	@Column(name="Telefono")
	private String Telefono;
	
	@Column(name="Dni")
	private String DNI;
	
	@Column(name="Ong_CIF")
	private String OngCif;
	
	/**
	 * @param nombre Nombre del empleado
	 * @param apellidos Apellidos del empleado
	 * @param direccion Direcci�n del empleado
	 * @param telefono Telefono del empleado
	 * @param dNI DNI del empleado
	 */
	public Empleados(String nombre, int numero, String apellidos, String direccion, String telefono, String dNI, String ongCif) {
		Nombre = nombre;
		Numero = numero;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
		DNI = dNI;
		OngCif = ongCif; 
	}
	public Empleados() {
		// TODO Esbozo de constructor generado automáticamente
	}
	
	//CONSTRUCTOR PARA METODO SELECCIONAR SQL
	
	public Empleados(int Numero, String Nombre, String Apellidos, String Direccion, String Telefono,
			String DNI, String OngCif) {
		
		this.Numero = Numero;
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.DNI = DNI;
		this.OngCif = OngCif;
	}
	
	//Constructor para eliminar en SQL
	
	public Empleados(int Numero) {
		this.Numero = Numero;
	}

	//Constructor para metodo insertar
	
	public Empleados(String Nombre,  String Apellidos, String Direccion, String Telefono,
			String DNI, String OngCif) {
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.DNI = DNI;
		this.OngCif = OngCif;		
		
	}
	
	//Constructor para actualizar Update SQL
	
	public Empleados(String Nombre, String Apellidos, String Direccion, String Telefono, String DNI, String OngCif,
			int Numero) {
		
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.DNI = DNI;
		this.OngCif = OngCif;
		this.Numero = Numero;
	}
	/**
	 * @return Devuelve Nombre del empleado
	 */
	@XmlElement(name= "Nombre")
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre Establece el nombre del empleado
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @return Devuelve Apellidos del empleado
	 */
	@XmlElement(name= "Apellidos")
	public String getApellidos() {
		return Apellidos;
	}
	/**
	 * @param apellidos Establece los apellidos del empleado
	 */
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	/**
	 * @return Devuelve Direcci�n del empleado
	 */
	@XmlElement(name= "Direccion")
	public String getDireccion() {
		return Direccion;
	}
	/**
	 * @param direccion Establece la direcci�n del empleado
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	/**
	 * @return Devuelve Telefono del empleado
	 */
	@XmlElement(name = "Telefono")
	public String getTelefono() {
		return Telefono;
	}
	/**
	 * @param telefono Establece telefono del empleado
	 */
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	/**
	 * @return Devuelve DNI del empleado
	 */
	@XmlElement(name= "DNI")
	public String getDNI() {
		return DNI;
	}
	/**
	 * @param dNI Establece DNi del empleado
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	@Override
	public String toString() {
		return "Empleados [Numero =" + Numero + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion + ", Telefono="
				+ Telefono + ", DNI=" + DNI + "]";
	}
	public int getNumero() {
		return Numero;
		
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public String getOngCif() {
		return OngCif;
	}
	
	public void setOngCif(String OngCif) {
		this.OngCif = OngCif;
	}
	
}
