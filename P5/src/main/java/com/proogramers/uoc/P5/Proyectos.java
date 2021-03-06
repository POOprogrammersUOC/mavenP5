package com.proogramers.uoc.P5;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.Date;

import javax.persistence.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/*
 * 
 * Etiquetas XML
 * 
 * @XmlRootElement indica la raiz del xml
 * @XmlAccessorType(XmlAccessType.PUBLIC_MEMBER) Indica que tiene acceso p�blico
 * @XmlType(propOrder = {}) indica el orden para mostrar las etiquetas
 * @version 1.0 Creacion de clase
 * @version 1.1 Implementación de XML
 * @version 1.2 Implementación SQL
 * @version 1.3 implementacion JPA
 * 
 */

@XmlRootElement
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)

@XmlType(propOrder = { "numProyecto", "pais", "localizacion", "lineaDeAccion", "sublineaDeAccion", "fechaInicio",
		"fechaFinal", "socioLocal", "financiador", "financiacion", "acciones", "personal", "voluntariosAsignados","ongCif" })

@Entity
public class Proyectos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "Pais")
	private String pais;
	
	@Column(name = "Localizacion")
	private String localizacion;
	
	@Column(name = "LineaDeAccion")
	private String lineaDeAccion;
	
	@Column(name = "SublineaDeAccion")
	private String sublineaDeAccion;
	
	@Column(name = "FechaInicio")
	private LocalDate fechaInicio;
	
	@Column(name = "FechaFinal")
	private LocalDate fechaFinal;
	
	@Column(name = "SocioLocal")
	private String socioLocal;
	
	@Column(name = "Financiador")
	private String financiador;
	
	@Column(name = "Financiacion")
	private Double financiacion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_proyecto")
	private int numProyecto;
	
	@Column(name = "Acciones")
	private String acciones;
	
	@Column(name = "Personal")
	private int personal;
	
	@Column(name = "VoluntariosAsignados")
	private int voluntariosAsignados;
	
	@Column(name = "Ong_CIF")
	private String ongCif;							//se añade para la inserción en sql
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

		this.pais = pais;
		this.localizacion = localizacion;
		this.lineaDeAccion = lineaDeAccion;
		this.sublineaDeAccion = sublineaDeAccion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.socioLocal = socioLocal;
		this.financiador = financiador;
		this.financiacion = financiacion;
		this.numProyecto = ++contador;
		this.acciones = acciones;
		this.personal = personal;
		this.voluntariosAsignados = voluntariosAsignados;
	}

	///
	// Sobrecarga de constructores para las diferentes peticiones desde SQL
	///

	// Constructor para modificar desde SQL
	public Proyectos(String pais, String localizacion, String lineaDeAccion, String sublineaDeAccion,
			LocalDate fechaInicio, LocalDate fechaFinal, String socioLocal, String financiador, Double financiacion,
			int numProyecto, String acciones, int personal, int voluntariosAsignados, String ongCif) {
		this.pais = pais;
		this.localizacion = localizacion;
		this.lineaDeAccion = lineaDeAccion;
		this.sublineaDeAccion = sublineaDeAccion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.socioLocal = socioLocal;
		this.financiador = financiador;
		this.financiacion = financiacion;
		this.numProyecto = numProyecto;
		this.acciones = acciones;
		this.personal = personal;
		this.voluntariosAsignados = voluntariosAsignados;
		this.ongCif = ongCif;
	}

	// Constructor para eliminar desde SQL
	public Proyectos(int numProyecto) {
		this.numProyecto = numProyecto;
	}

	// constructor para insertar desde SQL
	public Proyectos(String pais, String localizacion, String lineaDeAccion, String sublineaDeAccion,
			LocalDate fechaInicio, LocalDate fechaFinal, String socioLocal, String financiador, Double financiacion,
			String acciones, int personal, int voluntariosAsignados, String ongCif) {
		this.pais = pais;
		this.localizacion = localizacion;
		this.lineaDeAccion = lineaDeAccion;
		this.sublineaDeAccion = sublineaDeAccion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.socioLocal = socioLocal;
		this.financiador = financiador;
		this.financiacion = financiacion;
		this.acciones = acciones;
		this.personal = personal;
		this.voluntariosAsignados = voluntariosAsignados;
		this.ongCif = ongCif;
	}

	public Proyectos() {
		super();
	}

	/**
	 * @return Devuelve el pais
	 */
	@XmlElement
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais Establece el pais
	 */
	// @XmlElement(name = "Pais")
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return Devuelve la localizacion
	 */
	@XmlElement
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion Establece la localizacion
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return Devuelve la lineaDeAccion
	 */
	@XmlElement
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
	@XmlElement
	public String getSublineaDeAccion() {
		return sublineaDeAccion;
	}

	/**
	 * @param sublineaDeAccion Establece la sublineaDeAccion
	 */
	public void setSublineaDeAccion(String sublineaDeAccion) {
		this.sublineaDeAccion = sublineaDeAccion;
	}

	/**
	 * @return Devuelve fechaInicio
	 */
	@XmlElement
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio Establece la fechaInicio
	 */
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return Devuelve fechaFinal
	 */
	@XmlElement
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal Establece la fechaFinal
	 */
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * @return Devuelve socioLocal
	 */
	@XmlElement
	public String getSocioLocal() {
		return socioLocal;
	}

	/**
	 * @param socioLocal Establece el socioLocal
	 */
	public void setSocioLocal(String socioLocal) {
		this.socioLocal = socioLocal;
	}

	/**
	 * @return Devuelve el financiador
	 */
	@XmlElement
	public String getFinanciador() {
		return financiador;
	}

	/**
	 * @param financiador Establece el financiador
	 */
	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}

	/**
	 * @return Devuelve la financiacion
	 */
	@XmlElement
	public Double getFinanciacion() {
		return financiacion;
	}

	/**
	 * @param financiacion Establece la financiacion
	 */
	public void setFinanciacion(Double financiacion) {
		this.financiacion = financiacion;
	}

	/**
	 * @return Devuelve el numProyecto
	 */
	@XmlElement
	public int getNumProyecto() {
		return numProyecto;
	}

	/**
	 * @param numProyecto Establece el numProyecto
	 */
	public void setNumProyecto(int numProyecto) {
		this.numProyecto = numProyecto;
	}

	/**
	 * @return Devuelve las acciones
	 */
	@XmlElement
	public String getAcciones() {
		return acciones;
	}

	/**
	 * @param acciones Establece las acciones
	 */
	public void setAcciones(String acciones) {
		this.acciones = acciones;
	}

	/**
	 * @return Devuelve el personal
	 */
	@XmlElement
	public int getPersonal() {
		return personal;
	}

	/**
	 * @param personal Establece el personal
	 */
	public void setPersonal(int personal) {
		this.personal = personal;
	}

	/**
	 * @return Devuelve los voluntariosAsignados
	 */
	@XmlElement
	public int getVoluntariosAsignados() {
		return voluntariosAsignados;
	}

	/**
	 * @param voluntariosAsignados Establece los voluntariosAsignados
	 */
	public void setVoluntariosAsignados(int voluntariosAsignados) {
		this.voluntariosAsignados = voluntariosAsignados;
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

	@Override
	public String toString() {
		return "Proyectos [Pais=" + pais + ", Localizacion=" + localizacion + ", lineaDeAccion=" + lineaDeAccion
				+ ", SublineaDeAccion=" + sublineaDeAccion + ", FechaInicio=" + fechaInicio + ", FechaFinal="
				+ fechaFinal + ", SocioLocal=" + socioLocal + ", Financiador=" + financiador + ", Financiacion="
				+ financiacion + ", NumProyecto=" + numProyecto + ", Acciones=" + acciones + ", Personal=" + personal
				+ ", VoluntariosAsignados=" + voluntariosAsignados + "]";
	}

}
