package com.proogramers.uoc.P5;

import java.time.LocalDate;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



/**
 * 
 * Etiquetas XML
 * 
 * @XmlRootElement indica la raiz del xml
 * @XmlAccessorType(XmlAccessType.PUBLIC_MEMBER) Indica que tiene acceso p�blico
 * @XmlType(propOrder = {}) indica el orden para mostrar las etiquetas
 * @version 1.1
 * 
 */

@XmlRootElement
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(propOrder = { "NumeroProyecto", "Pais", "Localizacion", "lineaDeAccion", "SublineaDeAccion", "FechaInicio",
		"FechaFinal", "SocioLocal", "Financiador", "Financiacion", "Acciones", "Personal", "VoluntariosAsignados" })

public class Proyectos {

	private String Pais;
	private String Localizacion;
	private String lineaDeAccion;
	private String SublineaDeAccion;
	private LocalDate FechaInicio;
	private LocalDate FechaFinal;
	private String SocioLocal;
	private String Financiador;
	private Double Financiacion;
	private int NumProyecto;
	private String Acciones;
	private int Personal;
	private int VoluntariosAsignados;
	private static int contador = 0;

	/**
	 * @param pais                 Pais donde se realiza el proyecto
	 * @param localizacion         Localizaci�n donde se realiza el proyecto
	 * @param lineaDeAccion        L�nea de acci�n
	 * @param sublineaDeAccion     Sub l�ea de acci�n
	 * @param fechaInicio          Fecha de inicio
	 * @param fechaFinal           Fecha final
	 * @param socioLocal           Socio local
	 * @param financiador          Persona financiadora
	 * @param financiacion         Financiaci�n
	 * @param numProyecto          N�mero del proyecto
	 * @param acciones             Acciones para el proyecto
	 * @param personal             Personal para el proyecto
	 * @param voluntariosAsignados Voluntarios para el proyecto
	 * @param contador             inicia n�mero de proyecto a 0 para incrementar
	 *                             cuando se agrega
	 */

	public Proyectos(String pais, String localizacion, String lineaDeAccion, String sublineaDeAccion,
			LocalDate fechaInicio, LocalDate fechaFinal, String socioLocal, String financiador, Double financiacion,
			String acciones, int personal, int voluntariosAsignados) {
		
		super();
		Pais = pais;
		Localizacion = localizacion;
		this.lineaDeAccion = lineaDeAccion;
		SublineaDeAccion = sublineaDeAccion;
		FechaInicio = fechaInicio;
		FechaFinal = fechaFinal;
		SocioLocal = socioLocal;
		Financiador = financiador;
		Financiacion = financiacion;
		NumProyecto = ++contador;
		Acciones = acciones;
		Personal = personal;
		VoluntariosAsignados = voluntariosAsignados;
	}

	/**
	 * 
	 */
	public Proyectos() {
		super();
	}

	/**
	 * @return Devuelve el pais
	 */
	//@XmlElement(name = "Pais")
	public String getPais() {
		return Pais;
	}

	/**
	 * @param pais Establece el pais
	 */
	public void setPais(String pais) {
		Pais = pais;
	}

	/**
	 * @return Devuelve la localizacion
	 */
	//@XmlElement(name = "Localizacion")
	public String getLocalizacion() {
		return Localizacion;
	}

	/**
	 * @param localizacion Establece la localizacion
	 */
	public void setLocalizacion(String localizacion) {
		Localizacion = localizacion;
	}

	/**
	 * @return Devuelve la lineaDeAccion
	 */
	//@XmlElement(name = "LineaDeAccion")
	public String getLineaDeAccion() {
		return lineaDeAccion;
	}

	/**
	 * @param lineaDeAccion Establece la lineaDeAccion
	 */
	public void setLineaDeAccion(String lineaDeAccion) {
		this.lineaDeAccion = lineaDeAccion;
	}

	/**
	 * @return Devuelve la sublineaDeAccion
	 */
	//@XmlElement(name = "SubLineaDeAccion")
	public String getSublineaDeAccion() {
		return SublineaDeAccion;
	}

