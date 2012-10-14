package com.evalquiler.actions.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.operaciones.OpEncuesta;

/**
 * @version 	1.0
 * @author
 */
public class RecuperarEncuestaAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RecuperarEncuestaAction.action()");
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		String botonPulsado   = null;
		String forwardAux 	  = null;		
		try {
			botonPulsado = (String)request.getParameter("BOTON_PULSADO");
			if ("Nueva vivienda".equals(botonPulsado)) {
				forwardAux = "NEW_HOUSE";
			} else {
				DatosUsuarioActionForm datosUsuario = (DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuario");
				Collection<DatosEncuestaActionForm> datosEncuesta = OpEncuesta.consultarPorPk(datosUsuario);
				request.setAttribute("datosEncuesta", datosEncuesta);
				forwardAux = "THERE_IS_POLL";
			}

	
		} catch (Exception e) {
		    // Report the error using the appropriate name and ID.
		    errors.add("name", new ActionMessage("id"));
		}
	
		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.
	
		if (!errors.isEmpty()) {
		    //saveErrors(request, errors);
		    // Forward control to the appropriate 'failure' URI (change name as desired)
		    forward = mapping.findForward("SALIR");
		} else {
		    // Forward control to the appropriate 'success' URI (change name as desired)
			forward = mapping.findForward(forwardAux);
		}
	
		// Finish with
		return forward;
    }
}
