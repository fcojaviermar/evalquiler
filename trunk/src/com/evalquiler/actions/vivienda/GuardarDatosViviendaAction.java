package com.evalquiler.actions.vivienda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboMunicipio;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.comun.utilidades.UtilidadesFicheros;
import com.evalquiler.entidad.ElementoComboMunicipio;
import com.evalquiler.entidad.ElementoComboProvincia;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.vivienda.ViviendaNoGuardadaExcepcion;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class GuardarDatosViviendaAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, ExcepcionComun {
    	
		UtilidadesFicheros.escribir("GuardarDatosViviendaAction.action()");
		String comandoDestino = ConstantesComandos.EMPTY;
		DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
		ActionErrors   errors   = new ActionErrors();
		ActionForward  forward  = new ActionForward(); // return value

		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.GUARDAR.equals(botonPulsado)) {
			DatosViviendaActionForm datosVivienda = (DatosViviendaActionForm)request.getSession().getAttribute("datosViviendaActionForm");			

			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			UtilidadesFicheros.escribir("esPropietario: " + datosRealizacionEncuesta.getDatosUsuario().esPropietario());
			if (datosRealizacionEncuesta.getDatosUsuario().esPropietario()) {
				UtilidadesFicheros.escribir("NIF: " + datosRealizacionEncuesta.getDatosUsuario().getNifcif());
				datosVivienda.setNifPropietario(datosRealizacionEncuesta.getDatosUsuario().getNifcif());
			}
			try {
				OpVivienda.insertar(datosVivienda);
//Recuperar la vivienda haciendo una b�squeda por los datos que se han guardado, ya que el idViviendo puede no coincidir con el que se ha guardado
//ya que se autoincrementa.				
				request.setAttribute("idVivienda", String.valueOf(datosVivienda.getIdVivienda()));
				errors.add("messages", new ActionError("msg.vivienda.guardada"));
				comandoDestino = ConstantesComandos.OK;
			} catch (ViviendaNoGuardadaExcepcion e) {
				errors.add("errorExcepcion", new ActionError(e.getMensaje()));
				request.getSession().setAttribute("comboProvincia", comboProvincia);
				request.setAttribute("elementoProvincia", new ElementoComboProvincia());
				request.setAttribute("comboMunicipio", new ComboMunicipio());
				request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
				comandoDestino = ConstantesComandos.NOOK;
			}
		} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			request.getSession().setAttribute("comboProvincia", comboProvincia);
			request.setAttribute("elementoProvincia", new ElementoComboProvincia());
			request.setAttribute("comboMunicipio", new ComboMunicipio());
			request.setAttribute("elementoMunicipio", new ElementoComboMunicipio());
			comandoDestino = ConstantesComandos.CANCEL;
			
		} else {
			errors.add("errorExcepcion", new ActionError("error.global.mesage"));
			errors.add("errorExcepcion", new ActionError("error.comando.no.existe"));
			comandoDestino = ConstantesComandos.ERROR;    			
		}
	
		if (!errors.isEmpty()) {
		    saveErrors(request, errors);
		}
	
		forward = mapping.findForward(comandoDestino);
		return (forward);
    }
}
