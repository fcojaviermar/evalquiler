package com.evalquiler.actions.vivienda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosViviendaAction extends ActionBase {
	


    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarDatosViviendaAction.action()");
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			long lSecuencial = OpVivienda.contar();
			((DatosViviendaActionForm)form).setIdVivienda(lSecuencial+1);
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
			request.getSession().setAttribute("datosVivienda", (DatosViviendaActionForm)form);
		    // Forward control to the appropriate 'success' URI (change name as desired)
		    forward = mapping.findForward("OK");
		}
	
		// Finish with
		return forward;
    }
}
