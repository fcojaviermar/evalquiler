package com.evalquiler.actions.encuesta;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.PreguntasEncuestaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.encuesta.EncuestaRespondidaEnPeriodoEvaluacionExcepcion;
import com.evalquiler.operaciones.OpRespuestasEncuesta;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarRespuestasEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, ExcepcionComun {
    	
		System.out.println("ConfirmarRespuestasEncuestaAction.action()");
		DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
		String comandoDestino = ConstantesComandos.EMPTY;		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		boolean preguntaRespondida = true;
		
		int iNumeroPreguntas = 0;
			String botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
			if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
				datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
				request.setAttribute("nuevoDestino", ConstantesBotones.REALIZAR_ENCUESTA);
				request.setAttribute("idVivienda", String.valueOf(datosRealizacionEncuesta.getDatosVivienda().getIdVivienda()));
				comandoDestino = ConstantesComandos.CANCEL;
				
			} else if (ConstantesBotones.RESPONDER.equals(botonPulsado)) {
				try {
					iNumeroPreguntas = Integer.parseInt((String)request.getParameter("NumeroPreguntas"));

	    			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
	    			
	    			try {
						OpRespuestasEncuesta.getEncuestasRespondidasEnPeriodo(datosRealizacionEncuesta);
	    				datosRealizacionEncuesta.setFechaInicioEvaluacionAlquiler(((DatosRealizacionEncuestaActionForm)form).getFechaInicioEvaluacionAlquiler());
	    				datosRealizacionEncuesta.setFechaFinEvaluacionAlquiler(((DatosRealizacionEncuestaActionForm)form).getFechaFinEvaluacionAlquiler());
	    				DatosEncuestaActionForm datosEncuesta = datosRealizacionEncuesta.getDatosEncuesta();
	       				if (null != datosEncuesta) {
	    					Iterator<PreguntasEncuestaActionForm> oIter = datosEncuesta.getPreguntas().iterator();
	    					int i=0;
	    					while ( (oIter.hasNext()) && (i<iNumeroPreguntas) && preguntaRespondida ) {
	    						PreguntasEncuestaActionForm pregunta = oIter.next();
	    						try {
	    							pregunta.setIdRespuestaDada(Integer.parseInt((String)request.getParameter("idRespuesta" + i)));
	    						} catch (NullPointerException e) {
	    							preguntaRespondida = false;
	    						}
	    						i = i +1;
	    					}
	    					
	    					if (!preguntaRespondida) {
    							errors.add("errorExcepcion", new ActionError("msg.no.respondidas.todas.preguntas"));
    							comandoDestino = ConstantesComandos.OBLIGATORY_ANSWERS;					
	    					} else {
		    					datosEncuesta.setIdTipoUsuario(datosRealizacionEncuesta.getDatosUsuario().getIdTipoUsuario());
		    					datosRealizacionEncuesta.setDatosEncuesta(datosEncuesta);
		    					errors.add("errorValidacion", new ActionError("msg.para.guardar.pulsar.guardarencuesta"));	
		    					comandoDestino = ConstantesComandos.OK;
	    					}
	    					
	    				} else {
		    				errors.add("errorValidacion", new ActionError("error.no.existe.encuesta"));	    					
		    				comandoDestino = ConstantesComandos.NOOK;
	    				}
					} catch (EncuestaRespondidaEnPeriodoEvaluacionExcepcion e) {
	    				errors.add("errorValidacion", new ActionError("error.periodo.ya.evaluado.para.vivienda"));
	    				comandoDestino = ConstantesComandos.ALREADY_EVAL;	    				
					}
				} catch (NumberFormatException e) {
					errors.add("errorExcepcion", new ActionError("msg.no.respondidas.todas.preguntas"));
					comandoDestino = ConstantesComandos.OBLIGATORY_ANSWERS;					
				} 
    			
//			} else {
//				errors.add("errorExcepcion", new ActionError("error.global.mesage"));
//				errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
//				comandoDestino = ConstantesComandos.ERROR;    			
//			}
//		} catch (NumberFormatException e) {
//			comandoDestino = ConstantesComandos.ERROR;
//			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
//		} catch (Exception e) {
//			comandoDestino = ConstantesComandos.ERROR;
//			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		    
		} else {
		}
	
		forward = mapping.findForward(comandoDestino);
		return forward;
    }
    
    
    
}
