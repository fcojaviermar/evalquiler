package com.evalquiler.actions.vivienda;

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

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.excepciones.vivienda.NoEncontradaViviendaConCriteriosExcepcion;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class RealizarBusquedaViviendaAction extends ActionBase {
	
    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ResultadosBusquedaViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		Collection<DatosViviendaActionForm> listaViviendas = null;
		
	    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
	    	if (ConstantesBotones.BUSCAR.equals(botonPulsado)) {
    			// Aqui va toda la logica del negocio y todas las llamadas a otras clases.
    			try {
					listaViviendas = OpVivienda.buscarVivienda(form);
    				request.setAttribute("datosViviendaActionForm", listaViviendas);
    				comandoDestino = ConstantesComandos.MORE_THAN_ONE_RESULT;
				} catch (NoEncontradaViviendaConCriteriosExcepcion e) {
    				comandoDestino = ConstantesComandos.NO_RESULT;
    				messages.add("message", new ActionMessage("msg.no.viviendas.criterios.introducidos"));
				}
	    	} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
	    		comandoDestino = ConstantesComandos.CANCEL;
	    			
	    	} else {
    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
    			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
    			comandoDestino = ConstantesComandos.ERROR;
	    	}
//		} catch (Exception e) {
//			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
//			comandoDestino = ConstantesComandos.ERROR;
//		}
	
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
    
}
