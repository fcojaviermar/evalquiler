package com.evalquiler.actionforms.encuesta;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;


public class RespuestasEncuestaActionForm extends ActionForm {

	private Date fechaInicio = null;
	private Date fechaFin = null;
	private Date fechaRealizacion = null;
	private DatosUsuarioActionForm  datosUsuario  = null;
	private DatosViviendaActionForm datosVivienda = null;
	private DatosEncuestaActionForm datosEncuesta = null;

	
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


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}


	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public DatosEncuestaActionForm getDatosEncuesta() {
		return datosEncuesta;
	}


	public void setDatosEncuesta(DatosEncuestaActionForm datosEncuesta) {
		this.datosEncuesta = datosEncuesta;
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