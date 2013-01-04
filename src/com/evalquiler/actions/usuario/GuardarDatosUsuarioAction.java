package com.evalquiler.actions.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.comun.excepcion.ExcepcionComun;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.usuario.NifUsuarioRepetidoExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioNoGuardadoExcepcion;
import com.evalquiler.operaciones.OpUsuario;

/**
 * @version 	1.0
 * @author
 */
public class GuardarDatosUsuarioAction extends ActionBase

{

    public ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    		throws ExcepcionEjecutarSentancia, ExcepcionComun {
    	
    	System.out.println("GuardarDatosUsuarioAction.action()");
    	DatosUsuarioActionForm datosUsuario = null;
    	String comandoDestino = ConstantesComandos.ERROR;
    	ActionErrors errors = new ActionErrors();
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
				errors.add("message", new ActionError("msg.usuario.guardado"));
				this.vaciarSession(request.getSession());
				comandoDestino = ConstantesComandos.OK;
			} catch (UsuarioNoGuardadoExcepcion e) {
				errors.add("message", new ActionError(e.getMensaje()));
    			this.vaciarSession(request.getSession());
    			comandoDestino = ConstantesComandos.NOOK;
			} catch (NifUsuarioRepetidoExcepcion e) {
				errors.add("message", new ActionError(e.getMensaje()));
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
		}
	
		forward = mapping.findForward(comandoDestino);
		return forward;
    }
}
