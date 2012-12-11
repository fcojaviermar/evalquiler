package com.evalquiler.actions.informes;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.vivienda.CriteriosBusquedaViviendaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.combo.ComboTipoInforme;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.entidad.ElementoComboTipoInforme;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.municipio.NoHayMunicipiosExcepcion;
import com.evalquiler.excepciones.vivienda.EncontradasMuchasViviendasExcepcion;
import com.evalquiler.excepciones.vivienda.NoEncontradaViviendaConCriteriosExcepcion;
import com.evalquiler.operaciones.OpMunicipio;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class RealizarBusquedaViviendaAction extends ActionBase {
	
    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, NoHayMunicipiosExcepcion {
    	
		System.out.println("RealizarBusquedaViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		ActionErrors errors = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward(); 
		Collection<DatosViviendaActionForm> listaViviendas = null;
		CriteriosBusquedaViviendaActionForm criteriosBusqueda = null;
		
    	String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
    	if (ConstantesBotones.BUSCAR.equals(botonPulsado)) {
			// Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			try {
				listaViviendas = OpVivienda.buscarVivienda(form);
				request.getSession().setAttribute("datosViviendaActionForm", listaViviendas);
				request.getSession().setAttribute("criteriosBusquedaViviendaActionForm", form);
				request.getSession().setAttribute("tipoInforme", new ComboTipoInforme());
				request.getSession().setAttribute("tipoInformeSeleccionado", new ElementoComboTipoInforme() );				
				comandoDestino = ConstantesComandos.MORE_THAN_ONE_RESULT;
				
			} catch (NoEncontradaViviendaConCriteriosExcepcion e) {
				messages.add("message", new ActionMessage(e.getMensaje()));
				comandoDestino = ConstantesComandos.NO_RESULT;

			} catch (EncontradasMuchasViviendasExcepcion e) {
				comandoDestino = ConstantesComandos.NO_RESULT;
				messages.add("message", new ActionMessage(e.getMensaje()));
			}
    	} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
//			request.setAttribute("elementoProvincia", new ElementoComboProvincia());
//			request.setAttribute("comboMunicipio", new ComboMunicipio());
//			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
    		comandoDestino = ConstantesComandos.CANCEL;
    			
    	} else if (ConstantesBotones.REALIZAR_ENCUESTA.equals(botonPulsado)) {
    		criteriosBusqueda = (CriteriosBusquedaViviendaActionForm)request.getSession().getAttribute("criteriosBusquedaViviendaActionForm");
			try {
				listaViviendas = OpVivienda.buscarVivienda(criteriosBusqueda);
				request.setAttribute("datosViviendaActionForm", listaViviendas);
				request.getSession().setAttribute("criteriosBusquedaViviendaActionForm", form);
				comandoDestino = ConstantesComandos.MORE_THAN_ONE_RESULT;
				
			} catch (NoEncontradaViviendaConCriteriosExcepcion e) {
				comandoDestino = ConstantesComandos.NO_RESULT;
				messages.add("message", new ActionMessage(e.getMensaje()));
			} catch (EncontradasMuchasViviendasExcepcion e) {
				comandoDestino = ConstantesComandos.NO_RESULT;
				messages.add("message", new ActionMessage(e.getMensaje()));
			}
			
    	} else if (ConstantesBotones.CARGAR_MUNICIPIOS.equals(botonPulsado)) {
    		ComboMunicipio comboMunicipio = OpMunicipio.obtenerMunicipio(((CriteriosBusquedaViviendaActionForm)form).getIdProvincia());
			request.setAttribute("comboMunicipio", comboMunicipio);
			request.setAttribute("elementoProvincia", 
											  new ElementoComboProvincia(((CriteriosBusquedaViviendaActionForm)form).getIdProvincia(), ""));
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
    		comandoDestino = ConstantesComandos.MUNICIPIOS_OBTEINED;
    		
    	} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
			comandoDestino = ConstantesComandos.ERROR;
    	}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		} else {
			if (!messages.isEmpty()) {
				saveMessages(request, messages);
			}
		}
	
		forward = mapping.findForward(comandoDestino);	
		
		return forward;
    }
    
}