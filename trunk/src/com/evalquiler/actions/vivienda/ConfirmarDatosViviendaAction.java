package com.evalquiler.actions.vivienda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosViviendaAction extends ActionBase {
	


    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ConfirmarDatosViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			long lSecuencial = OpVivienda.ultimoIdVivienda();
			((DatosViviendaActionForm)form).setIdVivienda(lSecuencial+1);
			
			request.getSession().setAttribute("datosViviendaActionForm", (DatosViviendaActionForm)form);
			comandoDestino = ConstantesComandos.OK;			
		} catch (Exception e) {
		    // Report the error using the appropriate name and ID.
			comandoDestino = ConstantesComandos.EXIT;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}

		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			// Forward control to the appropriate 'success' URI (change name as desired)
		}

		forward = mapping.findForward(comandoDestino);
		// Finish with
		return forward;
    }
}
