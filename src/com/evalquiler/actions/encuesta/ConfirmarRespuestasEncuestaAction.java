package com.evalquiler.actions.encuesta;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.operaciones.OpRespuestasEncuesta;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarRespuestasEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarRespuestasEncuestaAction.action()");
		DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
		String comandoDestino = ConstantesComandos.EMPTY;		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		
		int iNumeroPreguntas = 0;
		try {
			String botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
			if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
				comandoDestino = ConstantesComandos.CANCEL;
				
			} else if (ConstantesBotones.RESPONDER.equals(botonPulsado)) {
    			iNumeroPreguntas = Integer.parseInt((String)request.getParameter("NumeroPreguntas"));	
    			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
    			
    			if (!OpRespuestasEncuesta.hayEncuestasRespondidasEnPeriodo(datosRealizacionEncuesta)) {
    
    				datosRealizacionEncuesta.setFechaInicioEvaluacionAlquiler(((DatosRealizacionEncuestaActionForm)form).getFechaInicioEvaluacionAlquiler());
    				datosRealizacionEncuesta.setFechaFinEvaluacionAlquiler(((DatosRealizacionEncuestaActionForm)form).getFechaFinEvaluacionAlquiler());
    				DatosEncuestaActionForm datosEncuesta = datosRealizacionEncuesta.getDatosEncuesta();
    
    				if (null != datosEncuesta) {
    					Iterator<PreguntasEncuestaActionForm> oIter = datosEncuesta.getPreguntas().iterator();
    					int i=0;
    					while ( (oIter.hasNext()) && (i<iNumeroPreguntas) ) {
    						PreguntasEncuestaActionForm pregunta = oIter.next();
    						pregunta.setIdRespuestaDada(Integer.parseInt((String)request.getParameter("idRespuesta" + i)));
    						i = i +1;
    					}
    	    
    					datosRealizacionEncuesta.setDatosEncuesta(datosEncuesta);
    					comandoDestino = ConstantesComandos.OK;
    				} else {
    					
    				}
    			} else {
    				comandoDestino = ConstantesComandos.ALREADY_EVAL;
    				errors.add("errorValidacion", new ActionMessage("error.periodo.ya.evaluado.para.vivienda"));
    			}
			} else {
				errors.add("errorExcepcion", new ActionError("error.global.mesage"));
				errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
				comandoDestino = ConstantesComandos.ERROR;    			
			}
		} catch (NumberFormatException e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		    
		} else {
		}
	
		forward = mapping.findForward(comandoDestino);
		return forward;
    }
}
