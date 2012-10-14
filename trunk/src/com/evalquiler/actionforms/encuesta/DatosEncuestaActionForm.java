package com.evalquiler.actionforms.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class DatosEncuestaActionForm extends ActionForm {

	private int idEncuesta 	 	 = 0;
	private String titulo	 	 = null;
	private String idTipoUsuario = null;
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


	public String getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(String idTipoUsuario) {
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
    	System.out.println("RespuestasEncuestaActionForm.validate()");
    	ActionErrors errors = null;
        
        return errors;
    }
    

}