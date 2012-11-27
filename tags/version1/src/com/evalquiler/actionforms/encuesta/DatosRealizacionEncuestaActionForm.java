package com.evalquiler.actionforms.encuesta;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.comun.constantes.ConstantesBotones;
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


	public String getFechaRealizacion() throws ParseException {
		return fechaRealizacion;
	}


	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	
	public String getFechaInicioEvaluacionAlquiler() {
		return fechaInicioEvaluacionAlquiler;
	}

	public String getFechaInicioEvaluacionAlquilerForSql() throws ParseException {
		return UtilidadesFechas.dateSqlToString(fechaInicioEvaluacionAlquiler);
	}

	public String getFechaInicioEvaluacionAlquilerToString() throws ParseException {
		return UtilidadesFechas.dateSqlToString(fechaInicioEvaluacionAlquiler);
	}

	public void setFechaInicioEvaluacionAlquiler(String fechaInicioEvaluacionAlquiler) {
		this.fechaInicioEvaluacionAlquiler = fechaInicioEvaluacionAlquiler;
	}


	public String getFechaFinEvaluacionAlquiler() {
		return fechaFinEvaluacionAlquiler;
	}

	public String getFechaFinEvaluacionAlquilerForSql() throws ParseException  {
		return UtilidadesFechas.dateSqlToString(fechaFinEvaluacionAlquiler);
	}

	public String getFechaFinEvaluacionAlquilerToString() throws ParseException  {
		return UtilidadesFechas.dateSqlToString(fechaFinEvaluacionAlquiler);
	}


	public void setFechaFinEvaluacionAlquiler(String fechaFinEvaluacionAlquiler) {
		this.fechaFinEvaluacionAlquiler = fechaFinEvaluacionAlquiler;
	}
	

	/*
     * Validamamos los datos introducidos por el usuario
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    	System.out.println("RespuestasEncuestaActionForm.validate()");
    	ActionErrors errors = new ActionErrors();

		String botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (!ConstantesBotones.CANCELAR.equals(botonPulsado)) {
    		if (null == this.getFechaInicioEvaluacionAlquiler()) {
    			errors.add("errorValidacion", new ActionError("error.fecha.inicio.evaluacion.obligatoria"));
    		}  else if (!UtilidadesFechas.tieneFormatoCorrecto(this.getFechaInicioEvaluacionAlquiler(), UtilidadesFechas.FORMATO_FECHA)) {
    			errors.add("errorValidacion", new ActionError("error.fecha.inicio.formato.incorrecto"));
    		}

        	if (null == this.getFechaFinEvaluacionAlquiler()) {
        		errors.add("errorValidacion", new ActionError("error.fecha.fin.evaluacion.obligatoria"));
        	} else if (!UtilidadesFechas.tieneFormatoCorrecto(this.getFechaFinEvaluacionAlquiler(), UtilidadesFechas.FORMATO_FECHA)) {
        		errors.add("errorValidacion", new ActionError("error.fecha.fin.formato.incorrecto"));
        	}

        	if (UtilidadesFechas.getDate(this.getFechaInicioEvaluacionAlquiler()).after(
        																	UtilidadesFechas.getDate(this.getFechaFinEvaluacionAlquiler()))) {
        		errors.add("errorValidacion", new ActionError("error.fecha.inicio.posterior.fecha.fin"));
        	} else if (!UtilidadesFechas.getDate(this.getFechaInicioEvaluacionAlquiler()).before(
    																		UtilidadesFechas.getDate(this.getFechaFinEvaluacionAlquiler()))) {
        		errors.add("errorValidacion", new ActionError("error.fecha.inicio.igual.fecha.fin"));
        	}
		} else {
			
		}
		
        return errors;
    }
    

}