	/**
	 * @param sublineaDeAccion Establece la sublineaDeAccion
	 */
	public void setSublineaDeAccion(String sublineaDeAccion) {
		SublineaDeAccion = sublineaDeAccion;
	}

	/**
	 * @return Devuelve fechaInicio
	 */
	//@XmlElement(name = "FechaInicio")
	public LocalDate getFechaInicio() {
		return FechaInicio;
	}

	/**
	 * @param fechaInicio Establece la fechaInicio
	 */
	 @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public void setFechaInicio(LocalDate fechaInicio) {
		FechaInicio = fechaInicio;
	}

	/**
	 * @return Devuelve fechaFinal
	 */
	//@XmlElement(name = "FechaFinal")
	public LocalDate getFechaFinal() {
		return FechaFinal;
	}

	/**
	 * @param fechaFinal Establece la fechaFinal
	 */
	 @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public void setFechaFinal(LocalDate fechaFinal) {
		FechaFinal = fechaFinal;
	}

	/**
	 * @return Devuelve socioLocal
	 */
	//@XmlElement(name = "SocioLocal")
	public String getSocioLocal() {
		return SocioLocal;
	}

	/**
	 * @param socioLocal Establece el socioLocal
	 */
	public void setSocioLocal(String socioLocal) {
		SocioLocal = socioLocal;
	}

	/**
	 * @return Devuelve el financiador
	 */
	//@XmlElement(name = "Financiador")
	public String getFinanciador() {
		return Financiador;
	}

	/**
	 * @param financiador Establece el financiador
	 */
	public void setFinanciador(String financiador) {
		Financiador = financiador;
	}

	/**
	 * @return Devuelve la financiacion
	 */
	//@XmlElement(name = "Financiacion")
	public Double getFinanciacion() {
		return Financiacion;
	}

	/**
	 * @param financiacion Establece la financiacion
	 */
	public void setFinanciacion(Double financiacion) {
		Financiacion = financiacion;
	}

	/**
	 * @return Devuelve el numProyecto
	 */
	//@XmlElement(name = "NumeroProyecto")
	public int getNumProyecto() {
		return NumProyecto;
	}

	/**
	 * @param numProyecto Establece el numProyecto
	 */
	public void setNumProyecto(int numProyecto) {
		NumProyecto = numProyecto;
	}

	/**
	 * @return Devuelve las acciones
	 */
	//@XmlElement(name = "Acciones")
	public String getAcciones() {
		return Acciones;
	}

	/**
	 * @param acciones Establece las acciones
	 */
	public void setAcciones(String acciones) {
		Acciones = acciones;
	}

	/**
	 * @return Devuelve el personal
	 */
	//@XmlElement(name = "Personal")
	public int getPersonal() {
		return Personal;
	}

	/**
	 * @param personal Establece el personal
	 */
	public void setPersonal(int personal) {
		Personal = personal;
	}

	/**
	 * @return Devuelve los voluntariosAsignados
	 */
	//@XmlElement(name = "VoluntariosAsignados")
	public int getVoluntariosAsignados() {
		return VoluntariosAsignados;
	}

	/**
	 * @param voluntariosAsignados Establece los voluntariosAsignados
	 */
	public void setVoluntariosAsignados(int voluntariosAsignados) {
		VoluntariosAsignados = voluntariosAsignados;
	}

	@Override
	public String toString() {
		return "Proyectos [Pais=" + Pais + ", Localizacion=" + Localizacion + ", lineaDeAccion=" + lineaDeAccion
				+ ", SublineaDeAccion=" + SublineaDeAccion + ", FechaInicio=" + FechaInicio + ", FechaFinal="
				+ FechaFinal + ", SocioLocal=" + SocioLocal + ", Financiador=" + Financiador + ", Financiacion="
				+ Financiacion + ", NumProyecto=" + NumProyecto + ", Acciones=" + Acciones + ", Personal=" + Personal
				+ ", VoluntariosAsignados=" + VoluntariosAsignados + "]";
	}

}
