package com.evalquiler.actions.encuesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.encuesta.RespuestasEncuestaNoGuardadasExcepcion;
import com.evalquiler.operaciones.OpRespuestasEncuesta;

/**
 * @version 	1.0
 * @author
 */
public class GuardarEncuestaAction extends ActionBase {
//CAMBIAR NOMBRE POR GuardarRespuestasEncuestaAction

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, ExcepcionComun {
    	
		System.out.println("GuardarEncuestaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); 

		String botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			comandoDestino = ConstantesComandos.CANCEL;
			
		} else if (ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) {
			DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = 
												(DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			try {
				OpRespuestasEncuesta.insertar(datosRealizacionEncuesta);
				datosRealizacionEncuesta.setDatosVivienda(null);
				datosRealizacionEncuesta.setFechaFinEvaluacionAlquiler(null);
				datosRealizacionEncuesta.setFechaInicioEvaluacionAlquiler(null);
				datosRealizacionEncuesta.setDatosEncuesta(null);
				errors.add("message", new ActionError("msg.encuesta.realizada"));
    			comandoDestino = ConstantesComandos.OK;
    			
			} catch (RespuestasEncuestaNoGuardadasExcepcion e) {
				errors.add("errorExcepcion", new ActionError(e.getMensaje()));
				comandoDestino = ConstantesComandos.NOOK;
			} 

		} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
			comandoDestino = ConstantesComandos.ERROR;    			
		}
	
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		}
		
		forward = mapping.findForward(comandoDestino);	
		return forward;
    }
}
