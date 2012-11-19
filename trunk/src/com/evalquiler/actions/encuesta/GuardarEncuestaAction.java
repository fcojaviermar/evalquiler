package com.evalquiler.actions.encuesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.operaciones.OpRespuestasEncuesta;

/**
 * @version 	1.0
 * @author
 */
public class GuardarEncuestaAction extends ActionBase
//CAMBIAR NOMBRE POR GuardarRespuestasEncuestaAction
{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GuardarEncuestaAction.action()");
		ActionMessages errors = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = 
												(DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			if (Constantes.RESULTADO_NOOK == OpRespuestasEncuesta.insertar(datosRealizacionEncuesta)) {
				
			} else {
				//La operación se ha realizado correctamente.
			}
	
		} catch (Exception e) {
		    errors.add("name", new ActionMessage("id"));
		}
	
		if (!errors.isEmpty()) {
		    // Forward control to the appropriate 'failure' URI (change name as desired)
		    forward = mapping.findForward("SALIR");
		} else {
		    // Forward control to the appropriate 'success' URI (change name as desired)
		    forward = mapping.findForward("OK");
		}
	
		return forward;
    }
}
