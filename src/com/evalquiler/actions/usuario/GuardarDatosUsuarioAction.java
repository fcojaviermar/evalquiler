package com.evalquiler.actions.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.usuario.UsuarioNoGuardadoExcepcion;
import com.evalquiler.operaciones.OpUsuario;

/**
 * @version 	1.0
 * @author
 */
public class GuardarDatosUsuarioAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ExcepcionEjecutarSentancia {
    	System.out.println("GuardarDatosUsuarioAction.action()");
    	DatosUsuarioActionForm datosUsuario = null;
    	String comandoDestino = ConstantesComandos.ERROR;
    	ActionErrors errors = new ActionErrors();
    	ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward(); // return value
		
		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			datosUsuario = (DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuarioActionForm");
			datosUsuario.setPassword(null);
			datosUsuario.setPassword2(null);

			request.setAttribute("tipoDocumentoSeleccionado", 
								 new ElementoComboTipoDocumento(String.valueOf(datosUsuario.getIdTipoDocumento()), "") );
			request.setAttribute("tipoUsuarioSeleccionado", 
								 new ElementoComboTipoUsuario(String.valueOf(datosUsuario.getIdTipoUsuario()), "") );
			request.setAttribute("datosUsuarioActionForm", datosUsuario);
			comandoDestino = ConstantesComandos.CANCEL;
			
		} else if (ConstantesBotones.GUARDAR.equals(botonPulsado)) {
			// Aqui va toda la logica del negocio y todas las llamadas a otras clases.
			datosUsuario = (DatosUsuarioActionForm)request.getSession().getAttribute("datosUsuarioActionForm");
			try {
				OpUsuario.insertar(datosUsuario);
				messages.add("message", new ActionMessage("msg.cliente.guardado"));
				this.vaciarSession(request.getSession());
				comandoDestino = ConstantesComandos.OK;
			} catch (UsuarioNoGuardadoExcepcion e) {
    			messages.add("message", new ActionMessage(e.getMensaje()));
    			this.vaciarSession(request.getSession());
    			comandoDestino = ConstantesComandos.NOOK;
			}
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
