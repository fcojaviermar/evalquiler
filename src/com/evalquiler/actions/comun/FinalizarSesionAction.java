package com.evalquiler.actions.comun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;

/**
 * @version 	1.0
 * @author
 */
public class FinalizarSesionAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FinalizarSesionAction.action()");
		
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionForward forward = new ActionForward(); // return value
		ActionErrors errors = new ActionErrors();
		
		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		try {
    		if (ConstantesBotones.SALIR.equals(botonPulsado)) {
    			//Destruimos la sesion.
    			this.vaciarSession(request.getSession());
    			request.getSession().invalidate();
    			request.getSession(false); //11-12-2012
    			comandoDestino = ConstantesComandos.END;
    		} else {
    			comandoDestino = ConstantesComandos.ERROR;
    		}
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
