package com.evalquiler.actions.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesComandos;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosUsuarioAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarDatosUsuarioAction.action()");
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
	
		} catch (Exception e) {
		    // Report the error using the appropriate name and ID.
		    errors.add("name", new ActionMessage("id"));
		}
	
		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		    // Forward control to the appropriate 'failure' URI (change name as desired)
		    forward = mapping.findForward(ConstantesComandos.ERROR);
		} else {
		    // Forward control to the appropriate 'success' URI (change name as desired)
			request.getSession().setAttribute("datosUsuarioActionForm", (DatosUsuarioActionForm)form);
			//request.setAttribute("datosUsuarioActionForm", (InformacionDatosUsuarioActionForm)form);
		    forward = mapping.findForward(ConstantesComandos.OK);
		}
	
		// Finish with
		return (forward);
    }
}
