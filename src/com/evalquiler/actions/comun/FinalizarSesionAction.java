package com.evalquiler.actions.comun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		ActionForward forward = new ActionForward(); // return value

		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		
		if (ConstantesBotones.SALIR.equals(botonPulsado)) {
			//Destruimos la sesion.
			forward = mapping.findForward(ConstantesComandos.END);
			request.getSession().invalidate();			
		} else {
			forward = mapping.findForward(ConstantesComandos.ERROR);
		}

		return forward;
    }
}
