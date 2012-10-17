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
import com.evalquiler.actions.comun.ActionBase;

/**
 * @version 	1.0
 * @author
 */
public class RespuestasEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RespuestasEncuestaAction.action()");
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value

		int iContador = 0;
		try {
			iContador = Integer.parseInt((String)request.getParameter("Contador"));	
		} catch (NumberFormatException e) {
			
		}
		
		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			DatosEncuestaActionForm datosEncuesta = (DatosEncuestaActionForm)request.getSession().getAttribute("datosEncuesta");
			
			for (int i=0; i<iContador; i++) {
				System.out.println(request.getParameter("idRespuesta" + i));
				datosEncuesta.getPreguntas().iterator().next().setIdRespuesta(Integer.parseInt(request.getParameter("idRespuesta" + i)));
			}

			
			int i =0;
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
		    forward = mapping.findForward("OK");
		}
	
		// Finish with
		return forward;
    }
}
