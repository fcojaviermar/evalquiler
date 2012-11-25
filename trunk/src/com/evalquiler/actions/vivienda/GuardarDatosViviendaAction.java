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
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class GuardarDatosViviendaAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GuardarDatosViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		try {
		    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
			if (ConstantesBotones.GUARDAR.equals(botonPulsado)) {
				DatosViviendaActionForm datosVivienda = (DatosViviendaActionForm)request.getSession().getAttribute("datosViviendaActionForm");
				OpVivienda.insertar(datosVivienda);
				request.setAttribute("idVivienda", String.valueOf(datosVivienda.getIdVivienda()));
				comandoDestino = ConstantesComandos.OK;
			} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
				comandoDestino = ConstantesComandos.CANCEL;
			} else {
    			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
    			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
    			comandoDestino = ConstantesComandos.ERROR;    			
			}
		} catch (Exception e) {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			comandoDestino = ConstantesComandos.ERROR;			
		}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
		}
	
		forward = mapping.findForward(comandoDestino);
		return (forward);
    }
}
