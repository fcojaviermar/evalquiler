package com.evalquiler.actions.comun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @version 	1.0
 * @author
 */
public class FinalizarSesionAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FinalizarSesionAction.action()");

		ActionForward forward = new ActionForward(); // return value

		String botonPulsado = request.getParameter("BOTON_PULSADO");
		
		if ("Salir".equals(botonPulsado)) {
			//Destruimos la sesión.
			request.getSession().invalidate();
			forward = mapping.findForward("END");
		} else {
			forward = mapping.findForward("NEW");
		}

		return forward;
    }
}
