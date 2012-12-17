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
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
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

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, ExcepcionComun {
    	
    	System.out.println("RecuperarEncuestaAction.action()");
		String comandoDestino = ConstantesComandos.EXIT;
		DatosRealizacionEncuestaActionForm  datosRealizacionEncuesta = null;
		Collection<DatosEncuestaActionForm> datosEncuesta 			 = null;
		DatosViviendaActionForm 			viviendaSeleccionada 	 = null;
		ActionErrors  errors  = new ActionErrors();
		ActionForward forward = new ActionForward(); 
		String botonPulsado   = null;
		String idVivienda 	  = null;
		
		
		botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.NUEVA_VIVIENDA.equals(botonPulsado)) {
			request.getSession().setAttribute("tipoVia", new ComboTipoVia());
			request.getSession().setAttribute("tipoViaSeleccionado", new ElementoComboTipoVia());
			request.setAttribute("elementoProvincia", new ElementoComboProvincia());
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
			comandoDestino = ConstantesComandos.NEW_HOUSE;
			
		} else if (ConstantesBotones.RESPONDER.equals(botonPulsado)) {
			comandoDestino = ConstantesComandos.THERE_IS_POLL;
			
		} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
    			request.setAttribute("elementoProvincia", new ElementoComboProvincia("0", ""));
    			request.setAttribute("comboMunicipio", new ComboMunicipio());
    			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio("0", ""));
				comandoDestino = ConstantesComandos.CANCEL_NO_INICIO;
			
		} else if ( (ConstantesBotones.REALIZAR_ENCUESTA.equals(botonPulsado)) || 
					(ConstantesBotones.GUARDAR.equals(botonPulsado)) ) {
			
			viviendaSeleccionada = new DatosViviendaActionForm();
			try {
				idVivienda = DatosEncuestaActionForm.getViviendaSeleccionada(request);
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
    					errors.add("message", new ActionError("msg.preguntas.obligatorias"));
    					comandoDestino = ConstantesComandos.THERE_IS_POLL;
					} catch (NoExistenEncuestasExcepcion e) {
						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
					} catch (NoRecuperadaEncuestaExcepcion e) {
						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;					
					} catch (NoRecuperadasPreguntasParaEncuestaExcepcion e) {
						comandoDestino = ConstantesComandos.THERE_IS_NO_POLL;
					}
				} catch (NoExisteViviendaExcepcion e1) {
					errors.add("message", new ActionError(e1.getMensaje()));
					comandoDestino = ConstantesComandos.ERROR;
				}
			} catch (ViviendaNoSeleccionadaExcepcion e2) {
				errors.add("message", new ActionError(e2.getMensaje()));
				comandoDestino = ConstantesComandos.NO_SELECTION;
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
