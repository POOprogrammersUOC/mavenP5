package com.proogramers.uoc.P5;

 
@XmlRootElement(name="Empleados")
@XmlType(propOrder = {"Nombre", "Apellidos", "Direccion", "Telefono", "DNI")
public class Empleados {

	private String Nombre;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	private String DNI;
	/**
	 * @param nombre Nombre del empleado
	 * @param apellidos Apellidos del empleado
	 * @param direccion Direcci�n del empleado
	 * @param telefono Telefono del empleado
	 * @param dNI DNI del empleado
	 */
	public Empleados(String nombre, String apellidos, String direccion, String telefono, String dNI) {
		Nombre = nombre;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
		DNI = dNI;
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
		return "Empleados [Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion + ", Telefono="
				+ Telefono + ", DNI=" + DNI + "]";
	}
	
	
}
