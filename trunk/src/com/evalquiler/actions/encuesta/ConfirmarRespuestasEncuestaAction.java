package com.evalquiler.actions.encuesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.RespuestasEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarRespuestasEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarRespuestasEncuestaAction.action()");
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		RespuestasEncuestaActionForm respuestasEncuesta = null;
		
		int iNumeroPreguntas = 0;
		try {
			iNumeroPreguntas = Integer.parseInt((String)request.getParameter("NumeroPreguntas"));	
		} catch (NumberFormatException e) {
			
		}
		
		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			DatosEncuestaActionForm datosEncuesta = (DatosEncuestaActionForm)request.getSession().getAttribute("datosEncuesta");
			if (null != datosEncuesta) {
    			respuestasEncuesta = new RespuestasEncuestaActionForm();
    			respuestasEncuesta.setDatosEncuesta(datosEncuesta);
    			for (int i=0; i<iNumeroPreguntas; i++) {
    				System.out.println(request.getParameter("idRespuesta" + i));
    				respuestasEncuesta.getDatosEncuesta().getPreguntas().iterator().next().setIdRespuesta(Integer.parseInt((String)request.getParameter("idRespuesta" + i)));
    			}
    
    			respuestasEncuesta.setDatosUsuario((DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuario"));
    			respuestasEncuesta.setDatosVivienda((DatosViviendaActionForm)request.getSession().getAttribute("datosVivienda"));
    
    			//Se guarda en sesión para ir a la pantalla de confirmación y mostrar los datos y si son correctos se guarda en bbdd.
    			request.getSession().setAttribute("respuestasEncuesta", respuestasEncuesta);
			} else {
				
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
		    forward = mapping.findForward("ERROR");
		} else {
		    // Forward control to the appropriate 'success' URI (change name as desired)
		    forward = mapping.findForward("OK");
		}
	
		// Finish with
		return forward;
    }
}
