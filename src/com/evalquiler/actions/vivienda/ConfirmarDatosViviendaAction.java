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
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboTipoVia;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.entidad.ElementoComboTipoVia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.municipio.NoHayMunicipiosExcepcion;
import com.evalquiler.operaciones.OpMunicipio;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarDatosViviendaAction extends ActionBase {
	


    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, NoHayMunicipiosExcepcion {
    	
		System.out.println("ConfirmarDatosViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); 

    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
    	if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			request.getSession().setAttribute("comboProvincia", comboProvincia);
			request.setAttribute("elementoProvincia", new ElementoComboProvincia());
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
    		comandoDestino = ConstantesComandos.CANCEL_NO_INICIO;
    		
    	} else if (ConstantesBotones.ACEPTAR.equals(botonPulsado)) {
        	ComboTipoVia combo1 = (ComboTipoVia)request.getSession().getAttribute("tipoVia");
        	ElementoComboTipoVia elemCombo1 = combo1.get(((DatosViviendaActionForm)form).getIdTipoVia());
        	((DatosViviendaActionForm)form).setDescTipoVia(elemCombo1.getDescripcion());
        	
			long lSecuencial = 0;
			lSecuencial = OpVivienda.ultimoIdVivienda();
			((DatosViviendaActionForm)form).setIdVivienda(lSecuencial+1);
				
			request.getSession().setAttribute("datosViviendaActionForm", (DatosViviendaActionForm)form);
			comandoDestino = ConstantesComandos.OK;
			
    	} else if (ConstantesBotones.CARGAR_MUNICIPIOS.equals(botonPulsado)) {
    		ComboMunicipio comboMunicipio = OpMunicipio.obtenerMunicipio(((DatosViviendaActionForm)form).getIdProvincia());
			request.getSession().setAttribute("comboMunicipio", comboMunicipio);
			request.setAttribute("elementoProvincia", 
											  new ElementoComboProvincia(((DatosViviendaActionForm)form).getIdProvincia(), ""));
			request.getSession().setAttribute("elementoMunicipio", new ElementoComboMunicipio());
    		comandoDestino = ConstantesComandos.MUNICIPIOS_OBTEINED;
    		
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
