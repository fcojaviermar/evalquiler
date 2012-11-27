package com.evalquiler.actions.usuario;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.evalquiler.actionforms.comun.DatosInicioSesionActionForm;
import com.evalquiler.actionforms.encuesta.DatosRealizacionEncuestaActionForm;
import com.evalquiler.actionforms.usuario.DatosUsuarioActionForm;
import com.evalquiler.actions.comun.ActionBase;
import com.evalquiler.combo.ComboTipoDocumento;
import com.evalquiler.combo.ComboTipoUsuario;
import com.evalquiler.comun.constantes.ConstantesBotones;
import com.evalquiler.comun.constantes.ConstantesComandos;
import com.evalquiler.entidad.ElementoComboTipoDocumento;
import com.evalquiler.entidad.ElementoComboTipoUsuario;
import com.evalquiler.excepciones.ExcepcionEjecutarSentancia;
import com.evalquiler.excepciones.usuario.UsuarioNoExisteExcepcion;
import com.evalquiler.excepciones.usuario.UsuarioRepetidoExcepcion;
import com.evalquiler.operaciones.OpRespuestasEncuesta;
import com.evalquiler.operaciones.OpUsuario;

/**
 * @version 	1.0
 * @author
 */
public class InicioSesionUsuarioAction extends ActionBase {

    public final ActionForward action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws ExcepcionEjecutarSentancia {
    	System.out.println("InicioSesionUsuarioAction.action()");
    	Collection<DatosRealizacionEncuestaActionForm> encuestasRespondidas = null;
    	String comandoDestino = ConstantesComandos.EMPTY;
    	DatosUsuarioActionForm datosUsuario = null;
    	DatosRealizacionEncuestaActionForm datosRealizacionEncuesta = null;
    	ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward(); 
		
		String botonPulsado = request.getParameter(ConstantesBotones.BOTON_PULSADO);
		
		if (ConstantesBotones.REGISTRARSE.equals(botonPulsado)) {
			request.getSession().setAttribute("tipoDocumento", new ComboTipoDocumento());
			request.getSession().setAttribute("tipoUsuario", new ComboTipoUsuario());
			request.getSession().setAttribute("tipoDocumentoSeleccionado", new ElementoComboTipoDocumento() );
			request.getSession().setAttribute("tipoUsuarioSeleccionado", new ElementoComboTipoUsuario() );
			comandoDestino = ConstantesComandos.REGISTER_USER;
			
		} else if (ConstantesBotones.GUARDAR_ENCUESTA.equals(botonPulsado)) {
			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosRealizacionEncuesta.getDatosUsuario());
			request.setAttribute("encuestasRespondidas", encuestasRespondidas);
			comandoDestino = ConstantesComandos.POOL_RECOVERY;
			
		} else if (ConstantesBotones.CANCELAR.equals(botonPulsado)) {
			datosRealizacionEncuesta = (DatosRealizacionEncuestaActionForm)request.getSession().getAttribute("datosRealizacionEncuestaActionForm");
			encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosRealizacionEncuesta.getDatosUsuario());
			request.setAttribute("encuestasRespondidas", encuestasRespondidas);
			comandoDestino = ConstantesComandos.POOL_RECOVERY;
			
		} else if (ConstantesBotones.INICIAR_SESION.equals(botonPulsado)) {
			Collection<DatosUsuarioActionForm> listaUsuario = null;
			try {
				listaUsuario = OpUsuario.consultarPorPk(form);
				Iterator<DatosUsuarioActionForm> iterUsuario = listaUsuario.iterator();
			    
				datosUsuario = (DatosUsuarioActionForm)iterUsuario.next();  
				final String pwd = ((DatosInicioSesionActionForm)form).getPassword(); 
			
				if (pwd.equals(datosUsuario.getPassword())) {
					datosRealizacionEncuesta = new DatosRealizacionEncuestaActionForm();    							
					datosRealizacionEncuesta.setDatosUsuario(datosUsuario);
					
					encuestasRespondidas = OpRespuestasEncuesta.consultarEncuestasRespondidas(datosUsuario);
					request.setAttribute("encuestasRespondidas", encuestasRespondidas);    							
					request.getSession().setAttribute("datosRealizacionEncuestaActionForm", datosRealizacionEncuesta);
					comandoDestino = ConstantesComandos.VALID_USER;
					
				} else {
					errors.add("errorValidacion", new ActionError("error.distinta.password"));
					comandoDestino = ConstantesComandos.NO_EQUAL_PSW;
					
				}
			} catch (UsuarioNoExisteExcepcion e) {
				errors.add("errorValidacion", new ActionError("error.no.existe.usuario"));    				
				comandoDestino = ConstantesComandos.NO_USER;
			} catch (UsuarioRepetidoExcepcion e) {
				errors.add("errorValidacion", new ActionError("error.mas.de.un.usuario"));
				comandoDestino = ConstantesComandos.TWO_EQUAL_USERS;
			}
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
