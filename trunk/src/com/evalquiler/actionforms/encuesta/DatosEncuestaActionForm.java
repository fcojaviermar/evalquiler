package com.evalquiler.actionforms.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class DatosEncuestaActionForm extends ActionForm {

	private String idEncuesta = null;
	private String quienContesta = null;
	
	public String getQuienContesta() {
		return quienContesta;
	}


	public void setQuienContesta(String quienContesta) {
		this.quienContesta = quienContesta;
	}


	private Collection<PreguntasEncuestaActionForm> preguntas = null;
	
	public String getIdEncuesta() {
		return idEncuesta;
	}


	public void setIdEncuesta(String idEncuesta) {
		this.idEncuesta = idEncuesta;
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