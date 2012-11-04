package com.evalquiler.actionforms.encuesta;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;


public class DatosRealizacionEncuestaActionForm extends ActionForm {

	private String fechaInicioEvaluacionAlquiler = null;
	private String fechaFinEvaluacionAlquiler    = null;
	private String fechaRealizacion 			   = null;
	
	private DatosInicioSesionActionForm  datosUsuario  = null;
	private DatosViviendaActionForm 	 datosVivienda = null;
	
	
	public DatosInicioSesionActionForm getDatosUsuario() {
		return datosUsuario;
	}


	public void setDatosUsuario(DatosInicioSesionActionForm datosUsuario) {
		this.datosUsuario = datosUsuario;
	}


	public DatosViviendaActionForm getDatosVivienda() {
		return datosVivienda;
	}


	public void setDatosVivienda(DatosViviendaActionForm datosVivienda) {
		this.datosVivienda = datosVivienda;
	}


	public String getFechaInicioEvaluacionAlquiler() {
		return fechaInicioEvaluacionAlquiler;
	}


	public void setFechaInicioEvaluacionAlquiler(String fechaInicioEvaluacionAlquiler) {
		this.fechaInicioEvaluacionAlquiler = fechaInicioEvaluacionAlquiler;
	}


	public String getFechaFinEvaluacionAlquiler() {
		return fechaFinEvaluacionAlquiler;
	}


	public void setFechaFinEvaluacionAlquiler(String fechaFinEvaluacionAlquiler) {
		this.fechaFinEvaluacionAlquiler = fechaFinEvaluacionAlquiler;
	}


	public String getFechaRealizacion() {
		return fechaRealizacion;
	}


	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
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