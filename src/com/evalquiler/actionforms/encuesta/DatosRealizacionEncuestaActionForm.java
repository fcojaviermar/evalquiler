package com.evalquiler.actionforms.encuesta;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;


public class DatosRealizacionEncuestaActionForm extends ActionForm {

	private Date fechaInicioEvaluacionAlquiler = null;
	private Date fechaFinEvaluacionAlquiler    = null;
	private Date fechaRealizacion 			   = null;
	
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


	public Date getFechaInicioEvaluacionAlquiler() {
		return fechaInicioEvaluacionAlquiler;
	}


	public void setFechaInicioEvaluacionAlquiler(Date fechaInicioEvaluacionAlquiler) {
		this.fechaInicioEvaluacionAlquiler = fechaInicioEvaluacionAlquiler;
	}


	public Date getFechaFinEvaluacionAlquiler() {
		return fechaFinEvaluacionAlquiler;
	}


	public void setFechaFinEvaluacionAlquiler(Date fechaFinEvaluacionAlquiler) {
		this.fechaFinEvaluacionAlquiler = fechaFinEvaluacionAlquiler;
	}


	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}


	public void setFechaRealizacion(Date fechaRealizacion) {
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