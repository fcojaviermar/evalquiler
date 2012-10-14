package com.evalquiler.actionforms.encuesta;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class RespuestasPreguntaActionForm extends ActionForm {

	private int idRespuesta = 0;
	private String descripcion = null;
	private int respuestaDada = 0;
	//private String tipoRespuesta = null;	

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getRespuestaDada() {
		return respuestaDada;
	}

	public void setRespuestaDada(int respuestaDada) {
		this.respuestaDada = respuestaDada;
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