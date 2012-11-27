package com.evalquiler.actions.vivienda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoVia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosViviendaAction extends ActionBase {
	


    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ConfirmarDatosViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

	    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
	    	if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
	    		comandoDestino = ConstantesComandos.CANCEL;
	    		
	    	} else if (ConstantesBotones.ACEPTAR.equals(botonPulsado)) {
	        	ComboTipoVia combo1 = (ComboTipoVia)request.getSession().getAttribute("tipoVia");
	        	ElementoComboTipoVia elemCombo1 = combo1.get(((DatosViviendaActionForm)form).getIdTipoVia());
	        	((DatosViviendaActionForm)form).setDescTipoVia(elemCombo1.getDescripcion());
	        	
				long lSecuencial = 0;
				try {
					lSecuencial = OpVivienda.ultimoIdVivienda();
					((DatosViviendaActionForm)form).setIdVivienda(lSecuencial+1);
					
					request.getSession().setAttribute("datosViviendaActionForm", (DatosViviendaActionForm)form);
					comandoDestino = ConstantesComandos.OK;			
				} catch (ExcepcionEjecutarSentancia e) {
	    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
	    			errors.add("errorExcepcion", new ActionError(e.getMensaje()));
	    			comandoDestino = ConstantesComandos.ERROR;
				}
	    		
	    	} else {
    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
    			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
    			comandoDestino = ConstantesComandos.ERROR;
	    	}
//		} catch (Exception e) {
//		    // Report the error using the appropriate name and ID.
//			comandoDestino = ConstantesComandos.EXIT;
//			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
//		}

		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			// Forward control to the appropriate 'success' URI (change name as desired)
		}

		forward = mapping.findForward(comandoDestino);
		// Finish with
		return forward;
    }
}
