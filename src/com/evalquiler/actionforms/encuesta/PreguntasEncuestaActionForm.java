package com.evalquiler.actionforms.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class PreguntasEncuestaActionForm extends ActionForm {

	private String idPregunta = null;
	private String descripcion = null;
	private Collection<RespuestasPreguntaActionForm> respuestas = null;
	//private String tipoRespuesta = null;	

	
	public String getIdPregunta() {
		return idPregunta;
	}



	public void setIdPregunta(String idPregunta) {
		this.idPregunta = idPregunta;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
	public Collection<RespuestasPreguntaActionForm> getRespuestas() {
		return respuestas;
	}



	public void setRespuestas(Collection<RespuestasPreguntaActionForm> respuestas) {
		this.respuestas = respuestas;
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