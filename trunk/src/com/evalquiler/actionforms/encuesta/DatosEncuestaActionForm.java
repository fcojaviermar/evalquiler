package com.evalquiler.actionforms.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;
import com.evalquiler.excepciones.vivienda.ViviendaNoSeleccionadaExcepcion;


public class DatosEncuestaActionForm extends ActionForm {

	private int    idEncuesta 	 				 = 0;
	private String titulo	 					 = null;
	private int    idTipoUsuario 				 = 0;  // O va aquí o va en la clase RespuestasEncuestaActionForm

	private Collection<PreguntasEncuestaActionForm> preguntas = null;
	
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getIdEncuesta() {
		return idEncuesta;
	}


	public void setIdEncuesta(int idEncuesta) {
		this.idEncuesta = idEncuesta;
	}


	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}


	public Collection<PreguntasEncuestaActionForm> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(Collection<PreguntasEncuestaActionForm> preguntas) {
		this.preguntas = preguntas;
	}


	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("DatosEncuestaActionForm.validate()");
    	ActionErrors errors = new ActionErrors();

        try {
        	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
        	if ( (!ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) &&
        		 (!ConstantesBotones.CANCELAR.equals(botonPulsado)) && 
        		 (!ConstantesBotones.NUEVA_VIVIENDA.equals(botonPulsado)) ){
        		getViviendaSeleccionada(request);
        	}
		} catch (ViviendaNoSeleccionadaExcepcion e) {
			errors.add("errorValidacion", new ActionError("error.vivienda.obligatoria"));
		}
    	
        return errors;
    }
    
    
    public static final String getViviendaSeleccionada(HttpServletRequest request) throws ViviendaNoSeleccionadaExcepcion {
		String idVivienda = (String)request.getParameter("idVivienda");
		if (null == idVivienda) {
			//En este caso se viene cuando se ha dado de alta una vivienda de forma correcta.
			idVivienda = (String)request.getAttribute("idVivienda");
		}
		if (null == idVivienda) {
			throw new ViviendaNoSeleccionadaExcepcion();
		}
		
		UtilidadesFicheros.escribir("idVivienda: " + idVivienda);
		return idVivienda;
    }
    

}