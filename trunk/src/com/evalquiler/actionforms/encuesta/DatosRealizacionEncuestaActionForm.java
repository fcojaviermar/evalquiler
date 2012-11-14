package com.evalquiler.actionforms.encuesta;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.utilidades.UtilidadesFechas;


public class DatosRealizacionEncuestaActionForm extends ActionForm {

	private String fechaInicioEvaluacionAlquiler = null;
	private String fechaFinEvaluacionAlquiler    = null;
	private String fechaRealizacion 		     = null;
	
	private DatosUsuarioActionForm  datosUsuario  = null;
	private DatosViviendaActionForm datosVivienda = null;
	private DatosEncuestaActionForm	datosEncuesta = null;
	
	
	
	public DatosEncuestaActionForm getDatosEncuesta() {
		return datosEncuesta;
	}


	public void setDatosEncuesta(DatosEncuestaActionForm datosEncuesta) {
		this.datosEncuesta = datosEncuesta;
	}


	public DatosUsuarioActionForm getDatosUsuario() {
		return datosUsuario;
	}


	public void setDatosUsuario(DatosUsuarioActionForm datosUsuario) {
		this.datosUsuario = datosUsuario;
	}


	public DatosViviendaActionForm getDatosVivienda() {
		return datosVivienda;
	}


	public void setDatosVivienda(DatosViviendaActionForm datosVivienda) {
		this.datosVivienda = datosVivienda;
	}


	public String getFechaInicioEvaluacionAlquiler() {
		return UtilidadesFechas.dateSqlToString(fechaInicioEvaluacionAlquiler);
	}


	public void setFechaInicioEvaluacionAlquiler(String fechaInicioEvaluacionAlquiler) {
		this.fechaInicioEvaluacionAlquiler = fechaInicioEvaluacionAlquiler;
	}


	public String getFechaFinEvaluacionAlquiler() {
		return UtilidadesFechas.dateSqlToString(fechaFinEvaluacionAlquiler);
	}


	public void setFechaFinEvaluacionAlquiler(String fechaFinEvaluacionAlquiler) {
		this.fechaFinEvaluacionAlquiler = fechaFinEvaluacionAlquiler;
	}


	public String getFechaRealizacion() {
		return UtilidadesFechas.dateSqlToString(fechaRealizacion);
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