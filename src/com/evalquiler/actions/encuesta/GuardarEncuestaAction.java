package com.evalquiler.actions.encuesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.Constantes;
import com.evalquiler.comun.constantes.ConstantesComandos;
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
		String comandoDestino = ConstantesComandos.EMPTY;		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = 
												(DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			if (Constantes.RESULTADO_NOOK == OpRespuestasEncuesta.insertar(datosRealizacionEncuesta)) {
				errors.add("errorExcepcion", new ActionError("error.no.guardar.encuesta"));
				comandoDestino = ConstantesComandos.ERROR_SAVE;
			} else {
				//La operación se ha realizado correctamente.
				comandoDestino = ConstantesComandos.OK;
			}
	
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}
	
		if (!errors.isEmpty()) {
		    // Forward control to the appropriate 'failure' URI (change name as desired)
		    
		} else {

		}
		
		forward = mapping.findForward(comandoDestino);	
		return forward;
    }
}
