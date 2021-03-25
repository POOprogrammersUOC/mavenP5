package com.proogramers.uoc.P5;

import java.time.LocalDate;

public class AccionHumanitaria extends Proyectos {

	/**
	 * @param pais Pais donde se realiza el proyecto
	 * @param localizacion Localizaci�n donde se realiza el proyecto
	 * @param lineaDeAccion L�nea de acci�n
	 * @param sublineaDeAccion Sub l�ea de acci�n
	 * @param fechaInicio Fecha de inicio
	 * @param fechaFinal Fecha final
	 * @param socioLocal Socio local
	 * @param financiador Persona financiadora
	 * @param financiacion Financiaci�n
	 * @param numProyecto N�mero del proyecto
	 * @param acciones Acciones para el proyecto
	 * @param personal Personal para el proyecto
	 * @param voluntariosAsignados Voluntarios para el proyecto
	 */
	public AccionHumanitaria(String pais, String localizacion, String lineaDeAccion, String sublineaDeAccion,
			LocalDate fechaInicio, LocalDate fechaFinal, String socioLocal, String financiador, Double financiacion,
			String acciones, int personal, int voluntariosAsignados) {
		super(pais, localizacion, lineaDeAccion, sublineaDeAccion, fechaInicio, fechaFinal, socioLocal, financiador,
				financiacion, acciones, personal, voluntariosAsignados);
		// TODO Esbozo de constructor generado autom�ticamente
	}

	

}
