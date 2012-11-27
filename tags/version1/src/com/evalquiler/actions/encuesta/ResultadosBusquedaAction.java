package com.evalquiler.actions.encuesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;

/**
 * @version 	1.0
 * @author
 */
public class ResultadosBusquedaAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ResultadosBusquedaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
			if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {			
				comandoDestino = ConstantesComandos.CANCEL;
			} else if (ConstantesBotones.BUSCAR.equals(botonPulsado)) {
				comandoDestino = ConstantesComandos.ONE_RESULT;
			} else {
    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
    			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
    			comandoDestino = ConstantesComandos.ERROR;    			
			}
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
		}
	
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		    comandoDestino = ConstantesComandos.EXIT;
		} else {

		}
	
		forward = mapping.findForward(comandoDestino);
		
		return forward;
    }
}
