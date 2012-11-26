package com.evalquiler.actions.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.dao.DaoEncuesta;
import com.evalquiler.entidad.ElementoComboTipoVia;
import com.evalquiler.excepciones.encuesta.NoExistenEncuestaExcepcion;
import com.evalquiler.excepciones.vivienda.NoExisteViviendaExcepcion;
import com.evalquiler.excepciones.vivienda.ViviendaNoSeleccionadaExcepcion;
import com.evalquiler.operaciones.OpEncuesta;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class RecuperarEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("RecuperarEncuestaAction.action()");
		String comandoDestino = ConstantesComandos.EXIT;
		Collection<DatosEncuestaActionForm> datosEncuesta = null;
		ActionErrors errors = new ActionErrors();
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
				comandoDestino = ConstantesComandos.CANCEL;
				
			} else if ( (ConstantesBotones.REALIZAR_ENCUESTA.equals(botonPulsado)) || 
						(ConstantesBotones.GUARDAR.equals(botonPulsado)) ) {
				DatosViviendaActionForm viviendaSeleccionada = new DatosViviendaActionForm();
				
				String idVivienda = null;
				try {
					idVivienda = this.getViviendaSeleccionada(request);
    				viviendaSeleccionada.setIdVivienda(Integer.parseInt(idVivienda));
    				Collection<DatosViviendaActionForm> vivienda = null;
					try {
						vivienda = OpVivienda.consultarVivienda(viviendaSeleccionada);
    					viviendaSeleccionada = vivienda.iterator().next();
    					datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
    					
        				try {
							datosEncuesta = OpEncuesta.consultarParaTipoUsuario(datosRealizacionEncuesta.getDatosUsuario(), 
																				DaoEncuesta.CONSULTAR_PARA_QUIEN_ES_ENCUESTA);
        					datosRealizacionEncuesta.setDatosVivienda(viviendaSeleccionada);
        					datosRealizacionEncuesta.setDatosEncuesta((DatosEncuestaActionForm)datosEncuesta.iterator().next());
    
        					comandoDestino = ConstantesComandos.THERE_IS_POLL;
						} catch (NoExistenEncuestaExcepcion e) {
							comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
						}
					} catch (NoExisteViviendaExcepcion e1) {

					}
				} catch (ViviendaNoSeleccionadaExcepcion e2) {

				}
//				(String)request.getParameter("idVivienda");
//				if (null == idVivienda) {
//					//En este caso se viene cuando se ha dado de alta una vivienda de forma correcta.
//					idVivienda = (String)request.getAttribute("idVivienda");
//				}
//				if (null != idVivienda) {
       			
//				} else {
//				}
			} else {
    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
    			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
    			comandoDestino = ConstantesComandos.ERROR;    			
			}
//		} catch (Exception e) {
//			comandoDestino = ConstantesComandos.ERROR;
//			errors.add("errorExcepcion", new ActionError("error.global.mesage"));		
//		}

		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
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
		
		return idVivienda;
    }
    
}
