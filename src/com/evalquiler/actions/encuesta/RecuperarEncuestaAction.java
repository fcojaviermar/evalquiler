package com.evalquiler.actions.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;
import com.evalquiler.dao.DaoEncuesta;
import com.evalquiler.entidad.ElementoComboTipoVia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.encuesta.NoExistenEncuestasExcepcion;
import com.evalquiler.excepciones.encuesta.NoRecuperadaEncuestaExcepcion;
import com.evalquiler.excepciones.encuesta.NoRecuperadasPreguntasParaEncuestaExcepcion;
import com.evalquiler.excepciones.vivienda.NoExisteViviendaExcepcion;
import com.evalquiler.excepciones.vivienda.ViviendaNoSeleccionadaExcepcion;
import com.evalquiler.operaciones.OpEncuesta;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class RecuperarEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ExcepcionEjecutarSentancia {
    	UtilidadesFicheros.escribir("RecuperarEncuestaAction.action()");
		String comandoDestino = ConstantesComandos.EXIT;
		Collection<DatosEncuestaActionForm> datosEncuesta = null;
		DatosViviendaActionForm viviendaSeleccionada = null;
		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		String botonPulsado   = null;
		DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
		
		botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.NUEVA_VIVIENDA.equals(botonPulsado)) {
			request.getSession().setAttribute("tipoVia", new ComboTipoVia());
			request.getSession().setAttribute("tipoViaSeleccionado", new ElementoComboTipoVia());
			comandoDestino = ConstantesComandos.NEW_HOUSE;
			
		} else if (ConstantesBotones.RESPONDER.equals(botonPulsado)) {
			comandoDestino = ConstantesComandos.THERE_IS_POLL;
			
		} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
//			String nuevoDestino = (String)request.getAttribute("nuevoDestino");
//			if (null == nuevoDestino) {
				comandoDestino = ConstantesComandos.CANCEL_NO_INICIO;
//			}
//			viviendaSeleccionada = new DatosViviendaActionForm();
//			
//			String idVivienda = null;
//			try {
//				idVivienda = this.getViviendaSeleccionada(request);
//				viviendaSeleccionada.setIdVivienda(Integer.parseInt(idVivienda));
//				Collection<DatosViviendaActionForm> vivienda = null;
//				try {
//					datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
//					vivienda = OpVivienda.consultarVivienda(viviendaSeleccionada, datosRealizacionEncuesta.getDatosUsuario().getNifcif());
//					viviendaSeleccionada = vivienda.iterator().next();
//
//					try {
//						datosEncuesta = OpEncuesta.consultarParaTipoUsuario(datosRealizacionEncuesta.getDatosUsuario(), 
//																			DaoEncuesta.CONSULTAR_PARA_QUIEN_ES_ENCUESTA);
//    					datosRealizacionEncuesta.setDatosVivienda(viviendaSeleccionada);
//    					datosRealizacionEncuesta.setDatosEncuesta((DatosEncuestaActionForm)datosEncuesta.iterator().next());
//
//    					comandoDestino = ConstantesComandos.THERE_IS_POLL;
//					} catch (NoExistenEncuestasExcepcion e) {
//						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
//					} catch (NoRecuperadaEncuestaExcepcion e) {
//						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;					
//					} catch (NoRecuperadasPreguntasParaEncuestaExcepcion e) {
//						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
//					}
//				} catch (NoExisteViviendaExcepcion e1) {
//					messages.add("message", new ActionMessage(e1.getMensaje()));
//					comandoDestino = ConstantesComandos.ERROR;
//				}
//			} catch (ViviendaNoSeleccionadaExcepcion e2) {
//				messages.add("message", new ActionMessage(e2.getMensaje()));
//				comandoDestino = ConstantesComandos.NO_SELECTION;
//			}
			
		} else if ( (ConstantesBotones.REALIZAR_ENCUESTA.equals(botonPulsado)) || 
					(ConstantesBotones.GUARDAR.equals(botonPulsado)) ) {
			
			viviendaSeleccionada = new DatosViviendaActionForm();
			
			String idVivienda = null;
			try {
				idVivienda = this.getViviendaSeleccionada(request);
				viviendaSeleccionada.setIdVivienda(Integer.parseInt(idVivienda));
				Collection<DatosViviendaActionForm> vivienda = null;
				try {
					datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
					vivienda = OpVivienda.consultarVivienda(viviendaSeleccionada, datosRealizacionEncuesta.getDatosUsuario().getNifcif());
					viviendaSeleccionada = vivienda.iterator().next();
					UtilidadesFicheros.escribir("viviendaSeleccionada: " + viviendaSeleccionada.getIdVivienda());
    				try {
						datosEncuesta = OpEncuesta.consultarParaTipoUsuario(datosRealizacionEncuesta.getDatosUsuario());
						UtilidadesFicheros.escribir("Se ha recuperado una encuesta");
    					datosRealizacionEncuesta.setDatosVivienda(viviendaSeleccionada);
    					datosRealizacionEncuesta.setDatosEncuesta((DatosEncuestaActionForm)datosEncuesta.iterator().next());

    					comandoDestino = ConstantesComandos.THERE_IS_POLL;
					} catch (NoExistenEncuestasExcepcion e) {
						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
					} catch (NoRecuperadaEncuestaExcepcion e) {
						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;					
					} catch (NoRecuperadasPreguntasParaEncuestaExcepcion e) {
						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
					}
				} catch (NoExisteViviendaExcepcion e1) {
					messages.add("message", new ActionMessage(e1.getMensaje()));
					comandoDestino = ConstantesComandos.ERROR;
				}
			} catch (ViviendaNoSeleccionadaExcepcion e2) {
				messages.add("message", new ActionMessage(e2.getMensaje()));
				comandoDestino = ConstantesComandos.NO_SELECTION;
			}
		} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
			comandoDestino = ConstantesComandos.ERROR;    			
		}

		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			if (!messages.isEmpty()) {
				saveMessages(request, messages);
			}
		}

		forward = mapping.findForward(comandoDestino);

		return forward;
    }
    
    
    private final String getViviendaSeleccionada(HttpServletRequest request) throws ViviendaNoSeleccionadaExcepcion {
		String idVivienda = (String)request.getParameter("idVivienda");
		if (null == idVivienda) {
			//En este caso se viene cuando se ha dado de alta una vivienda de forma correcta.
			idVivienda = (String)request.getAttribute("idVivienda");
		}
		if (null == idVivienda) {
			throw new ViviendaNoSeleccionadaExcepcion();
		}
		
		UtilidadesFicheros.escribir("idVivienda: " + idVivienda);
		return idVivienda;
    }
    
}
