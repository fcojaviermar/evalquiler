package com.evalquiler.actions.encuesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.entidad.ElementoComboTipoVia;

/**
 * @version 	1.0
 * @author
 */
public class NuevaBusquedaAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NuevaBusquedaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); // return value

		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			comandoDestino = ConstantesComandos.CANCEL;
			
		} else if (ConstantesBotones.BUSCAR_VIVIENDA.equals(botonPulsado)) {
			request.getSession().setAttribute("tipoVia", new ComboTipoVia());
			request.getSession().setAttribute("tipoViaSeleccionado", new ElementoComboTipoVia());
			request.getSession().setAttribute("comboProvincia", comboProvincia);
			request.setAttribute("elementoProvincia", new ElementoComboProvincia("0", ""));
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio("0", ""));
			comandoDestino = ConstantesComandos.SEARCH;

		} else if (ConstantesBotones.BUSCAR.equals(botonPulsado)) {
			request.getSession().setAttribute("tipoVia", new ComboTipoVia());
			request.getSession().setAttribute("tipoViaSeleccionado", new ElementoComboTipoVia());
			comandoDestino = ConstantesComandos.SEARCH;

		} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
			comandoDestino = ConstantesComandos.ERROR;    			
		}    			
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
		}

		forward = mapping.findForward(comandoDestino);	
		
		return forward;
    }
}
