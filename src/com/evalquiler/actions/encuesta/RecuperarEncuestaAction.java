package com.evalquiler.actions.encuesta;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.encuesta.DatosEncuestaActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.dao.DaoEncuesta;
import com.evalquiler.operaciones.OpEncuesta;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class RecuperarEncuestaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RecuperarEncuestaAction.action()");
		String comandoDestino = ConstantesComandos.EXIT;
	
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value
		String botonPulsado   = null;
		DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
		
		try {
			botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
			if (ConstantesBotones.NUEVA_VIVIENDA.equals(botonPulsado)) {
				comandoDestino = ConstantesComandos.NEW_HOUSE;
			} else if (ConstantesBotones.RESPONDER.equals(botonPulsado)) {
				//Entra por aquí si se produce una redireccion del tipo ALREADY_EVAL
				comandoDestino = ConstantesComandos.THERE_IS_POLL;
			} else {
				DatosViviendaActionForm viviendaSeleccionada = new DatosViviendaActionForm();
				viviendaSeleccionada.setIdVivienda(Integer.parseInt((String)request.getParameter("idVivienda")));
				Collection<DatosViviendaActionForm> vivienda = OpVivienda.consultarPorPk(viviendaSeleccionada);

				if (!vivienda.isEmpty()) {
					viviendaSeleccionada = vivienda.iterator().next();
					datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
					
    				Collection<DatosEncuestaActionForm> datosEncuesta = OpEncuesta.consultar(datosRealizacionEncuesta.getDatosUsuario(), 
    																					     DaoEncuesta.CONSULTAR_PARA_QUIEN_ES_ENCUESTA);
    			
    				if (!datosEncuesta.isEmpty()) {
    					datosRealizacionEncuesta.setDatosVivienda(viviendaSeleccionada);
    					datosRealizacionEncuesta.setDatosEncuesta((DatosEncuestaActionForm)datosEncuesta.iterator().next());

    					comandoDestino = ConstantesComandos.THERE_IS_POLL;
    				} else {
    					
    				}
				} else {
					
				}
			}
		} catch (Exception e) {
			comandoDestino = ConstantesComandos.ERROR;
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));		
		}

		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
		}

		forward = mapping.findForward(comandoDestino);

		// Finish with
		return forward;
    }
}
