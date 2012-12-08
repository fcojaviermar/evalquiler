package com.evalquiler.actionforms.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


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
    	ActionErrors errors = null;
        
        return errors;
    }
    

}