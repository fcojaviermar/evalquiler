package com.evalquiler.actions.informes;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.cliente.DatosClienteActionForm;
import com.evalquiler.actionforms.informe.DatosSolicitudInformeActionForm;
import com.evalquiler.actionforms.vivienda.DatosViviendaActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.informe.SolicitudinformeNoGuardadaExcepcion;
import com.evalquiler.excepciones.vivienda.NoExisteViviendaExcepcion;
import com.evalquiler.excepciones.vivienda.ViviendaNoSeleccionadaExcepcion;
import com.evalquiler.operaciones.OpSolicitudInforme;
import com.evalquiler.operaciones.OpVivienda;

/**
 * @version 	1.0
 * @author
 */
public class ConfirmarSolicitudInformeAction extends ActionBase {

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ExcepcionEjecutarSentancia {
		System.out.println("ConfirmarSolicitudInformeAction.action()");
		String comandoDestino   = ConstantesComandos.EMPTY;
		ActionErrors  errors    = new ActionErrors();
		ActionMessages messages = new ActionMessages();
		ActionForward forward   = new ActionForward(); 
		DatosViviendaActionForm viviendaSeleccionada = null;
		DatosClienteActionForm  datosCliente		 = null;
		String idVivienda = null;
		
	    // Aqui va toda la logica del negocio y todas las llamadas a otras clases.
		String botonPulsado = (String)request.getParameter(ConstantesBotones.BOTON_PULSADO);
//		request.getSession().setAttribute("tipoInforme", new ComboTipoInforme());
//		request.getSession().setAttribute("tipoInformeSeleccionado", new ElementoComboTipoInforme() );				

		if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {			
			comandoDestino = ConstantesComandos.CANCEL;
			
		} else if (ConstantesBotones.SOLICITAR_INFORME.equals(botonPulsado)) {
			viviendaSeleccionada = new DatosViviendaActionForm();
			try {
				idVivienda = this.getViviendaSeleccionada(request);
				viviendaSeleccionada.setIdVivienda(Integer.parseInt(idVivienda));
				Collection<DatosViviendaActionForm> vivienda = null;

					try {
						datosCliente = (DatosClienteActionForm)request.getSession().getAttribute("datosClienteActionForm");
						vivienda = OpVivienda.consultarVivienda(viviendaSeleccionada, datosCliente.getNifcif());
						viviendaSeleccionada = vivienda.iterator().next();	
						
						((DatosSolicitudInformeActionForm)form).setDatosVivienda(viviendaSeleccionada);
						((DatosSolicitudInformeActionForm)form).setDatosCliente(datosCliente);
						
						long idSolicitud = OpSolicitudInforme.siguienteIdSolicitudInforme();
						
						try {
							((DatosSolicitudInformeActionForm)form).setIdSolicitudInforme(idSolicitud);
							
							OpSolicitudInforme.insertar(form);
							//LAST_INSERT_ID()
							messages.add("message", new ActionMessage("msg.solicitud.informe.guardado", new Long(idSolicitud)));
							comandoDestino = ConstantesComandos.OK;
						} catch (SolicitudinformeNoGuardadaExcepcion e) {
							messages.add("message", new ActionMessage(e.getMensaje()));
							comandoDestino = ConstantesComandos.NOOK;
						}
					} catch (NoExisteViviendaExcepcion e) {
						messages.add("message", new ActionMessage(e.getMensaje()));
						comandoDestino = ConstantesComandos.ERROR;
					}
			} catch (ViviendaNoSeleccionadaExcepcion e) {
				messages.add("message", new ActionMessage(e.getMensaje()));
				comandoDestino = ConstantesComandos.NO_SELECTION;		
			}
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
    
    
    private final String getViviendaSeleccionada(HttpServletRequest request) throws ViviendaNoSeleccionadaExcepcion {
		String idVivienda = (String)request.getParameter("idVivienda");
		if (null == idVivienda) {
			//En este caso se viene cuando se ha dado de alta una vivienda de forma correcta.
			idVivienda = (String)request.getAttribute("idVivienda");
		}
		if (null == idVivienda) {
			throw new ViviendaNoSeleccionadaExcepcion();
		}
		
		return idVivienda;
    }
}